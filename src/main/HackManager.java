package main;

public class HackManager {

   public static long currentTimeMillis() {
      try {
         return System.currentTimeMillis();
      } catch (Exception var1) {
         return 0L;
      }
   }

   public static void callGc() {
      try {
         System.gc();
      } catch (Exception var1) {
      }

   }

   public static void arrayCopy(Object var0, int var1, Object var2, int var3, int var4) {
      try {
         System.arraycopy(var0, var1, var2, var3, var4);
      } catch (Exception var6) {
      }

   }

   public static int hashCode(Object var0) {
      try {
         return System.identityHashCode(var0);
      } catch (Exception var2) {
         return 0;
      }
   }

}
