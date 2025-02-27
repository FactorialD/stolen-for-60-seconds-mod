package pkg_65;

import java.util.Hashtable;
import javax.microedition.midlet.MIDlet;

public class Class_1d6 implements Class_17f {
   public final Hashtable var_13 = new Hashtable(12);
   protected MIDlet var_4a;

   public final String sub_26(String var1) {
      return (String)this.var_13.get(var1);
   }

   public final String sub_63(String var1, String var2) {
      this.var_13.put(var1, var2);
      return var2;
   }

   public final boolean sub_84(String var1) {
      return (var1 = this.sub_26(var1)).compareTo("0") != 0 && var1.compareTo("") != 0;
   }

   public final boolean sub_ba(String var1, boolean var2) {
      this.var_13.put(var1, var2 ? "1" : "0");
      return var2;
   }

   public final int sub_ef(String var1) {
      var1 = this.sub_26(var1);

      try {
         return var1 == "" ? 0 : Integer.parseInt(var1);
      } catch (Exception var2) {
         return 0;
      }
   }

   public final int sub_125(String var1, int var2) {
      this.var_13.put(var1, String.valueOf(var2));
      return var2;
   }

   public final void sub_170(MIDlet var1) {
      this.var_4a = var1;
   }

   public final String sub_1b0(String var1) {
      return Class_10b.sub_64b(this.var_4a, var1);
   }

   public final void sub_1ea(String[] var1, String[] var2) {
      for(int var3 = 0; var3 < var2.length && var3 < var1.length; ++var3) {
         if (var1[var3].compareTo("") != 0) {
            this.sub_63(var1[var3], var2[var3]);
         }
      }

   }
}
