package main;
import javax.microedition.lcdui.Graphics;

public final class LevelObject implements LevelObjectData {
   public final byte objectType;
   /*01 - wooden door, 
    * 05 - glass vertical witrine, 
    * 06 - alarm panel
    * 13 - glass shelf looking down
    * 27 - glass square witrine
    * */
   public final byte x;
   public final byte y;
   public final byte offsetType;
   public short var_18d;
   public short var_1a5;
   public final byte[] var_1bc = new byte[]{120, 8};
   public byte var_1f5;
   public byte var_22c;

   public LevelObject(byte objectType, byte x, byte y, byte offsetType, byte var5, byte var6, byte var7) {
      this.objectType = objectType;
      this.x = x;
      this.y = y;
      this.offsetType = offsetType;
      this.var_1f5 = var6;
      this.var_22c = var7;
      this.var_1bc[0] = (byte)(var5 == 0 ? 120 : 0);
   }

   public final void drawObject(Graphics g) {
      int var2;
      if (LevelManager.var_a5a != 0) {
         byte objectType = this.objectType;
         if (objectType == 6 && LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32) {
            objectType = 4;
         }

         boolean var4 = ReadingDrawingClass.sub_678(LevelObjectData.spriteIndexes[objectType][5], (byte)6) || ReadingDrawingClass.sub_678(LevelObjectData.spriteIndexes[objectType][5], (byte)7);
         if (objectType == 6 && LevelManager.var_7f3 > 0) {
            return;
         }

         if (this.var_1bc[0] <= 0 && objectType == 4) {
            return;
         }

         if (objectType == 9) {
            if (this.var_1bc[0] > 0) {
               return;
            }

            var2 = this.var_1bc[1] <= 0 ? 1 : 0;
         } else {
            var2 = this.var_1bc[0] <= 0 ? 1 : 0;
         }

         int additionalOffsetX = 0;
         int additionalOffsetY = 0;
         int spriteIndex = LevelObjectData.spriteIndexes[objectType][this.offsetType] + var2;
         int spriteXPos =  LevelManager.mapOffsetX + this.x * 24;
         int spriteYPos =  LevelManager.mapOffsetY + this.y * 24;
         
         if (var4) {
            
            int leftOffset = 0;
            int rightOffset = 0;
            int topOffset = 0;
            int bottomOffset = 0;
            if (ReadingDrawingClass.sub_678(LevelObjectData.spriteIndexes[objectType][5], (byte)6)) {
               leftOffset = this.offsetType == 2 ? 12 : 0;
               rightOffset = this.offsetType == 0 ? 12 : 0;
               topOffset = this.offsetType == 3 ? 12 : 0;
               bottomOffset = this.offsetType == 1 ? 12 : 0;
            } else if (ReadingDrawingClass.sub_678(LevelObjectData.spriteIndexes[objectType][5], (byte)7)) {
               additionalOffsetX = LevelManager.offsetTypes[0][this.offsetType] * 12;
               additionalOffsetY = LevelManager.offsetTypes[1][this.offsetType] * 12;
               
               spriteXPos += additionalOffsetX;
               spriteYPos += additionalOffsetY;
               
               leftOffset = this.offsetType == 0 ? 12 : 0;
               rightOffset = this.offsetType == 2 ? 12 : 0;
               topOffset = this.offsetType == 1 ? 12 : 0;
               bottomOffset = this.offsetType == 3 ? 12 : 0;
            }
            
            
            
            

            ReadingDrawingClass.drawSprite(g, 4, spriteIndex, spriteXPos, spriteYPos, leftOffset, rightOffset, topOffset, bottomOffset);
         } else {

            ReadingDrawingClass.drawSpriteNoOffset(g, 4, spriteIndex, spriteXPos, spriteYPos);
         }

         if (objectType == 9) {
            if (this.var_1bc[0] <= 0 && this.var_1bc[1] > 0) {
               ReadingDrawingClass.sub_46a(g, String.valueOf(this.var_1bc[1]), LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
            }

            if (this.var_1bc[1] == 0) {
               ReadingDrawingClass.drawSpriteNoOffset(g, (byte)11, LevelManager.var_4e5[this.var_22c], LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
               LevelManager.var_4a5 = LevelManager.var_475[this.var_22c];
            }
         }
      } else {
         if (this.objectType == 6 && (LevelManager.var_7f3 > 0 || LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32)) {
            return;
         }

         if (this.objectType == 4 && LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 32) {
            return;
         }

         if (this.objectType != 22 && this.objectType != 23 && this.objectType != 24) {
            if (this.objectType == 6) {
               var2 = this.var_22c == 0 ? 16711680 : (this.var_22c == 1 ? 315140 : 255);
            } else {
               var2 = this.var_22c > 0 ? 12058726 : 0;
               if (ReadingDrawingClass.sub_678(LevelObjectData.spriteIndexes[this.objectType][5], (byte)5)) {
                  var2 = 5855577;
               } else if (LevelManager.var_7a3[this.var_1f5] > 0 || LevelManager.levelAdditionalData_TimerEtc[Class_178.var_dc6 - 1][25] == 20) {
                  var2 = 0;
               }

               if (this.objectType == 11) {
                  var2 = 0;
               }
            }

            ReadingDrawingClass.sub_2c5(g, LevelObjectData.spriteIndexes[this.objectType][4], this.offsetType, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24, var2);
         } else {
            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)47, 0, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
         }

         if (this.var_18d > 0 && this.var_18d <= Class_205.var_4aa) {
            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)2, 18, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
         }

         if (this.var_1a5 > 0 && this.var_1a5 <= Class_205.var_4aa) {
            ReadingDrawingClass.drawSpriteNoOffset(g, (byte)2, 19, LevelManager.mapOffsetX + this.x * 24, LevelManager.mapOffsetY + this.y * 24);
            return;
         }
      }

   }

   public final void drawTimerCircle(Graphics g, byte var2, boolean var3) {
      if (var2 > 0) {
         int var4 = 360 * (var3 ? this.var_1bc[0] : this.var_1bc[1]) / var2;
         g.setClip(0, 0, 16, 16);
         g.setColor(var3 ? 10027008 : 26112);
         g.fillArc(0, 0, 15, 15, 0, 360);
         g.setColor(16777215);
         g.fillArc(0, 0, 15, 15, 90, var4);
      }

   }

   public final void sub_c6(boolean var1) {
      if (var1) {
         this.var_18d = 0;
         this.var_1a5 = 0;
      } else {
         this.var_1bc[0] = 120;
         this.var_1bc[1] = 8;
      }
   }
}
