package pkg_4d;

import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import pkg_65.GlomoFileClass;
import pkg_65.Class_1b;

public final class Class_69 extends List implements CommandListener {
   private String var_4e = "";
   private static Class_69 var_7f = null;
   private GlomoFileClass var_96 = null;
   private boolean var_a5 = false;

   public static Class_69 sub_1b(GlomoFileClass var0, boolean var1) {
      if (var_7f == null || var_7f.var_a5 != var1 || var_7f.var_4e.compareTo(Class_1f8.var_116d) != 0) {
         var_7f = new Class_69(var0, var1);
      }

      var_7f.var_4e = Class_1f8.var_116d;
      return var_7f;
   }

   public Class_69(GlomoFileClass var1, boolean var2) {
      super((String)null, 3);
      this.var_a5 = var2;
      if (var2) {
         this.setTitle(Class_1f8.var_194);
      } else {
         this.setTitle(Class_1f8.var_1d3 + "/" + Class_1f8.var_215);
      }

      this.var_96 = var1;
      Vector var5 = var1.sub_e4();

      for(int var3 = 0; var3 < var5.size(); ++var3) {
         String var4 = ((Class_1b)var5.elementAt(var3)).sub_10();
         this.append(var4, (Image)null);
      }

      Command var6 = new Command(Class_1f8.var_670, 4, 1);
      this.addCommand(var6);
      this.setSelectCommand(var6);
      if (var2) {
         this.addCommand(new Command(Class_1f8.var_6bb, 3, 1));
      }

      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 8 && var3 != 1 && var3 != 4) {
         if (var3 == 3) {
            Class_4d4.sub_1cc(4);
            return;
         }

         if (var3 == 7) {
            Class_4d4.sub_4c7();
         }
      } else {
         if (!this.var_96.sub_ae(this.getSelectedIndex())) {
            Class_4d4.sub_4c7();
            return;
         }

         Class_1f8.sub_98(",ru_a,ru,az,am,by,ge,kz,kg,md,tj,tm,uz,ua,".indexOf("," + this.var_96.sub_f0().sub_f5() + ",") != -1 ? Class_1f8.var_852 : Class_1f8.var_848);
         if (this.var_96.sub_14c().compareTo("") != 0) {
            Class_4d4.sub_1cc(12);
            return;
         }

         Class_4d4.sub_270(17, 100, this.var_a5, !this.var_a5, this.var_96.sub_b72());
      }

   }
}
