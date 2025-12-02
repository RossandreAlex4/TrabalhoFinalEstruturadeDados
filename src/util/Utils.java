package util;

import java.util.Random;
import java.util.Arrays;


public class Utils {
   private static final Random geradorAleatorio = new Random(12345);

   public static int[] gerarOrdenado(int n) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = i + 1;
      }
      return arr;
   }

   public static int[] gerarInverso(int n) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
         arr[i] = n - i;
      }
      return arr;
   }

   public static int[] gerarAleatorio(int n) {
      int[] arr = gerarOrdenado(n);
      for (int i = n - 1; i > 0; i--) {
         int j = geradorAleatorio.nextInt(i + 1);
         int temporario = arr[i];
         arr[i] = arr[j];
         arr[j] = temporario;
      }
      return arr;
   }

   public static long agora() {
      return System.nanoTime();
   }

   public static double nanosParaMillis(double nanos) {
      return nanos / 1_000_000.0;
   }

   public static int[] copiarArray(int[] a) {
      return Arrays.copyOf(a, a.length);
   }
}
