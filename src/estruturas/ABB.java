package estruturas;

public class ABB {
   private static class No {
      int chave;
      No esquerdo, direito;

      No(int c) {
         chave = c;
      }
   }

   private No raiz;

   public void inserir(int chave) {
      raiz = inserirRecursivo(raiz, chave);
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
