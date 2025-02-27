package pkg_4d;

import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Image;

public class Class_2ec extends Class_c8 {
   private int var_6e;
   private boolean var_dc;
   private int var_ec;
   private String var_14a = "";
   private static Class_2ec var_19f = null;

   public static Class_2ec sub_51(int var0, boolean var1, int var2) {
      if (var_19f == null || var_19f.var_6e != var0 || var_19f.var_dc != var1 || var_19f.var_ec != var2 || var_19f.var_14a.compareTo(Class_1f8.var_116d) != 0) {
         var_19f = new Class_2ec(var0, var1, var2);
      }

      var_19f.var_14a = Class_1f8.var_116d;
      return var_19f;
   }

   public Class_2ec(int var1, boolean var2, int var3) {
      super((String)null, (String)null, (Image)null, AlertType.ERROR, var3);
      this.var_6e = var1;
      this.var_dc = var2;
      this.var_ec = var3;
      if (var2) {
         if (var1 == 1) {
            this.setTitle(Class_1f8.var_2e7 + "/" + Class_1f8.var_323);
            this.setString(Class_1f8.var_1083 + " \r\n" + Class_1f8.var_10ad);
            return;
         }
      } else if (var1 == 1) {
         this.setTitle(Class_1f8.var_2a8);
         this.setString(Class_1f8.var_1024);
      }

   }
}
