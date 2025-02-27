package pkg_4d;

import java.io.DataInputStream;
import java.io.IOException;

public final class Class_2bb {
   public final void sub_4f(int var1) {
      switch(var1) {
      case 1:
         DataInputStream var8 = new DataInputStream(this.getClass().getResourceAsStream("../autoreg_ru.lang"));
         int var2 = -1;

         try {
            var2 = var8.read();
         } catch (IOException var6) {
            var6.printStackTrace();
         }

         if (var2 != -1) {
            String var3 = "";

            while(var2 != -1 && var2 != 10 && var2 != 13) {
               var3 = var3 + (char)var2;

               try {
                  var2 = var8.read();
               } catch (IOException var5) {
                  var2 = -1;
                  var5.printStackTrace();
               }
            }

            try {
               var8.close();
               return;
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         }
      default:
      }
   }
}
