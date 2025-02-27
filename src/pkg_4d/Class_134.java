package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import pkg_65.Class_10b;
import pkg_65.GlomoFileClass;

public final class Class_134 extends Alert implements CommandListener {
   private GlomoFileClass var_d = null;
   private String var_26 = "";
   private static Class_134 var_31 = null;

   public static Class_134 sub_54(GlomoFileClass var0) {
      if (var_31 == null || var_31.var_26.compareTo(Class_1f8.var_116d) != 0) {
         var_31 = new Class_134(var0);
      }

      var_31.var_26 = Class_1f8.var_116d;
      return var_31;
   }

   public Class_134(GlomoFileClass var1) {
      super(Class_1f8.var_ce, Class_10b.sub_66(Class_1f8.var_fa1, new String[]{Class_1f8.var_670, Class_1f8.var_768, var1.sub_f0().sub_323()}), (Image)null, (AlertType)null);
      this.var_d = var1;
      this.setTimeout(-2);
      this.addCommand(new Command(Class_1f8.var_670, 4, 0));
      this.addCommand(new Command(Class_1f8.var_6bb, 3, 0));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 4 && var3 != 1) {
         if (var3 == 3) {
            Class_4d4.sub_1cc(6);
         }

      } else {
         (new Class_15d(this.var_d)).start();
      }
   }
}
