//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.hlfc.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.id.uuid.UUID;

import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UNIDGenerate {
    private static final int IP;
    private static short counter;
    private static final int JVM;
    private String sep = "";

    static {
        int ipadd;
        try {
            ipadd = toInt(InetAddress.getLocalHost().getAddress());
        } catch (Exception var2) {
            ipadd = 0;
        }

        IP = ipadd;
        counter = 0;
        JVM = (int)(System.currentTimeMillis() >>> 8);
    }

    private UNIDGenerate() {
    }

    public static String getUnid() {
        return new String(Hex.encodeHex(UUID.randomUUID().getRawBytes()));
    }

    public static String getUnid(int num) {
        String unid = getUnid();
        if(num >= 32) {
            return unid;
        } else {
            int numLen = unid.length() - num;
            int beginIndex = (int)Math.random() * numLen;
            unid = unid.substring(beginIndex, num);
            return unid;
        }
    }

    protected int getJVM() {
        return JVM;
    }

    protected short getCount() {
        Class var1 = UNIDGenerate.class;
        synchronized(UNIDGenerate.class) {
            if(counter < 0) {
                counter = 0;
            }

            return counter++;
        }
    }

    protected int getIP() {
        return IP;
    }

    protected short getHiTime() {
        return (short)((int)(System.currentTimeMillis() >>> 32));
    }

    protected int getLoTime() {
        return (int)System.currentTimeMillis();
    }

    protected String format(int intval) {
        String formatted = Integer.toHexString(intval);
        StringBuffer buf = new StringBuffer("00000000");
        buf.replace(8 - formatted.length(), 8, formatted);
        return buf.toString();
    }

    protected String format(short shortval) {
        String formatted = Integer.toHexString(shortval);
        StringBuffer buf = new StringBuffer("0000");
        buf.replace(4 - formatted.length(), 4, formatted);
        return buf.toString();
    }

    public String toString() {
        StringBuffer sb = (new StringBuffer(36)).append(this.format(this.getIP())).append(this.sep).append(this.format(this.getJVM())).append(this.sep).append(this.format(this.getHiTime())).append(this.sep).append(this.format(this.getLoTime())).append(this.sep).append(this.format(this.getCount()));
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var7) {
            return sb.toString().toUpperCase();
        }

        md5.update(sb.toString().getBytes());
        byte[] array = md5.digest();
        StringBuffer ret = new StringBuffer();

        for(int j = 0; j < array.length; ++j) {
            int b = array[j] & 255;
            if(b < 16) {
                ret.append('0');
            }

            ret.append(Integer.toHexString(b));
        }

        return ret.toString().toUpperCase();
    }

    public static boolean isUnid(String str) {
        return str.length() == 32 && str.matches("[A-Z0-9]{32}");
    }

    public static int toInt(byte[] bytes) {
        int result = 0;

        for(int i = 0; i < 4; ++i) {
            result = (result << 8) - -128 + bytes[i];
        }

        return result;
    }
}
