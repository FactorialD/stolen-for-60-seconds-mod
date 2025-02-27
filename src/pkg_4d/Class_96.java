package pkg_4d;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import pkg_65.Class_10b;
import pkg_65.GlomoFileClass;
import pkg_65.Class_189;

public final class Class_96 extends Thread {
   private MIDlet var_4b = null;
   private GlomoFileClass glomoClass = null;

   public Class_96(MIDlet var1, GlomoFileClass glomoClass) {
      this.var_4b = var1;
      this.glomoClass = glomoClass;
   }

   public final void run() {
      try {
         while(true) {
            if (Display.getDisplay(this.var_4b).getCurrent() != null) {
               for(int var1 = this.glomoClass.sub_b23(); var1 < sub_39(); var1 = this.glomoClass.sub_b65(var1)) {
                  Thread.sleep(60000L);
                  ++var1;
               }

               boolean var4;
               if (var4 = this.glomoClass.sub_f0().sub_1f().compareTo("-1") != 0) {
                  Class_1f8.sub_98(",ru_a,ru,az,am,by,ge,kz,kg,md,tj,tm,uz,ua,".indexOf("," + this.glomoClass.sub_f0().sub_f5() + ",") != -1 ? Class_1f8.var_852 : Class_1f8.var_848);
               } else {
                  Class_1f8.sub_98(Class_1f8.var_852);
               }

               Class_4d4.sub_28(Display.getDisplay(this.var_4b).getCurrent(), this.var_4b, this.glomoClass);
               if (var4) {
                  Class_4d4.sub_1cc(4);
                  return;
               }

               Class_4d4.sub_1cc(2);
               break;
            }

            Thread.sleep(100L);
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   private static int sub_39() {
      int var0 = 4;
      String[] var1;
      int var2;
      if ((var2 = (var1 = Class_10b.sub_30(",", Class_189.var_95.sub_235())).length) > 0) {
         String[] var3 = null;

         int var4;
         for(var4 = 0; var4 < var2 && (var3 = Class_10b.sub_30("=", var1[var4]))[0].toUpperCase().compareTo("DELAY") != 0; ++var4) {
         }

         if (var4 < var2 && var3 != null && var3.length > 1 && var3[1] != null && var3[1].compareTo("") != 0) {
            try {
               var0 = Integer.parseInt(var3[1]);
            } catch (Exception var5) {
            }
         }
      }

      return var0;
   }
}
