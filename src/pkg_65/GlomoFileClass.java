package pkg_65;

import java.util.Date;
import java.util.Vector;
import javax.microedition.midlet.MIDlet;

public final class GlomoFileClass {
   private int var_49 = 0;
   private String var_9b = "";
   public Class_189 var_f1;

   public GlomoFileClass(MIDlet var1) {
      this.var_f1 = new Class_189(var1);
      this.var_f1.sub_20a();
      this.sub_497();
   }

   public static String sub_60(MIDlet var0, String[] var1) {
      String var2 = "";

      try {
         int var4;
         for(var4 = 0; var4 < var1.length && var2 == ""; ++var4) {
            String var3;
            if ((var3 = var0.getAppProperty("MIDlet-" + String.valueOf(var4 + 1))) == null) {
               var2 = var2 + "+midlet1";
            } else if (var3.trim().compareTo(var1[var4].trim()) != 0) {
               var2 = var2 + "+midlet2";
            }
         }

         if (var0.getAppProperty("MIDlet-" + String.valueOf(var4 + 1)) != null) {
            var2 = var2 + "+midlet3";
         }
      } catch (Exception var9) {
         var2 = var2 + "+midlet4";
      }

      long var5 = Class_5e.sub_101();
      long var7 = Class_5e.sub_824();
      if (Class_5e.sub_1a5() == 1L) {
         Class_5e.sub_1ec();
      } else {
         if (Class_5e.sub_1b7() > 100000L) {
            var2 = var2 + "+runs";
         }

         if (Class_5e.sub_247().compareTo(main.Class_3d.sub_46("microedition.platform")) != 0) {
            var2 = var2 + "+platform";
         }

         if (var7 - var5 > 2000L) {
            var2 = var2 + "+lm";
            Class_5e.var_16 = false;
            Class_5e.sub_13a(var5);
            Class_5e.sub_2ec("000000");
         }
      }

      return var2;
   }

   public static boolean sub_88() {
      long var0 = Class_5e.sub_101();
      long var2 = Class_5e.sub_824();
      return var0 == 0L || var2 >= var0 && var2 - var0 < 500L;
   }

   public final boolean sub_ae(int var1) {
      return this.var_f1.sub_1c4(var1);
   }

   public final Vector sub_e4() {
      return Class_217.var_76;
   }

   public final Class_217 sub_f0() {
      return Class_189.var_f9;
   }

   public final String sub_14c() {
      return this.sub_174("");
   }

   public final String sub_174(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      if (this.sub_8ff() == -1) {
         this.sub_911(0);
      }

      long var2 = Class_5e.sub_71();
      String var4;
      if ((var4 = Class_10b.sub_3c0(0, Class_189.var_f9.sub_125(), var2 != 0L ? var2 : Class_5e.sub_d3(Class_10b.sub_360(0)))).compareTo("") == 0) {
         this.var_49 = 1;
         this.var_9b = Class_17f.var_1656[this.var_49];
      }

      return (var4.compareTo("") == 0 ? "" : var4 + (var1.compareTo("") == 0 ? "" : Class_189.var_95.sub_436() + var1)).toLowerCase();
   }

   public final String sub_1d7(int var1) {
      return this.sub_1f1(var1, "");
   }

   public final String sub_1f1(int var1, String var2) {
      if (var2 == null) {
         var2 = "";
      }

      long var3 = Class_5e.sub_27d();
      String var5;
      return ((var5 = Class_10b.sub_3c0(var1, Class_189.var_f9.sub_1de(var1), var3 != 0L ? var3 : Class_5e.sub_2df(Class_10b.sub_360(0)))).compareTo("") == 0 ? "" : var5 + (var2.compareTo("") == 0 ? "" : Class_189.var_95.sub_436() + var2)).toLowerCase();
   }

   public final boolean sub_229() {
      return this.sub_286("");
   }

   public final boolean sub_286(String var1) {
      this.sub_911(0);
      return this.sub_75c(Class_189.var_f9.sub_241(), this.sub_174(var1));
   }

   public final boolean sub_2aa(int var1) {
      return this.sub_2d7(var1, "");
   }

   public final boolean sub_2d7(int var1, String var2) {
      boolean var3;
      if (var3 = this.sub_911(var1) == var1) {
         var3 = this.sub_75c(Class_189.var_f9.sub_2f6(var1), this.sub_1f1(var1, var2));
      }

      return var3;
   }

   public final boolean sub_316(String var1) {
      return this.sub_357(var1, this.sub_8ff());
   }

   public final boolean sub_357(String var1, int var2) {
      boolean var3;
      if (var3 = !this.sub_54a() && var2 >= 0 && var1 != null && var1.compareTo("") != 0) {
         Class_5e.sub_2ec(var1);
         if (var2 == 0) {
            var3 = this.sub_40b();
         } else if (var2 != 5 && var2 != 6 && var2 != 7 && var2 != 8) {
            var3 = false;
         } else if (var3 = this.sub_4bf(false)) {
            if (this.sub_4dc() == 0) {
               Date var4;
               Date var10000 = var4 = new Date();
               var10000.setTime(var10000.getTime() + Long.parseLong(this.sub_f0().sub_454(var2)) * 24L * 60L * 60L * 1000L);
               Class_5e.sub_512(var4.getTime());
            } else if (this.sub_4dc() == 1) {
               Class_5e.sub_2df(0L);
            }
         }

         if (!var3) {
            Class_5e.sub_2ec("");
         }
      }

      return var3;
   }

   public final boolean sub_3a7() {
      return this.sub_40b();
   }

   public final boolean sub_40b() {
      boolean var1 = false;

      try {
         var1 = Long.parseLong(Class_10b.sub_604(Class_5e.sub_30e(), 0)) == Class_5e.sub_71();
      } catch (Exception var2) {
      }

      return var1;
   }

   public final boolean sub_497() {
      return this.sub_4bf(true);
   }

   public final boolean sub_4bf(boolean var1) {
      boolean var2 = false;

      try {
         var2 = Long.parseLong(Class_10b.sub_604(Class_5e.sub_30e(), 0)) == Class_5e.sub_27d();
      } catch (Exception var3) {
      }

      var1 = this.sub_4dc() != 1 && var1 ? (new Date()).getTime() <= Class_5e.sub_4b2() : true;
      return var2 && var1;
   }

   public final int sub_4dc() {
      return Class_5e.sub_342();
   }

   public final int sub_53c(int var1) {
      return Class_5e.sub_361(var1);
   }

   public final boolean sub_54a() {
      return this.sub_40b() || this.sub_497();
   }

   public final String sub_5a0(int var1) {
      return this.sub_5d7(var1, "");
   }

   public final String sub_5d7(int var1, String var2) {
      return this.sub_618(var1, var2, Class_10b.sub_360(0));
   }

   public final String sub_618(int var1, String var2, long var3) {
      if (var2 == null) {
         var2 = "";
      }

      String var5;
      return ((var5 = Class_10b.sub_3c0(var1, Class_189.var_f9.sub_173(var1), var3)).compareTo("") == 0 ? "" : var5 + (var2.compareTo("") == 0 ? "" : Class_189.var_95.sub_436() + var2)).toLowerCase();
   }

   public final boolean sub_62b(int var1) {
      return this.sub_6b0(var1, false, "");
   }

   public final boolean sub_687(int var1, String var2) {
      return this.sub_6b0(var1, false, var2);
   }

   public final boolean sub_697(int var1, boolean var2) {
      return this.sub_6b0(var1, var2, "");
   }

   public final boolean sub_6b0(int var1, boolean var2, String var3) {
      long var4 = Class_10b.sub_360(0);
      long var6 = var4;
      String var8 = this.sub_618(var1, var3, var4);
      if (this.sub_75c(Class_189.var_f9.sub_2e8(var1), var8)) {
         if (var2) {
            Class_5e.sub_3b3(var6, var1);
         }

         return true;
      } else {
         return false;
      }
   }

   public final boolean sub_6c1(String var1) {
      return Class_5e.sub_64e(Long.parseLong(var1)) != 0L;
   }

   public final int sub_725(String var1) {
      return (int)(Class_5e.sub_64e(Long.parseLong(var1)) % 10L);
   }

   public final boolean sub_75c(String var1, String var2) {
      boolean var3 = false;

      try {
         if (var2.compareTo("") == 0) {
            this.var_49 = 1;
            this.var_9b = Class_17f.var_1656[this.var_49];
         } else {
            var3 = Class_b7.sub_31(var1, var2);
         }
      } catch (Exception var4) {
         var3 = false;
      }

      return var3;
   }

   public final String sub_786() {
      return Class_189.var_95.sub_ec();
   }

   public final String sub_7b3() {
      return Class_189.var_95.sub_17b();
   }

   public final String sub_7be() {
      return Class_189.var_95.sub_197();
   }

   public final String sub_7d1() {
      return Class_189.var_95.sub_18d();
   }

   public final boolean sub_7e9(String var1) {
      return this.sub_83c(var1, false);
   }

   public final boolean sub_83c(String var1, boolean var2) {
      boolean var4;
      try {
         if ((var4 = Class_b7.sub_31(var1, this.sub_786())) && var2) {
            Class_5e.sub_403();
         }
      } catch (Exception var3) {
         var4 = false;
      }

      return var4;
   }

   public final int sub_89b() {
      return Class_5e.sub_467();
   }

   public final long sub_8b7() {
      return Class_5e.sub_4b2();
   }

   public final int sub_8ff() {
      return Class_5e.sub_5bc();
   }

   public final int sub_911(int var1) {
      return Class_5e.sub_55d(var1);
   }

   public final int sub_91f() {
      return Integer.parseInt(Class_189.var_95.sub_27f());
   }

   public final int sub_978() {
      return Integer.parseInt(Class_189.var_95.sub_2d4());
   }

   public final int sub_9bb() {
      return this.sub_a1f(this.sub_8ff());
   }

   public final int sub_a1f(int var1) {
      String var2 = String.valueOf(this.sub_91f());
      if (var1 == 5) {
         var2 = Class_189.var_95.sub_325();
      } else if (var1 == 6) {
         var2 = Class_189.var_95.sub_399();
      } else if (var1 == 7) {
         var2 = Class_189.var_95.sub_3c3();
      } else if (var1 == 8) {
         var2 = Class_189.var_95.sub_3f7();
      }

      return Integer.parseInt(var2);
   }

   public static final String sub_a69() {
      return "1";
   }

   public final String sub_aa1() {
      return Class_189.sub_76();
   }

   public final String sub_ad5() {
      return Class_189.sub_105();
   }

   public final int sub_b23() {
      return Class_5e.sub_62c();
   }

   public final int sub_b65(int var1) {
      return Class_5e.sub_5cb(var1);
   }

   public final int sub_b72() {
      return this.var_49;
   }

   public final String sub_bb0() {
      return this.var_9b;
   }
}
