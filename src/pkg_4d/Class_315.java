package pkg_4d;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

public final class Class_315 extends List implements CommandListener {
   private String var_64 = "";
   private static Class_315 var_10f = null;

   public static Class_315 sub_54() {
      if (var_10f == null || var_10f.var_64.compareTo(Class_1f8.var_116d) != 0) {
         var_10f = new Class_315();
      }

      var_10f.var_64 = Class_1f8.var_116d;
      return var_10f;
   }

   public Class_315() {
      super((String)null, 3);
      String[] var1 = new String[]{Class_1f8.var_848, Class_1f8.var_852};

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.append(var1[var2], (Image)null);
      }

      this.addCommand(new Command(Class_1f8.var_44f, 4, 1));
      this.addCommand(new Command(Class_1f8.var_425, 2, 1));
      this.setCommandListener(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 8 && var3 != 1) {
         if (var3 == 2) {
            Class_4d4.sub_1cc(4);
         }

      } else {
         Class_1f8.sub_98(this.getString(this.getSelectedIndex()));
         Class_4d4.sub_1cc(4);
      }
   }
}
