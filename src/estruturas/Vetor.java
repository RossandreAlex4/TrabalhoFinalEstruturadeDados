package estruturas;

public class Vetor {
   private int[] arr;
   private int quantidade;


   public Vetor(int capacidadeInicial) {
      arr = new int[capacidadeInicial];
      quantidade = 0;
   }

   public void inserir(int valor) {
      if (quantidade == arr.length) {
         int[] novoVetor = new int[arr.length * 2];
         System.arraycopy(arr, 0, novoVetor, 0, arr.length);
         arr = novoVetor;
      }
      arr[quantidade++] = valor;
   }


   public int get(int indice) {
      return arr[indice];
   }

   public int tamanho() {
      return quantidade;
   }

   public int buscaSequencial(int chave) {
      for (int i = 0; i < quantidade; i++) {
         if (arr[i] == chave) {
            return i;
         }
      }
      return -1;
   }

   public int buscaBinaria(int chave) {
      int inicio = 0, fim = quantidade - 1;
      while (inicio <= fim) {
         int meio = (inicio + fim) >>> 1;
         if (arr[meio] == chave) {
            return meio;
         }
         if (arr[meio] < chave) {
            inicio = meio + 1;
         } else {
            fim = meio - 1;
         }
      }
      return -1;
   }

   public int[] copiarParaArray() {
      int[] copia = new int[quantidade];
      System.arraycopy(arr, 0, copia, 0, quantidade);
      return copia;
   }
}
