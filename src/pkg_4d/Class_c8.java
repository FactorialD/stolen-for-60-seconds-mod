package pkg_4d;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;

public class Class_c8 extends Alert implements CommandListener {
   private int var_39;

   public Class_c8() {
      this((String)null, (String)null, (Image)null, (AlertType)null);
   }

   public Class_c8(String var1, String var2, Image var3, AlertType var4) {
      this(var1, var2, var3, var4, -1);
   }

   public Class_c8(String var1, String var2, Image var3, AlertType var4, int var5) {
      this(var1, var2, var3, var4, var5, new Command[]{new Command(Class_1f8.var_670, 4, 1)});
   }

   public Class_c8(String var1, String var2, Image var3, AlertType var4, int var5, Command[] var6) {
      super(var1, var2, var3, var4);
      this.var_39 = -1;
      this.var_39 = var5;
      this.setTimeout(-2);
      if (var6 != null) {
         for(int var7 = 0; var7 < var6.length; ++var7) {
            this.addCommand(var6[var7]);
         }
      }

      this.setCommandListener(this);
   }

   public int sub_5e() {
      return this.var_39;
   }

   public int sub_9f(int var1) {
      this.var_39 = var1;
      return this.sub_5e();
   }

   public void commandAction(Command var1, Displayable var2) {
      if (var1.getCommandType() == 4 && this.var_39 != -1) {
         Class_4d4.sub_1cc(this.var_39);
      }

   }
}
