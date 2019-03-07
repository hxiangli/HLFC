//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hlfc.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class EnvironmentUtil {
    private static EnvironmentUtil instance = null;
    public static final String WEBINF = "WEB-INF";
    public static final String WINDOWS_SEPARATOR = "/";
    private static final String ENCODE = "GBK";

    private EnvironmentUtil() {
    }

    public static EnvironmentUtil getInstance() {
        if(instance == null) {
            Class var0 = EnvironmentUtil.class;
            synchronized(EnvironmentUtil.class) {
                if(instance == null) {
                    instance = new EnvironmentUtil();
                }
            }
        }

        return instance;
    }

    public String getWebInfPath() {
        try {
            String pathInfo = EnvironmentUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String osName = System.getProperty("os.name");
            if (!pathInfo.toUpperCase().contains("WEB-INF")){//不是web访问方式
                return pathInfo.substring(1, pathInfo.toUpperCase().lastIndexOf("CLASSES") + 7);
            }
            return osName != null && osName.startsWith("Windows")?(pathInfo.toUpperCase().indexOf("WEB-INF") > -1?pathInfo.substring(1, pathInfo.toUpperCase().lastIndexOf("WEB-INF") + 7):this.getRealAppPath() + "WEB-INF"):pathInfo.substring(0, pathInfo.toUpperCase().lastIndexOf("WEB-INF") + 7);
        } catch (Exception var3) {
        var3.printStackTrace();
        return "";
    }
    }

    public String getAppPath() {
        String webInfPath = this.getWebInfPath();
        String appPath = webInfPath.substring(0, webInfPath.toUpperCase().lastIndexOf("WEB-INF"));
        return appPath;
    }

    private String getRealAppPath() {
        try {
            String pathInfo = this.getClass().getResource("/").getPath();
            pathInfo = URLDecoder.decode(pathInfo, "GBK");

            if (!pathInfo.toUpperCase().contains("WEB-INF")){//不是web访问方式
                return pathInfo.substring(1, pathInfo.toUpperCase().lastIndexOf("/CLASSES") + 1);
            }
            String osName = System.getProperty("os.name");
            return osName != null && osName.startsWith("Windows")?pathInfo.substring(1, pathInfo.toUpperCase().lastIndexOf("/WEB-INF") + 1):pathInfo.substring(0, pathInfo.toUpperCase().lastIndexOf("/WEB-INF") + 1);
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
            return "";
        }
    }
}
