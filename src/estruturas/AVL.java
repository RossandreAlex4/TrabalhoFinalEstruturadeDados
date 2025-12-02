package estruturas;

public class AVL {
   private static class No {
      int chave, altura;
      No esquerdo, direito;

      No(int c) {
         chave = c;
         altura = 1;
      }
   }

   private No raiz;

   public void inserir(int chave) {
      raiz = inserirRecursivo(raiz, chave);
   }

   private int alturaNo(No n) {
      return n == null ? 0 : n.altura;
   }

   private int fatorBalanceamento(No n) {
      return n == null ? 0 : alturaNo(n.esquerdo) - alturaNo(n.direito);
   }

   private No rotacaoDireita(No y) {
      No x = y.esquerdo;
      No T2 = x.direito;

      x.direito = y;
      y.esquerdo = T2;

      y.altura = Math.max(alturaNo(y.esquerdo), alturaNo(y.direito)) + 1;
      x.altura = Math.max(alturaNo(x.esquerdo), alturaNo(x.direito)) + 1;

      return x;
   }

   private No rotacaoEsquerda(No x) {
      No y = x.direito;
      No T2 = y.esquerdo;

      y.esquerdo = x;
      x.direito = T2;

      x.altura = Math.max(alturaNo(x.esquerdo), alturaNo(x.direito)) + 1;
      y.altura = Math.max(alturaNo(y.esquerdo), alturaNo(y.direito)) + 1;

      return y;
   }

   private No inserirRecursivo(No no, int chave) {
      if (no == null) {
         return new No(chave);
      }

      if (chave < no.chave) {
         no.esquerdo = inserirRecursivo(no.esquerdo, chave);
      } else {
         no.direito = inserirRecursivo(no.direito, chave);
      }

      no.altura = 1 + Math.max(alturaNo(no.esquerdo), alturaNo(no.direito));

      int balanceamento = fatorBalanceamento(no);

      if (balanceamento > 1 && chave < no.esquerdo.chave) {
         return rotacaoDireita(no);
      }

      if (balanceamento < -1 && chave > no.direito.chave) {
         return rotacaoEsquerda(no);
      }

      if (balanceamento > 1 && chave > no.esquerdo.chave) {
         no.esquerdo = rotacaoEsquerda(no.esquerdo);
         return rotacaoDireita(no);
      }

      if (balanceamento < -1 && chave < no.direito.chave) {
         no.direito = rotacaoDireita(no.direito);
         return rotacaoEsquerda(no);
      }

      return no;
   }

   public boolean busca(int chave) {
      return buscarRecursivo(raiz, chave);
   }

   private boolean buscarRecursivo(No no, int chave) {
      if (no == null) {
         return false;
      }
      if (no.chave == chave) {
         return true;
      }
      return chave < no.chave ? buscarRecursivo(no.esquerdo, chave) : buscarRecursivo(no.direito, chave);
   }
}
