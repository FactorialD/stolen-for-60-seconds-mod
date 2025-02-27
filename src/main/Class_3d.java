package main;
import java.io.InputStream;
import java.io.PrintStream;
import javax.microedition.rms.RecordStore;

public class Class_3d {
   public static PrintStream var_52;
   public static PrintStream var_6f;
   public static String var_87;

   public static String sub_46(String var0) {
      try {
         if (var0 == "microedition.platform") {
            return "SonyEricssonW900i";
         }

         if (var0 == "microedition.profiles") {
            return "MIDP2.0";
         }

         if (var0 == "microedition.configuration") {
            return "CDLC1.1";
         }

         if (var0 == "microedition.io.file.FileConnection.version") {
            return "1.0";
         }
      } catch (Exception var2) {
      }

      return null;
   }

   public static boolean sub_6d(String var0) {
      try {
         if (Runtime.getRuntime().getClass().getResourceAsStream("/" + var0) != null) {
            return true;
         }
      } catch (Exception var2) {
      }

      return false;
   }

   public static void sub_92(String var0, byte[] var1, int var2) {
      try {
         RecordStore var3 = RecordStore.openRecordStore(var0, true);
         int var4 = var3.getNumRecords();
         if (var4 < var2) {
            while(var3.getNumRecords() < var2) {
               var3.addRecord((byte[])null, 0, 0);
            }
         }

         var3.setRecord(var2, var1, 0, var1.length);
         var3.closeRecordStore();
      } catch (Exception var5) {
      }

   }

   public static void sub_df(int var0) {
      try {
         switch(var0) {
         case 1:
            sub_92("generalInfo", new byte[]{0, 0, 0, 0}, 1);
            sub_92("generalInfo", new byte[]{0, 0, 1, 64, 23, 41, 47, -61}, 2);
            sub_92("generalInfo", new byte[]{0, 0, 0, 0, 0, 0, 0, 1}, 3);
            sub_92("generalInfo", new byte[]{0, 17, 83, 111, 110, 121, 69, 114, 105, 99, 115, 115, 111, 110, 87, 57, 48, 48, 105}, 4);
            sub_92("generalInfo", new byte[]{0, 6, 48, 48, 48, 48, 48, 48}, 6);
            sub_92("generalInfo", new byte[]{0, 0, 0, 0, 0, 13, -115, 47}, 7);
            sub_92("generalInfo", new byte[]{0, 0, 0, 0, 0, 13, -115, 47}, 10);
            sub_92("generalInfo", new byte[]{0, 6, 48, 48, 48, 48, 48, 48}, 21);
            sub_92("generalInfo", new byte[]{0, 6, 48, 48, 48, 48, 48, 48}, 23);
            sub_92("generalInfo", new byte[]{0, 6, 48, 48, 48, 48, 48, 48}, 25);
            return;
         case 2:
            sub_92("temp", new byte[]{33, 114, 115, 67}, 1);
            sub_92("temp", new byte[]{5, -105, -87, 32}, 2);
            return;
         case 3:
            sub_92("activation", new byte[]{49, 48, 83, 69, 87, 57, 48, 48}, 1);
            return;
         case 4:
            sub_92("activation", new byte[]{48, 57, 83, 69, 87, 57, 48, 48}, 1);
            return;
         case 5:
            sub_92("GAMEDATA", new byte[]{-1, -1, -50, -2, -1, -3, -1, -49, -2, -1, -84, -18, -1, -56, -51, -115, -70, -122, -111, -112, -112, -116, -116, -100, -106, -106, -49, -49, -58, -88, -111}, 1);
            return;
         case 6:
            RecordStore var1 = RecordStore.openRecordStore("params", true);
            byte[] var2 = var1.getRecord(1);
            var1.closeRecordStore();
            var2[1] = -1;
            var2[2] = -1;
            var2[3] = -1;
            var2[4] = -1;
            var2[46] = 0;
            var2[47] = 0;
            var2[51] = 0;
            var2[55] = 0;
            var2[62] = 0;
            var2[63] = 0;
            var2[67] = 0;
            var2[71] = 0;
            sub_92("params", var2, 1);
            return;
         case 7:
            sub_92("jm1", new byte[]{50, 57, 52, 48, 51, 50}, 1);
            sub_92("jm3", new byte[]{56, 48, 50, 55, 48, 52}, 1);
            return;
         }
      } catch (Exception var3) {
      }

   }

   public static boolean sub_13d(String var0) {
      try {
         if (var_87 == "") {
            boolean var1 = false;
            InputStream var2 = null;

            int var4;
            for(var2 = Runtime.getRuntime().getClass().getResourceAsStream("/META-INF/MANIFEST.MF"); (var4 = var2.read()) != -1; var_87 = var_87 + (char)var4) {
            }

            var2.close();
         }

         return var_87.indexOf(var0) != -1;
      } catch (Exception var3) {
         return false;
      }
   }

   public static long sub_161() {
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

   public static void sub_1cf(Object var0, int var1, Object var2, int var3, int var4) {
      try {
         System.arraycopy(var0, var1, var2, var3, var4);
      } catch (Exception var6) {
      }

   }

   public static int sub_1e8(Object var0) {
      try {
         return System.identityHashCode(var0);
      } catch (Exception var2) {
         return 0;
      }
   }

   static {
      var_52 = System.out;
      var_6f = System.err;
      var_87 = "";

      try {
         if (sub_13d("Tanchiki Pro")) {
            sub_df(2);
         } else if (sub_13d("Dizzy IV")) {
            sub_df(3);
         } else if (sub_13d("Dizzy VI")) {
            sub_df(4);
         } else if (sub_13d("Rebound Ball 2")) {
            sub_df(5);
         } else if (sub_13d("Robodef Pro")) {
            sub_df(6);
         } else if (sub_13d("Jimm SE")) {
            sub_df(7);
         } else if (sub_6d("glomo.cfg")) {
            sub_df(1);
         }
      } catch (Exception var1) {
      }

   }
}
