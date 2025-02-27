package main;
public final class Class_240 {
   public byte var_29;
   public byte var_86;
   public byte var_df;

   public Class_240(byte var1, byte var2, byte var3, byte var4, byte var5) {
      this.var_29 = var1;
      this.var_86 = var2;
      this.sub_15(var3);
      this.sub_4c(var4);
      this.sub_7a(var5);
   }

   public final void sub_15(byte var1) {
      this.var_df = (byte)(this.var_df & 248);
      this.var_df += var1;
   }

   public final void sub_4c(byte var1) {
      this.var_df = (byte)(this.var_df & 231);
      this.var_df = (byte)(this.var_df + (var1 << 3));
   }

   public final void sub_7a(byte var1) {
      this.var_df = (byte)(this.var_df & 159);
      this.var_df = (byte)(this.var_df + (var1 << 5));
   }

   public final byte sub_a2() {
      return (byte)(this.var_df & 7);
   }

   public final byte sub_106() {
      return (byte)((this.var_df & 24) >> 3);
   }

   public final byte sub_123() {
      return (byte)((this.var_df & 96) >> 5);
   }
}
