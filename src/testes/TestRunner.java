package testes;

import estruturas.*;
import ordenacao.*;
import util.*;
import java.util.Random;

public class TestRunner {

    private static final int[] TAMANHOS = {100, 1000, 10000};
    private static final int REPETICOES = 5;
    private static final Random geradorAleatorio = new Random(42);

    public static void main(String[] args) {
        String[] tiposOrdem = {"ordenado", "inverso", "aleatorio"};

        for (int tamanho : TAMANHOS) {
            int[][] conjuntos = new int[3][];
            conjuntos[0] = Utils.gerarOrdenado(tamanho);
            conjuntos[1] = Utils.gerarInverso(tamanho);
            conjuntos[2] = Utils.gerarAleatorio(tamanho);

            for (int k = 0; k < 3; k++) {
                String ordem = tiposOrdem[k];
                int[] base = conjuntos[k];

                double tVetor = mediaInsercaoVetor(base);
                double tABB = mediaInsercaoABB(base);
                double tAVL = mediaInsercaoAVL(base);

                System.out.printf("%d %s vetor insercao: %.4f ms\n", tamanho, ordem, tVetor);
                System.out.printf("%d %s abb insercao: %.4f ms\n", tamanho, ordem, tABB);
                System.out.printf("%d %s avl insercao: %.4f ms\n", tamanho, ordem, tAVL);

                int primeiro = base[0];
                int ultimo = base[base.length - 1];
                int meio = base[base.length / 2];
                int a1 = base[geradorAleatorio.nextInt(base.length)];
                int a2 = base[geradorAleatorio.nextInt(base.length)];
                int a3 = base[geradorAleatorio.nextInt(base.length)];
                int inexistente = Integer.MAX_VALUE;

                double tSeq = mediaBuscaSequencial(base, primeiro, ultimo, meio, a1, a2, a3, inexistente);
                System.out.printf("%d %s vetor busca_sequencial: %.4f ms\n", tamanho, ordem, tSeq);

                if (k == 0) { 
                    double tBin = mediaBuscaBinaria(base, primeiro, ultimo, meio, a1, a2, a3, inexistente);
                    System.out.printf("%d %s vetor busca_binaria: %.4f ms\n", tamanho, ordem, tBin);
                }

                double tAbbBusca = mediaBuscaAbb(base, primeiro, ultimo, meio, a1, a2, a3, inexistente);
                double tAvlBusca = mediaBuscaAvl(base, primeiro, ultimo, meio, a1, a2, a3, inexistente);

                System.out.printf("%d %s abb busca: %.4f ms\n", tamanho, ordem, tAbbBusca);
                System.out.printf("%d %s avl busca: %.4f ms\n", tamanho, ordem, tAvlBusca);

                double tBubble = mediaOrdenacaoBubble(base);
                double tQuick = mediaOrdenacaoQuick(base);

                System.out.printf("%d %s bubble: %.4f ms\n", tamanho, ordem, tBubble);
                System.out.printf("%d %s quick: %.4f ms\n\n", tamanho, ordem, tQuick);
            }
        }
    }

    private static double mediaInsercaoVetor(int[] base) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            long inicio = Utils.agora();
            Vetor v = new Vetor(base.length + 5);
            for (int x : base) v.inserir(x);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaInsercaoABB(int[] base) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            long inicio = Utils.agora();
            ABB a = new ABB();
            for (int x : base) a.inserir(x);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaInsercaoAVL(int[] base) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            long inicio = Utils.agora();
            AVL a = new AVL();
            for (int x : base) a.inserir(x);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaBuscaSequencial(int[] base, int... chaves) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            Vetor v = new Vetor(base.length + 5);
            for (int x : base) v.inserir(x);
            long inicio = Utils.agora();
            for (int c : chaves) v.buscaSequencial(c);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaBuscaBinaria(int[] base, int... chaves) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            int[] arr = Utils.copiarArray(base); 
            long inicio = Utils.agora();
            for (int c : chaves) buscaBinaria(arr, c);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static int buscaBinaria(int[] a, int chave) {
        int esq = 0, dir = a.length - 1;
        while (esq <= dir) {
            int meio = (esq + dir) >>> 1;
            if (a[meio] == chave) return meio;
            if (a[meio] < chave) esq = meio + 1; else dir = meio - 1;
        }
        return -1;
    }

    private static double mediaBuscaAbb(int[] base, int... chaves) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            ABB a = new ABB();
            for (int x : base) a.inserir(x);
            long inicio = Utils.agora();
            for (int c : chaves) a.busca(c);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaBuscaAvl(int[] base, int... chaves) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            AVL a = new AVL();
            for (int x : base) a.inserir(x);
            long inicio = Utils.agora();
            for (int c : chaves) a.busca(c);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaOrdenacaoBubble(int[] base) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            int[] arr = Utils.copiarArray(base); 
            long inicio = Utils.agora();
            BubbleSort.ordenar(arr);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }

    private static double mediaOrdenacaoQuick(int[] base) {
        double soma = 0;
        for (int r = 0; r < REPETICOES; r++) {
            int[] arr = Utils.copiarArray(base);
            long inicio = Utils.agora();
            QuickSort.ordenar(arr);
            long fim = Utils.agora(); soma += Utils.nanosParaMillis(fim - inicio);
        }
        return soma / REPETICOES;
    }
}
