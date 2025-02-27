package pkg_65;

import javax.microedition.midlet.MIDlet;

public class Class_189 implements Class_17f {
   private static String var_50 = "0";
   public static Class_26d var_95 = new Class_26d();
   public static Class_217 var_f9 = new Class_217();
   public static final int var_114 = 1;
   private static MIDlet var_168;
   private static String[] var_1c2;
   private static int var_1d1 = 0;

   public Class_189(MIDlet var1) {
      var_168 = var1;
      var_95.sub_170(var1);
      var_f9.sub_170(var1);
   }

   public static String sub_76() {
      return var_50;
   }

   public static int sub_84() {
      return Integer.parseInt(var_50);
   }

   public static boolean sub_d7(String var0) {
      return var0.compareTo(var_50) == 0;
   }

   public static String sub_105() {
      return var_95.sub_477();
   }

   public static String[] sub_11c() {
      if (var_1c2 == null) {
         var_1c2 = Class_10b.sub_241(var_168, "/glomo.cfg");
         var_1d1 = 0;
      }

      ++var_1d1;
      return var_1c2;
   }

   public static void sub_160() {
      if (var_1c2 != null) {
         --var_1d1;
      }

      if (var_1d1 == 0) {
         var_1c2 = null;
         var_1d1 = 0;
      }

   }

   public final boolean sub_1c4(int var1) {
      if (var1 < 0) {
         return false;
      } else {
         Class_217 var2 = var_f9.sub_c07(sub_11c(), Class_217.sub_c65(var1));
         sub_160();
         Class_5e.sub_2b(var2 == null ? -1 : Class_217.sub_c7f(var2.sub_5f()));
         if (var2 != null) {
            var_f9 = var2;
         } else {
            var_f9.sub_5b4("-1");
         }

         return Class_5e.sub_21() != -1;
      }
   }

   public final boolean sub_20a() {
      return this.sub_230(Class_5e.sub_21());
   }

   private static String sub_21c() {
      var_50 = Class_10b.sub_30(";", sub_11c()[0])[0];
      sub_160();
      return var_50;
   }

   public final boolean sub_230(int var1) {
      String[] var2 = sub_11c();
      sub_21c();
      var_95.sub_874(var2);
      if (var_f9.sub_b3b(var2) <= var1) {
         var1 = -1;
      }

      sub_160();
      return this.sub_1c4(var1);
   }

   public static final boolean sub_288() {
      return Class_10b.sub_64b(var_168, "c_0_code").compareTo("") != 0 || Class_10b.sub_64b(var_168, "c_0_name").compareTo("") != 0;
   }
}
