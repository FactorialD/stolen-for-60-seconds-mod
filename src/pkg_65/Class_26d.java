package pkg_65;

import java.util.Hashtable;

public class Class_26d extends Class_1d6 {
   public Hashtable var_19 = new Hashtable(4);

   public Class_26d() {
      String[] var1 = new String[]{"", "DistID", "SubDistID", "DistName", "DistWWW", "DistWWWTitle", "DistMoreGamesLink", "DistMoreGamesTitle", "DistLetter", "DistFlags", "RegisterSizeKey", "BonusSizeKey", "RegisterSizeKeyType1", "RegisterSizeKeyType2", "RegisterSizeKeyType3", "RegisterSizeKeyType4", "TailSeparator", "SmsKeyVersion"};
      String[] var2 = Class_10b.sub_30(",", ",id,chId,name,glink,glinkTtl,mglink,mglinkTtl,pflag,gflag,kszReg,kszBns,kszSub1,kszSub2,kszSub3,kszSub4,tailSepar,smsKeyVer");
      this.var_19.put("CFG_1", var1);
      this.var_19.put("JAD_1", var2);
      this.var_19.put("CFG_2", var1);
      this.var_19.put("JAD_2", var2);
      this.sub_4b6("0001");
      this.sub_514("00");
      this.sub_544("GlowingMobile");
      this.sub_58b("www.glowingmobile.com");
      this.sub_55f("Game link title");
      this.sub_59c("www.glomogames.com");
      this.sub_5af("More games");
      this.sub_5e3("A");
      this.sub_613("FLAG");
      this.sub_655("6");
      this.sub_681("4");
      this.sub_6a4("6");
      this.sub_6c3("6");
      this.sub_6e5("6");
      this.sub_701("6");
      this.sub_734("#");
      this.sub_78f("0");
   }

   public final String sub_3c() {
      return this.sub_26("DistID");
   }

   public final String sub_93() {
      String var1;
      for(var1 = this.sub_26("SubDistID"); var1.length() < (Class_189.sub_84() > 1 ? 5 : 2); var1 = "0" + var1) {
      }

      return var1;
   }

   public final String sub_c5() {
      return this.sub_26("DistName");
   }

   public final String sub_ec() {
      return this.sub_26("DistWWW");
   }

   public final String sub_17b() {
      return this.sub_26("DistWWWTitle");
   }

   public final String sub_18d() {
      return this.sub_26("DistMoreGamesLink");
   }

   public final String sub_197() {
      return this.sub_26("DistMoreGamesTitle");
   }

   public final String sub_1d8() {
      return this.sub_26("DistLetter");
   }

   public final String sub_235() {
      return this.sub_26("DistFlags");
   }

   public final String sub_27f() {
      return this.sub_26("RegisterSizeKey");
   }

   public final String sub_2d4() {
      return this.sub_26("BonusSizeKey");
   }

   public final String sub_325() {
      return this.sub_26("RegisterSizeKeyType1");
   }

   public final String sub_399() {
      return this.sub_26("RegisterSizeKeyType2");
   }

   public final String sub_3c3() {
      return this.sub_26("RegisterSizeKeyType3");
   }

   public final String sub_3f7() {
      return this.sub_26("RegisterSizeKeyType4");
   }

   public final String sub_436() {
      return this.sub_26("TailSeparator");
   }

   public final String sub_477() {
      return this.sub_26("SmsKeyVersion");
   }

   public final String sub_4b6(String var1) {
      return this.sub_63("DistID", var1);
   }

   public final String sub_514(String var1) {
      return this.sub_63("SubDistID", var1);
   }

   public final String sub_544(String var1) {
      return this.sub_63("DistName", var1);
   }

   public final String sub_55f(String var1) {
      return this.sub_63("DistWWWTitle", var1);
   }

   public final String sub_58b(String var1) {
      return this.sub_63("DistWWW", var1);
   }

   public final String sub_59c(String var1) {
      return this.sub_63("DistMoreGamesLink", var1);
   }

   public final String sub_5af(String var1) {
      return this.sub_63("DistMoreGamesTitle", var1);
   }

   public final String sub_5e3(String var1) {
      return this.sub_63("DistLetter", var1);
   }

   public final String sub_613(String var1) {
      return this.sub_63("DistFlags", var1);
   }

   public final String sub_655(String var1) {
      return this.sub_63("RegisterSizeKey", var1);
   }

   public final String sub_681(String var1) {
      return this.sub_63("BonusSizeKey", var1);
   }

   public final String sub_6a4(String var1) {
      return this.sub_63("RegisterSizeKeyType1", var1);
   }

   public final String sub_6c3(String var1) {
      return this.sub_63("RegisterSizeKeyType2", var1);
   }

   public final String sub_6e5(String var1) {
      return this.sub_63("RegisterSizeKeyType3", var1);
   }

   public final String sub_701(String var1) {
      return this.sub_63("RegisterSizeKeyType4", var1);
   }

   public final String sub_734(String var1) {
      return this.sub_63("TailSeparator", var1);
   }

   public final String sub_78f(String var1) {
      return this.sub_63("SmsKeyVersion", var1);
   }

   public final boolean sub_7a8(String var1) {
      return this.sub_235().indexOf(var1) >= 0 || this.sub_84(var1);
   }

   public final void sub_7e8(String[] var1) {
      this.sub_825(var1);
      this.sub_1ea((String[])this.var_19.get("CFG_" + Class_189.sub_76()), var1);
   }

   public final String[] sub_825(String[] var1) {
      String[] var2 = (String[])this.var_19.get("JAD_" + Class_189.sub_76());

      for(int var3 = 0; var3 < var2.length; ++var3) {
         if (var3 < var1.length && var2[var3].compareTo("") != 0 && this.sub_1b0("dst_" + var2[var3]).compareTo("") != 0) {
            var1[var3] = this.sub_1b0("dst_" + var2[var3]);
         }
      }

      return var1;
   }

   public final void sub_874(String[] var1) {
      this.sub_88c(var1, 0, 1);
   }

   public final void sub_88c(String[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 && var4 < var1.length; ++var4) {
         String[] var5;
         if ((var5 = Class_10b.sub_30(";", var1[var4])).length > 1) {
            this.sub_7e8(var5);
         }
      }

   }
}
