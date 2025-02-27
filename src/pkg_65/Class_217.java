package pkg_65;

import java.util.Hashtable;
import java.util.Vector;

public class Class_217 extends Class_1d6 {
   public static final Vector var_76 = new Vector(0);
   public static final Hashtable var_11c = new Hashtable(0);
   public static final Hashtable var_139 = new Hashtable(0);
   public static final Hashtable var_19a = new Hashtable(0);
   public static final Hashtable var_1db = new Hashtable(4);

   public Class_217() {
      String[] var1 = new String[]{"name", "prefix", "numReg", "priceReg", "prefix_bonus1", "numBonus1", "priceBonus1", "prefix_spec", "numSpec", "priceSpec", "prefix_subscribe_type1", "numSubscribeType1", "priceSubscribeType1", "durationSubscribeType1", "prefix_subscribe_type2", "numSubscribeType2", "priceSubscribeType2", "durationSubscribeType2", "prefix_subscribe_type3", "numSubscribeType3", "priceSubscribeType3", "durationSubscribeType3", "prefix_subscribe_type4", "numSubscribeType4", "priceSubscribeType4", "durationSubscribeType4", "specParam1", "specParam2", "specParam3", "specParam4"};
      String var2 = "name,pfxReg,snReg,priceReg,pfxBns1,snBns1,priceBns1,pfxSpec,snSpec,priceSpec,pfxSub1,snSub1,priceSub1,prmSub1,pfxSub2,snSub2,priceSub2,prmSub2,pfxSub3,snSub3,priceSub3,prmSub3,pfxSub4,snSub4,priceSub4,prmSub4,param1,param2,param3,param4";
      String[] var3 = new String[]{"name", "code", "prefix", "numReg", "priceReg", "paramReg", "prefix_bonus1", "numBonus1", "priceBonus1", "paramBonus1", "prefix_bonus2", "numBonus2", "priceBonus2", "paramBonus2", "prefix_bonus3", "numBonus3", "priceBonus3", "paramBonus3", "prefix_bonus4", "numBonus4", "priceBonus4", "paramBonus4", "prefix_subscribe_type1", "numSubscribeType1", "priceSubscribeType1", "durationSubscribeType1", "prefix_subscribe_type2", "numSubscribeType2", "priceSubscribeType2", "durationSubscribeType2", "prefix_subscribe_type3", "numSubscribeType3", "priceSubscribeType3", "durationSubscribeType3", "prefix_subscribe_type4", "numSubscribeType4", "priceSubscribeType4", "durationSubscribeType4", "prefix_spec", "numSpec", "priceSpec", "paramSpec", "specParam1", "specParam2", "specParam3", "specParam4"};
      String var4 = "name,code,pfxReg,snReg,priceReg,prmReg,pfxBns1,snBns1,priceBns1,prmBns1,pfxBns2,snBns2,priceBns2,prmBns2,pfxBns3,snBns3,priceBns3,prmBns3,pfxBns4,snBns4,priceBns4,prmBns4,pfxSub1,snSub1,priceSub1,prmSub1,pfxSub2,snSub2,priceSub2,prmSub2,pfxSub3,snSub3,priceSub3,prmSub3,pfxSub4,snSub4,priceSub4,prmSub4,pfxSpec,snSpec,priceSpec,prmSpec,param1,param2,param3,param4";
      if (!var_1db.contains("CFG_1")) {
         var_1db.put("CFG_1", var1);
      }

      if (!var_1db.contains("JAD_1")) {
         var_1db.put("JAD_1", Class_10b.sub_30(",", var2));
      }

      if (!var_1db.contains("CFG_2")) {
         var_1db.put("CFG_2", var3);
      }

      if (!var_1db.contains("JAD_2")) {
         var_1db.put("JAD_2", Class_10b.sub_30(",", var4));
      }

      this.sub_5b4("-1");
      this.sub_609("Russia");
      this.sub_630("");
      this.sub_682("BOMB");
      this.sub_748("1132");
      this.sub_7fa("94.00 RUR ex. VAT");
      this.sub_87a("");
      this.sub_6da(1, "BOMB");
      this.sub_770(1, "1132");
      this.sub_815(1, "7.50 RUR ex. VAT");
      this.sub_8d1(1, "");
      this.sub_68d("SPEC");
      this.sub_7a0("1136");
      this.sub_83d("50 RUR ex.VAT");
      this.sub_92e("");
      this.sub_72d(5, "SUB1");
      this.sub_7ed(5, "1133");
      this.sub_84b(5, "5.00 RUR ex. VAT");
      this.sub_857(5, "1");
      this.sub_72d(6, "SUB2");
      this.sub_7ed(6, "1134");
      this.sub_84b(6, "25.00 RUR ex. VAT");
      this.sub_857(6, "7");
      this.sub_72d(7, "SUB3");
      this.sub_7ed(7, "1135");
      this.sub_84b(7, "50.00 RUR ex. VAT");
      this.sub_857(7, "14");
      this.sub_72d(8, "SUB4");
      this.sub_7ed(8, "1137");
      this.sub_84b(8, "100.00 RUR ex. VAT");
      this.sub_857(8, "30");
      this.sub_95e("");
      this.sub_9b5("");
      this.sub_9cf("");
      this.sub_9d9("");
   }

   public final String sub_1f() {
      return this.sub_26("id");
   }

   public final int sub_5f() {
      return this.sub_ef("id");
   }

   public final String sub_af() {
      return this.sub_26("name");
   }

   public final String sub_f5() {
      return this.sub_26("code");
   }

   public final String sub_125() {
      return this.sub_26("prefix");
   }

   public final String sub_141() {
      return this.sub_173(1);
   }

   public final String sub_173(int var1) {
      return this.sub_26(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "prefix_bonus2" : (var1 == 3 ? "prefix_bonus3" : (var1 == 4 ? "prefix_bonus4" : "prefix_bonus1"))) : "prefix_bonus1");
   }

   public final String sub_18a() {
      return this.sub_26("prefix_spec");
   }

   public final String sub_1de(int var1) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "prefix_subscribe_type2";
            return this.sub_26(var10001);
         }

         if (var1 == 7) {
            var10001 = "prefix_subscribe_type3";
            return this.sub_26(var10001);
         }

         if (var1 == 8) {
            var10001 = "prefix_subscribe_type4";
            return this.sub_26(var10001);
         }
      }

      var10001 = "prefix_subscribe_type1";
      return this.sub_26(var10001);
   }

   public final String sub_241() {
      return this.sub_26("numReg");
   }

   public final String sub_296() {
      return this.sub_2e8(1);
   }

   public final String sub_2e8(int var1) {
      return this.sub_26(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "numBonus2" : (var1 == 3 ? "numBonus3" : (var1 == 4 ? "numBonus4" : "numBonus1"))) : "numBonus1");
   }

   public final String sub_2f6(int var1) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "numSubscribeType2";
            return this.sub_26(var10001);
         }

         if (var1 == 7) {
            var10001 = "numSubscribeType3";
            return this.sub_26(var10001);
         }

         if (var1 == 8) {
            var10001 = "numSubscribeType4";
            return this.sub_26(var10001);
         }
      }

      var10001 = "numSubscribeType1";
      return this.sub_26(var10001);
   }

   public final String sub_315() {
      return this.sub_26("numSpec");
   }

   public final String sub_323() {
      return this.sub_26("priceReg");
   }

   public final String sub_380() {
      return this.sub_392(1);
   }

   public final String sub_392(int var1) {
      return this.sub_26(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "priceBonus2" : (var1 == 3 ? "priceBonus3" : (var1 == 4 ? "priceBonus4" : "priceBonus1"))) : "priceBonus1");
   }

   public final String sub_3e7(int var1) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "priceSubscribeType2";
            return this.sub_26(var10001);
         }

         if (var1 == 7) {
            var10001 = "priceSubscribeType3";
            return this.sub_26(var10001);
         }

         if (var1 == 8) {
            var10001 = "priceSubscribeType4";
            return this.sub_26(var10001);
         }
      }

      var10001 = "priceSubscribeType1";
      return this.sub_26(var10001);
   }

   public final String sub_415() {
      return this.sub_26("priceSpec");
   }

   public final String sub_454(int var1) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "durationSubscribeType2";
            return this.sub_26(var10001);
         }

         if (var1 == 7) {
            var10001 = "durationSubscribeType3";
            return this.sub_26(var10001);
         }

         if (var1 == 8) {
            var10001 = "durationSubscribeType4";
            return this.sub_26(var10001);
         }
      }

      var10001 = "durationSubscribeType1";
      return this.sub_26(var10001);
   }

   public final String sub_465() {
      return this.sub_26("paramReg");
   }

   public final String sub_470(int var1) {
      return this.sub_26(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "paramBonus2" : (var1 == 3 ? "paramBonus3" : (var1 == 4 ? "paramBonus4" : "paramBonus1"))) : "paramBonus1");
   }

   public final String sub_4ab() {
      return this.sub_26("paramSpec");
   }

   public final String sub_4be() {
      return this.sub_26("specParam1");
   }

   public final String sub_4f1() {
      return this.sub_26("specParam2");
   }

   public final String sub_554() {
      return this.sub_26("specParam3");
   }

   public final String sub_55e() {
      return this.sub_26("specParam4");
   }

   public final String sub_5b4(String var1) {
      return this.sub_63("id", var1);
   }

   public final String sub_609(String var1) {
      return this.sub_63("name", var1);
   }

   public final String sub_630(String var1) {
      return this.sub_63("code", var1);
   }

   public final String sub_682(String var1) {
      return this.sub_63("prefix", var1);
   }

   public final String sub_68d(String var1) {
      return this.sub_63("prefix_spec", var1);
   }

   public final String sub_6da(int var1, String var2) {
      return this.sub_63(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "prefix_bonus2" : (var1 == 3 ? "prefix_bonus3" : (var1 == 4 ? "prefix_bonus4" : "prefix_bonus1"))) : "prefix_bonus1", var2);
   }

   public final String sub_72d(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "prefix_subscribe_type2";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "prefix_subscribe_type3";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "prefix_subscribe_type4";
            return this.sub_63(var10001, var2);
         }
      }

      var10001 = "prefix_subscribe_type1";
      return this.sub_63(var10001, var2);
   }

   public final String sub_748(String var1) {
      return this.sub_63("numReg", var1);
   }

   public final String sub_770(int var1, String var2) {
      return this.sub_63(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "numBonus2" : (var1 == 3 ? "numBonus3" : (var1 == 4 ? "numBonus4" : "numBonus1"))) : "numBonus1", var2);
   }

   public final String sub_7a0(String var1) {
      return this.sub_63("numSpec", var1);
   }

   public final String sub_7ed(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "numSubscribeType2";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "numSubscribeType3";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "numSubscribeType4";
            return this.sub_63(var10001, var2);
         }
      }

      var10001 = "numSubscribeType1";
      return this.sub_63(var10001, var2);
   }

   public final String sub_7fa(String var1) {
      return this.sub_63("priceReg", var1);
   }

   public final String sub_815(int var1, String var2) {
      return this.sub_63(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "priceBonus2" : (var1 == 3 ? "priceBonus3" : (var1 == 4 ? "priceBonus4" : "priceBonus1"))) : "priceBonus1", var2);
   }

   public final String sub_83d(String var1) {
      return this.sub_63("priceSpec", var1);
   }

   public final String sub_84b(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "priceSubscribeType2";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "priceSubscribeType3";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "priceSubscribeType4";
            return this.sub_63(var10001, var2);
         }
      }

      var10001 = "priceSubscribeType1";
      return this.sub_63(var10001, var2);
   }

   public final String sub_857(int var1, String var2) {
      String var10001;
      if (var1 != 5) {
         if (var1 == 6) {
            var10001 = "durationSubscribeType2";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 7) {
            var10001 = "durationSubscribeType3";
            return this.sub_63(var10001, var2);
         }

         if (var1 == 8) {
            var10001 = "durationSubscribeType4";
            return this.sub_63(var10001, var2);
         }
      }

      var10001 = "durationSubscribeType1";
      return this.sub_63(var10001, var2);
   }

   public final String sub_87a(String var1) {
      return this.sub_63("paramReg", var1);
   }

   public final String sub_8d1(int var1, String var2) {
      return this.sub_63(!Class_189.sub_d7("1") && var1 != 1 ? (var1 == 2 ? "paramBonus2" : (var1 == 3 ? "paramBonus3" : (var1 == 4 ? "paramBonus4" : "paramBonus1"))) : "paramBonus1", var2);
   }

   public final String sub_92e(String var1) {
      return this.sub_63("paramSpec", var1);
   }

   public final String sub_95e(String var1) {
      return this.sub_63("specParam1", var1);
   }

   public final String sub_9b5(String var1) {
      return this.sub_63("specParam2", var1);
   }

   public final String sub_9cf(String var1) {
      return this.sub_63("specParam3", var1);
   }

   public final String sub_9d9(String var1) {
      return this.sub_63("specParam4", var1);
   }

   public final int sub_a37(Class_217 var1, int var2) {
      return this.sub_a5d(var1.sub_5f(), var2, var1.sub_af(), var1.sub_f5());
   }

   public final int sub_a5d(int var1, int var2, String var3, String var4) {
      int var5 = var_76.size();
      var_76.setSize(var5 + 1);
      var_76.setElementAt(new Class_1b(var1, var3, var4), var5);
      var_11c.put(new Integer(Class_189.sub_288() ? var2 : var1), new Integer(var5));
      return var5;
   }

   public final int sub_aa2(int var1) {
      if (var1 >= 0 && var1 < var_76.size()) {
         Class_1b var2 = (Class_1b)var_76.elementAt(var1);
         var_139.put(var2.sub_10(), new Integer(var2.sub_8c()));
         var_19a.put(var2.sub_1b(), new Integer(var2.sub_8c()));
         return var1;
      } else {
         return -1;
      }
   }

   public final Class_217 sub_ad6(int var1, String[] var2) {
      this.sub_5b4(String.valueOf(var1));
      this.sub_1ea((String[])var_1db.get("CFG_" + Class_189.sub_76()), var2);
      return this;
   }

   public final int sub_b0b(String[] var1) {
      this.sub_b28(var1);
      this.sub_cc2();

      String var2;
      String var3;
      for(int var4 = 0; ((var2 = this.sub_1b0("c_" + String.valueOf(var4) + "_code")) + (var3 = this.sub_1b0("c_" + String.valueOf(var4) + "_name"))).compareTo("") != 0; ++var4) {
         int var6 = -1;
         Class_217 var5;
         if (null != (var5 = this.sub_b56(var1, var3, var2))) {
            var6 = var5.sub_5f();
         }

         if (var3.compareTo("") == 0) {
            var3 = var5 != null ? var5.sub_af() : var2;
         } else if (var2.compareTo("") == 0) {
            var2 = var5 != null ? var5.sub_f5() : var3;
         }

         main.Class_3d.var_6f.println("name = " + var3 + " code = " + var2);
         ((Class_1b)var_76.elementAt(this.sub_a5d(var4, var6, var3, var2))).sub_110(var6);
      }

      return var_76.size();
   }

   public final int sub_b28(String[] var1) {
      Class_217 var2 = new Class_217();
      this.sub_cc2();
      this.sub_ce3();

      for(int var4 = 1; var4 < var1.length; ++var4) {
         String[] var3 = Class_10b.sub_30(";", var1[var4]);
         var2.sub_ad6(var4, var3);
         if (var3.length > 1) {
            this.sub_aa2(this.sub_a37(var2, var2.sub_5f()));
         }
      }

      return var_76.size();
   }

   public final int sub_b3b(String[] var1) {
      return Class_189.sub_288() ? this.sub_b0b(var1) : this.sub_b28(var1);
   }

   public final Class_217 sub_b56(String[] var1, String var2, String var3) {
      int var4 = -1;
      if (var3.compareTo("") != 0 && var_19a.containsKey(var3)) {
         var4 = ((Integer)var_19a.get(var3)).intValue();
      } else if (var2.compareTo("") != 0 && var_139.containsKey(var2)) {
         var4 = ((Integer)var_139.get(var2)).intValue();
      }

      return var4 >= 0 ? this.sub_ba7(var1, var4) : null;
   }

   public final Class_1b sub_b6b(int var1) {
      return (Class_1b)var_76.elementAt(((Integer)var_11c.get(new Integer(var1))).intValue());
   }

   public final Class_217 sub_ba7(String[] var1, int var2) {
      if (var2 < var1.length && var2 >= 0) {
         Class_217 var3;
         (var3 = new Class_217()).sub_170(this.var_4a);
         var3.sub_ad6(var2, Class_10b.sub_30(";", var1[var2]));
         return var3;
      } else {
         return null;
      }
   }

   public final Class_217 sub_c07(String[] var1, int var2) {
      if (Class_189.sub_288()) {
         int var3 = var2;
         Class_217 var8 = this;
         if (var2 < 0) {
            return null;
         } else {
            Class_217 var10 = this.sub_ba7(var1, this.sub_b6b(var2).sub_c6());
            String[] var4 = (String[])var_1db.get("JAD_" + Class_189.sub_76());
            String[] var5 = (String[])var_1db.get("CFG_" + Class_189.sub_76());

            for(int var6 = 0; var6 < var4.length; ++var6) {
               String var7;
               if ((var7 = var8.sub_1b0("c_" + String.valueOf((Integer)var_11c.get(new Integer(var3))) + "_" + var4[var6])).compareTo("") != 0) {
                  var10.sub_63(var5[var6], var7);
               }
            }

            return var10;
         }
      } else {
         return this.sub_ba7(var1, var2);
      }
   }

   public static final int sub_c65(int var0) {
      if (var0 >= 0 && var0 < var_76.size()) {
         return Class_189.sub_288() ? ((Class_1b)var_76.elementAt(var0)).sub_c6() : ((Class_1b)var_76.elementAt(var0)).sub_8c();
      } else {
         return -1;
      }
   }

   public static final int sub_c7f(int var0) {
      Integer var1;
      return (var1 = (Integer)var_11c.get(new Integer(var0))) == null ? -1 : var1.intValue();
   }

   public final void sub_cc2() {
      var_76.setSize(0);
      var_11c.clear();
   }

   public final void sub_ce3() {
      var_19a.clear();
      var_139.clear();
   }
}
