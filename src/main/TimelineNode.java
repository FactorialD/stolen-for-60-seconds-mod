package main;
public final class TimelineNode {
   public byte x;
   public byte y;
   public byte packedData;

   public TimelineNode(byte x, byte y, byte action, byte direction, byte toolSlot) {
      this.x = x;
      this.y = y;
      this.setAction(action);
      this.setDirection(direction);
      this.setToolSlot(toolSlot);
   }

   public final void setAction(byte var1) {
      this.packedData = (byte)(this.packedData & 248);
      this.packedData += var1;
   }

   public final void setDirection(byte var1) {
      this.packedData = (byte)(this.packedData & 231);
      this.packedData = (byte)(this.packedData + (var1 << 3));
   }

   public final void setToolSlot(byte var1) {
      this.packedData = (byte)(this.packedData & 159);
      this.packedData = (byte)(this.packedData + (var1 << 5));
   }

   public final byte getAction() {
      return (byte)(this.packedData & 7);
   }

   public final byte getDirection() {
      return (byte)((this.packedData & 24) >> 3);
   }

   public final byte getToolSlot() {
      return (byte)((this.packedData & 96) >> 5);
   }
}
