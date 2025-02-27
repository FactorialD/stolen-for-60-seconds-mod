package pkg_4d;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import pkg_65.GlomoFileClass;

public class Class_45e extends TextBox implements CommandListener {
   private GlomoFileClass var_1f = null;
   private String var_9e = "";
   private static Class_45e var_15e = null;

   public static Class_45e sub_2b(GlomoFileClass var0) {
      if (var_15e == null || var_15e.var_9e.compareTo(Class_1f8.var_116d) != 0) {
         var_15e = new Class_45e(var0);
      }

      var_15e.var_9e = Class_1f8.var_116d;
      return var_15e;
   }

   public Class_45e(GlomoFileClass var1) {
      super(Class_1f8.var_796, "", 20, 3);
      this.var_1f = var1;
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.addCommand(new Command(Class_1f8.var_6bb, 3, 1));
      this.setCommandListener(this);
   }

   public void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 4 && var3 != 1) {
         if (var3 == 3) {
            Class_4d4.sub_1cc(4);
         }

      } else if (this.var_1f.sub_83c(this.getString(), false)) {
         Class_4d4.sub_1cc(15);
      } else {
         Class_4d4.sub_1cc(16);
      }
   }
}
