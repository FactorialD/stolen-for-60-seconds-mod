package pkg_65;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public class Class_b7 {
   private static MessageConnection var_e = null;
   private static boolean var_56 = false;

   public static boolean sub_31(String var0, String var1) throws Exception {
      var_56 = false;
      if (var0.length() > 0) {
         try {
            if (var_e != null) {
               var_e.close();
               var_e = null;
            }

            TextMessage var4;
            (var4 = (TextMessage)(var_e = (MessageConnection)Connector.open("sms://" + var0)).newMessage("text")).setPayloadText(var1);
            var_e.send(var4);
            var_e.close();
            var_e = null;
            var_56 = true;
         } catch (IllegalArgumentException var2) {
            throw var2;
         } catch (Exception var3) {
            throw var3;
         }
      }

      return var_56;
   }

   public static boolean sub_4c() {
      return var_56;
   }
}
