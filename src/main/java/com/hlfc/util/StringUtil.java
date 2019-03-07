//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hlfc.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

public class StringUtil {
    public static final String STRINGSPLIT = ",";
    public static final String DEPTSPLIT = "/";
    private static final String filterRegEx = "[`~!@#$%^&*+=|{}':;',\\[\\]\"'\\\\<>/?~！@#￥%&*——+|{}【】‘；：”“’。，、？]";

    public StringUtil() {
    }

    public static boolean parseBoolean(String val) {
        boolean result = false;
        if(val != null && ("1".equals(val.trim()) || "true".equals(val.trim()))) {
            result = true;
        }

        return result;
    }

    public static int parseInt(String val) {
        int result = 0;
        if(val != null && !val.trim().equals("")) {
            String tmpVal = val;
            if(val.startsWith("-")) {
                tmpVal = val.substring(1);
            }

            if(StringUtils.isNumeric(tmpVal) && !tmpVal.trim().equals("")) {
                result = Integer.parseInt(val);
            }

            return result;
        } else {
            return result;
        }
    }

    public static String valueOf(boolean val) {
        return val?"1":"0";
    }

    public static String toString(Object[] obj, boolean containInvertedComma) {
        return toString(Arrays.asList(obj), containInvertedComma);
    }

    public static String toString(List<?> list, boolean containInvertedComma) {
        if(list != null && list.size() != 0) {
            StringBuffer returnStr = new StringBuffer();
            int listMaxIndex = list.size() - 1;

            for(int index = 0; index < listMaxIndex; ++index) {
                Object value = list.get(index);
                if(containInvertedComma) {
                    returnStr.append("'" + value + "'");
                } else {
                    returnStr.append(value);
                }

                returnStr.append(",");
            }

            Object lastIndexValue = list.get(listMaxIndex);
            if(containInvertedComma) {
                returnStr.append("'" + lastIndexValue + "'");
            } else {
                returnStr.append(lastIndexValue);
            }

            return returnStr.toString();
        } else {
            return null;
        }
    }

    public static String deleteStr(String sourceStr, String delStr) {
        String[] str = sourceStr.split(",");
        str = (String[])ArrayUtils.removeElement(str, delStr);
        return StringUtils.join(str, ",");
    }

    public static String[] insertValueByIndex(String[] array, int index, String v) {
        String[] newArray;
        if(!ArrayUtils.isEmpty(array) && !StringUtils.isEmpty(array[0])) {
            newArray = (String[])ArrayUtils.subarray(array, 0, index);
            String[] endArray = (String[])ArrayUtils.subarray(array, index, array.length);
            String[] newV = new String[]{v};
            newArray = (String[])ArrayUtils.addAll(newArray, newV);
            newArray = (String[])ArrayUtils.addAll(newArray, endArray);
            return newArray;
        } else {
            newArray = new String[]{v};
            return newArray;
        }
    }

    public static List<String> composeList(List<String> list1, List<String> list2) {
        List<String> resultList = list1;
        if(list1 == null) {
            return list2;
        } else {
            if(list2 != null && !list2.isEmpty()) {
                int i = 0;

                for(int size = list2.size(); i < size; ++i) {
                    if(!resultList.contains(list2.get(i))) {
                        resultList.add((String)list2.get(i));
                    }
                }
            }

            return resultList;
        }
    }

    public static String hashBase64(String str) {
        String ret = "";

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            sha.update(str.getBytes());
            ret = (new BASE64Encoder()).encode(sha.digest());
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return ret;
    }

    public static String convertObjectToString(Object obj) {
        return obj == null?"":obj.toString();
    }

    public static InputStream String2InputStream(String str) {
        ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
        return stream;
    }

    public static boolean validateUnid(String unid) {
        boolean result = false;
        if(unid != null) {
            Pattern pattern = Pattern.compile("[0-9A-F]{32}");
            Matcher matcher = pattern.matcher(unid);
            result = matcher.matches();
        }

        return result;
    }

    public static String encodeUrl(String url, String encode) {
        if(!"".equals(url) && url != null) {
            try {
                url = URLEncoder.encode(url, encode);
            } catch (Exception var3) {
                System.out.println("url：" + url + " URL编码失败！");
            }

            return url;
        } else {
            return "";
        }
    }

    public static String encodeUrl(String url) {
        return encodeUrl(url, "utf-8");
    }

    public static String decodeUrl(String url, String encode) {
        if(!"".equals(url) && url != null) {
            try {
                url = URLDecoder.decode(url, encode);
            } catch (Exception var3) {
                System.out.println("url：" + url + " URL解码失败！");
            }

            return url;
        } else {
            return "";
        }
    }

    public static String decodeUrl(String url) {
        return decodeUrl(url, "utf-8");
    }

    public static String filterDangerString(String contnt) {
        return filterDangerString(contnt, "");
    }

    public static String filterDangerString(String contnt, String regExStr) {
        if(StringUtils.isEmpty(contnt)) {
            return "";
        } else {
            String regEx = "[`~!@#$%^&*+=|{}':;',\\[\\]\"'\\\\<>/?~！@#￥%&*——+|{}【】‘；：”“’。，、？]";
            if(StringUtils.isNotEmpty(regExStr)) {
                regEx = regExStr;
            }

            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(contnt);
            String result = m.replaceAll("").trim();
            return result;
        }
    }

    public static boolean isHavDangerSign(String contnt) {
        return isHavDangerSign(contnt, "");
    }

    public static boolean isHavDangerSign(String contnt, String regExStr) {
        if(StringUtils.isEmpty(contnt)) {
            return false;
        } else {
            String regEx = "[`~!@#$%^&*+=|{}':;',\\[\\]\"'\\\\<>/?~！@#￥%&*——+|{}【】‘；：”“’。，、？]";
            if(StringUtils.isNotEmpty(regExStr)) {
                regEx = regExStr;
            }

            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(contnt);
            return m.find();
        }
    }
}
