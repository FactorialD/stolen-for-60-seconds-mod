package pkg_4d;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;
import pkg_65.GlomoFileClass;

public final class Class_36d extends TextBox implements CommandListener {
   private GlomoFileClass var_10 = null;
   private String var_5d = "";
   private static Class_36d var_f3 = null;

   public static Class_36d sub_35(GlomoFileClass var0) {
      if (var_f3 == null || var_f3.var_5d.compareTo(Class_1f8.var_116d) != 0) {
         var_f3 = new Class_36d(var0);
      }

      var_f3.var_5d = Class_1f8.var_116d;
      return var_f3;
   }

   public Class_36d(GlomoFileClass var1) {
      super(Class_1f8.var_258, "", 12, 0);
      this.var_10 = var1;
      this.addCommand(new Command(Class_1f8.var_670, 4, 1));
      this.addCommand(new Command(Class_1f8.var_6bb, 3, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 4 && var3 != 1) {
         if (var3 == 3) {
            Class_4d4.sub_1cc(4);
         }

      } else if (this.var_10.sub_357(this.getString(), 0)) {
         Class_4d4.sub_1cc(9);
      } else {
         Class_4d4.sub_1cc(10);
      }
   }
}
