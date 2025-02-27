package pkg_65;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class Class_5e implements Class_17f {
   public static boolean var_16 = true;

   public static final int sub_21() {
      return ((Integer)sub_792("generalInfo", 1, new Integer(-1))).intValue();
   }

   public static final int sub_2b(int var0) {
      return ((Integer)sub_732("generalInfo", 1, new Integer(var0))).intValue();
   }

   public static final long sub_71() {
      return ((Long)sub_792("generalInfo", 7, new Long(0L))).longValue();
   }

   public static final long sub_d3(long var0) {
      return ((Long)sub_732("generalInfo", 7, new Long(var0))).longValue();
   }

   public static final long sub_101() {
      return ((Long)sub_792("generalInfo", 2, new Long(0L))).longValue();
   }

   public static final long sub_13a(long var0) {
      return ((Long)sub_76c("generalInfo", 2, new Long(var0), false)).longValue();
   }

   public static final long sub_184() {
      return sub_13a(main.Class_3d.sub_161());
   }

   public static final long sub_1a5() {
      return ((Long)sub_732("generalInfo", 3, new Long(sub_1b7() + 1L))).longValue();
   }

   public static final long sub_1b7() {
      return ((Long)sub_792("generalInfo", 3, new Long(0L))).longValue();
   }

   public static final String sub_1ec() {
      return (String)sub_732("generalInfo", 4, main.Class_3d.sub_46("microedition.platform"));
   }

   public static final String sub_247() {
      return (String)sub_792("generalInfo", 4, new String(""));
   }

   public static final long sub_27d() {
      return ((Long)sub_792("generalInfo", 12, new Long(0L))).longValue();
   }

   public static final long sub_2df(long var0) {
      return ((Long)sub_732("generalInfo", 12, new Long(var0))).longValue();
   }

   public static final String sub_2ec(String var0) {
      return (String)sub_732("generalInfo", 6, new String(var0));
   }

   public static final String sub_30e() {
      return (String)sub_792("generalInfo", 6, new String(""));
   }

   public static final int sub_342() {
      return ((Integer)sub_792("generalInfo", 13, new Integer(0))).intValue();
   }

   public static final int sub_361(int var0) {
      return ((Integer)sub_732("generalInfo", 13, new Integer(var0))).intValue();
   }

   public static final long sub_3b3(long var0, int var2) {
      return ((Long)sub_732("bonuses", -1, new Long(var0 * 10L + (long)var2))).longValue();
   }

   public static final int sub_403() {
      return ((Integer)sub_732("generalInfo", 8, new Integer(sub_467() + 1))).intValue();
   }

   public static final int sub_467() {
      return ((Integer)sub_792("generalInfo", 8, new Integer(0))).intValue();
   }

   public static final long sub_4b2() {
      return ((Long)sub_792("generalInfo", 9, new Long(0L))).longValue();
   }

   public static final long sub_512(long var0) {
      return ((Long)sub_732("generalInfo", 9, new Long(var0))).longValue();
   }

   public static final int sub_55d(int var0) {
      return ((Integer)sub_732("generalInfo", 10, new Integer(var0))).intValue();
   }

   public static final int sub_5bc() {
      return ((Integer)sub_792("generalInfo", 10, new Integer(-1))).intValue();
   }

   public static final int sub_5cb(int var0) {
      return ((Integer)sub_732("generalInfo", 14, new Integer(var0))).intValue();
   }

   public static final int sub_62c() {
      return ((Integer)sub_792("generalInfo", 14, new Integer(0))).intValue();
   }

   public static final long sub_64e(long param0) {
      // $FF: Couldn't be decompiled
	   // TODO 
	   throw new IllegalArgumentException("ban!");
   }

   public static RecordStore sub_67d(String var0) {
      try {
         return RecordStore.openRecordStore(var0, true);
      } catch (RecordStoreException var1) {
         var1.printStackTrace();
         return null;
      }
   }

   public static void sub_6bb(int var0, RecordStore var1) {
      try {
         int var2;
         if ((var2 = var1.getNumRecords()) < var0) {
            ++var2;

            while(var2 <= var0) {
               var1.addRecord((byte[])null, 0, 0);
               ++var2;
            }
         }

      } catch (RecordStoreNotOpenException var3) {
         var3.printStackTrace();
      } catch (RecordStoreException var4) {
         var4.printStackTrace();
      }
   }

   public static void sub_707(RecordStore var0) {
      if (var0 != null) {
         try {
            var0.closeRecordStore();
         } catch (RecordStoreNotOpenException var1) {
            var1.printStackTrace();
         } catch (RecordStoreException var2) {
            var2.printStackTrace();
         }
      }
   }

   public static Object sub_732(String var0, int var1, Object var2) {
      return sub_76c(var0, var1, var2, true);
   }

   public static Object sub_76c(String var0, int var1, Object var2, boolean var3) {
      RecordStore var4 = null;
      long var5 = -1L;
      long var7 = 0L;
      long var9 = 0L;

      try {
         try {
            var4 = sub_67d(var0);
            if (var1 <= 0) {
               var1 = var4.getNextRecordID();
            }

            var7 = (long)var4.getNumRecords();
            sub_6bb(var1, var4);
            var9 = (long)var4.getNumRecords();
            var5 = -2L;
            ByteArrayOutputStream var27 = new ByteArrayOutputStream();
            DataOutputStream var11 = new DataOutputStream(var27);
            if (var2.getClass().getName().compareTo("java.lang.Integer") == 0) {
               var11.writeInt(((Integer)var2).intValue());
            } else if (var2.getClass().getName().compareTo("java.lang.Long") == 0) {
               var11.writeLong(((Long)var2).longValue());
            } else if (var2.getClass().getName().compareTo("java.lang.Byte") == 0) {
               var11.writeByte(((Byte)var2).byteValue());
            } else if (var2.getClass().getName().compareTo("java.lang.Boolean") == 0) {
               var11.writeBoolean(((Boolean)var2).booleanValue());
            } else if (var2.getClass().getName().compareTo("java.lang.String") == 0) {
               var11.writeUTF((String)var2);
            }

            var5 = -3L;
            var11.flush();
            var27.flush();
            var5 = -4L;
            byte[] var12 = var27.toByteArray();
            var5 = -5L;
            var4.setRecord(var1, var12, 0, var12.length);
            var5 = -6L;
            var11.close();
            var27.close();
         } catch (RecordStoreNotOpenException var20) {
            var5 += -10L;
         } catch (InvalidRecordIDException var21) {
            var5 += -20L;
         } catch (RecordStoreFullException var22) {
            var5 += -30L;
         } catch (RecordStoreException var23) {
            var5 += -40L;
         } catch (SecurityException var24) {
            var5 += -50L;
         } catch (Exception var25) {
            var5 += -60L;
            var25.printStackTrace();
         }

         if (var5 <= -10L && var2.getClass().getName().compareTo("java.lang.Long") == 0) {
            var2 = new Long((var5 * 1000L - var7) * 1000L - var9);
         }
      } finally {
         sub_707(var4);
      }

      if (var3 && var_16) {
         sub_184();
      }

      return var2;
   }

   public static Object sub_792(String var0, int var1, Object var2) {
      RecordStore var3 = null;
      Object var4 = var2;

      try {
         var4 = sub_7cc(var3 = sub_67d(var0), var1, var2);
      } catch (Exception var7) {
         var7.printStackTrace();
      } finally {
         sub_707(var3);
      }

      return var4;
   }

   public static Object sub_7cc(RecordStore var0, int var1, Object var2) throws Exception {
      try {
         byte[] var4;
         if ((var4 = var0.getRecord(var1)) != null && var2 != null) {
            ByteArrayInputStream var5 = new ByteArrayInputStream(var4);
            DataInputStream var6 = new DataInputStream(var5);
            if (var2.getClass().getName().compareTo("java.lang.Integer") == 0) {
               return new Integer(var6.readInt());
            } else if (var2.getClass().getName().compareTo("java.lang.Long") == 0) {
               return new Long(var6.readLong());
            } else if (var2.getClass().getName().compareTo("java.lang.Byte") == 0) {
               return new Byte(var6.readByte());
            } else if (var2.getClass().getName().compareTo("java.lang.Boolean") == 0) {
               return new Boolean(var6.readBoolean());
            } else if (var2.getClass().getName().compareTo("java.lang.String") == 0) {
               return new String(var6.readUTF());
            } else {
               var6.close();
               var5.close();
               return var2;
            }
         } else {
            return var2;
         }
      } catch (Exception e) {
    	  e.printStackTrace();
         throw new Exception(e.getMessage());
      }
   }

   public static final long sub_824() {
      RecordStore var0 = null;
      long var1 = 0L;

      try {
         var1 = (var0 = sub_67d("generalInfo")).getLastModified();
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         sub_707(var0);
      }

      return var1;
   }
}
