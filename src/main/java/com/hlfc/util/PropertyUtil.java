package com.hlfc.util;

/**
 * 操作 property 文件工具类
 * Created by HXL on 2018/9/11.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
    String cfgFileName = "";
    private boolean loadflag = false;
    private Properties properties = new Properties();
    private static Map<String, PropertyUtil> PropertyUtils = null;

    public static PropertyUtil getInstance(String fileName) {
        PropertyUtil pb = null;
        if(PropertyUtils != null && PropertyUtils.containsKey(fileName)) {
            pb = (PropertyUtil)PropertyUtils.get(fileName);
        }

        if(pb == null) {
            pb = new PropertyUtil();
            pb.cfgFileName = fileName;
            pb.init();
            if(PropertyUtils == null) {
                PropertyUtils = new HashMap();
            }

            if(PropertyUtils.containsKey(fileName)) {
                PropertyUtils.remove(fileName);
            }

            PropertyUtils.put(fileName, pb);
        }

        return pb;
    }

    private PropertyUtil() {
    }

    public void init() {
        if(!this.loadflag) {
            this.load(this.cfgFileName);
            this.loadflag = true;
        }

    }

    public void reload() {
        this.load(this.cfgFileName);
    }

    private void load(String filename) {
        try {
            File file = new File(filename);
            if(!file.exists()) {
                return;
            }

            FileInputStream fi = new FileInputStream(filename);
            this.properties.load(fi);
            fi.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }

    public Properties getProperties() {
        return this.properties;
    }

    public String getValue(String key) {
        return this.properties.getProperty(key, "");
    }

    public boolean write(String key, String value) {
        return this.write(key, value, 1);
    }

    public boolean update(String key, String value) {
        return this.write(key, value, 0);
    }

    private boolean write(String key, String value, int type) {
        boolean result = false;
        File file = new File(this.cfgFileName);
        if(!file.exists()) {
            try {
                file.createNewFile();
                this.reload();
            } catch (IOException var9) {
            }
        }

        if(this.properties != null) {
            if(1 == type && !this.properties.containsKey(key)) {
                this.properties.put(key, value);
            } else if(type == 0 && this.properties.containsKey(key)) {
                this.properties.put(key, value);
            }

            try {
                OutputStream out = new FileOutputStream(this.cfgFileName);
                this.properties.store(out, "");
                out.close();
                result = true;
            } catch (FileNotFoundException var7) {
            } catch (IOException var8) {
            }
        }

        return result;
    }
}
