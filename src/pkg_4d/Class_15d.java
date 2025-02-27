package pkg_4d;

import pkg_65.GlomoFileClass;

public class Class_15d extends Thread {
   private GlomoFileClass var_14 = null;

   public Class_15d(GlomoFileClass var1) {
      this.var_14 = var1;
   }

   public void run() {
      Class_4d4.sub_1cc(19);
      if (this.var_14.sub_229()) {
         Class_4d4.sub_1cc(5);
      } else {
         int var1;
         if ((var1 = this.var_14.sub_b72()) > 0) {
            Class_4d4.sub_270(17, 6, false, true, var1);
         } else {
            Class_4d4.sub_1cc(6);
         }
      }
   }
}
