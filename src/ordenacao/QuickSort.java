package ordenacao;

public class QuickSort {
   public static void ordenar(int[] arr) {
      quick(arr, 0, arr.length - 1);
   }

   private static void quick(int[] arr, int esq, int dir) {
      if (esq >= dir) {
         return;
      }
      int pivo = particionar(arr, esq, dir);
      quick(arr, esq, pivo - 1);
      quick(arr, pivo + 1, dir);
   }

   private static int particionar(int[] arr, int esq, int dir) {
      int valorPivo = arr[dir];
      int i = esq - 1;
      for (int j = esq; j < dir; j++) {
         if (arr[j] <= valorPivo) {
            i++;
            int temporario = arr[i];
            arr[i] = arr[j];
            arr[j] = temporario;
         }
      }
      int temporario = arr[i + 1];
      arr[i + 1] = arr[dir];
      arr[dir] = temporario;
      return i + 1;
   }
}
