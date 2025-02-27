package pkg_4d;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import pkg_65.GlomoFileClass;

public final class Class_40e extends List implements CommandListener {
   private static Class_40e var_5e = null;
   private String var_70 = "";
   private GlomoFileClass var_113 = null;

   public static Class_40e sub_58(GlomoFileClass var0) {
      if (var_5e == null || var_5e.var_70.compareTo(Class_1f8.var_116d) != 0) {
         var_5e = new Class_40e(var0);
      }

      var_5e.var_70 = Class_1f8.var_116d;
      return var_5e;
   }

   public Class_40e(GlomoFileClass var1) {
      super(Class_1f8.var_ce, 3);
      this.var_113 = var1;
      this.sub_7a(this.var_113);
      this.addCommand(new Command(Class_1f8.var_382, 7, 1));
      Command var2 = new Command(Class_1f8.var_44f, 4, 1);
      this.addCommand(var2);
      this.setSelectCommand(var2);
      this.setCommandListener(this);
   }

   private void sub_7a(GlomoFileClass var1) {
      String var2 = var1.sub_7d1();
      String var3 = var1.sub_786();
      String[] var4 = new String[]{Class_1f8.var_715, Class_1f8.var_768, Class_1f8.var_77f, var3 != null && var3.compareTo("") != 0 ? Class_1f8.var_796 : null, var2 != null && var2.compareTo("") != 0 ? Class_1f8.var_7df : null, Class_1f8.var_887, Class_1f8.var_382};

      for(int var5 = 0; var5 < var4.length; ++var5) {
         if (var4[var5] != null) {
            this.append(var4[var5], (Image)null);
         }
      }

   }

   public final void commandAction(Command var1, Displayable var2) {
      int var3;
      if ((var3 = var1.getCommandType()) != 8 && var3 != 4 && var3 != 1) {
         if (var3 == 7) {
            Class_4d4.sub_4c7();
         }
      } else {
         String var4;
         if ((var4 = this.getString(this.getSelectedIndex())).compareTo(Class_1f8.var_715) == 0) {
            (new Class_15d(this.var_113)).start();
         } else if (var4.compareTo(Class_1f8.var_768) == 0) {
            Class_4d4.sub_1cc(8);
         } else if (var4.compareTo(Class_1f8.var_77f) == 0) {
            Class_4d4.sub_1cc(3);
         } else if (var4.compareTo(Class_1f8.var_828) == 0) {
            Class_4d4.sub_1cc(11);
         } else if (var4.compareTo(Class_1f8.var_796) == 0) {
            Class_4d4.sub_1cc(13);
         } else if (var4.compareTo(Class_1f8.var_7df) == 0) {
            Class_4d4.sub_423(this.var_113.sub_7d1());
         } else {
            if (var4.compareTo(Class_1f8.var_887) != 0) {
               if (var4.compareTo(Class_1f8.var_382) == 0) {
                  Class_4d4.sub_4c7();
               }

               return;
            }

            Class_4d4.sub_1cc(18);
         }
      }

   }
}
