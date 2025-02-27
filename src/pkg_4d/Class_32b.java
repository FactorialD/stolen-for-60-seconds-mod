package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

public final class Class_32b extends Alert implements CommandListener {
   private String var_17 = "";
   private static Class_32b var_44 = null;

   public static Class_32b sub_1a() {
      if (var_44 == null || var_44.var_17.compareTo(Class_1f8.var_116d) != 0) {
         var_44 = new Class_32b();
      }

      var_44.var_17 = Class_1f8.var_116d;
      return var_44;
   }

   public Class_32b() {
      super(Class_1f8.var_dd + "/" + Class_1f8.var_131, Class_1f8.var_de9 + "\r\n " + Class_1f8.var_e14, (Image)null, (AlertType)null);
      this.addCommand(new Command(Class_1f8.var_569 + "/" + Class_1f8.var_575, 4, 0));
      this.addCommand(new Command(Class_1f8.var_5b9 + "/" + Class_1f8.var_614, 2, 0));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 4 && var1 != DISMISS_COMMAND) {
         if (var3 == 7 || var3 == 3 || var3 == 2) {
            Class_4d4.sub_4c7();
         }

      } else {
         Class_4d4.sub_244(3, -1, false, true);
      }
   }
}
