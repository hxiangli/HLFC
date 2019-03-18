
package com.hlfc.db.mongodb.template;

import com.google.code.morphia.query.UpdateOperations;
import com.hlfc.db.mongodb.template.bean.BeanEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.beans.PropertyDescriptor;
import java.util.Iterator;

public class CcipMorphiaUtil {
    private static final String _ID = "unid";

    public CcipMorphiaUtil() {
    }

    public static <A> void updateOps(UpdateOperations<A> var0, A var1)  {
        String[] var2 = null;
        if (var1 instanceof BeanEntity) {
            var2 = new String[]{"unid"};
        }

        updateOps(var0, var1, var2);
    }

    public static <A> void updateOps(UpdateOperations<A> var0, A var1, String[] var2)  {
            if (var1 instanceof BeanEntity) {
                if (var2 == null) {
                    var2 = new String[]{"unid"};
                }

                if (!ArrayUtils.contains(var2, "unid")) {
                    var2 = (String[]) ArrayUtils.add(var2, "unid");
                }
            }

            PropertyDescriptor[] var3 = PropertyUtils.getPropertyDescriptors(var1);
            JSONObject var4 = JSONObject.fromObject(var1);
            DA833A2AC4A7DCB2A62E5E5BC48CB993(var4);
            PropertyDescriptor[] var8 = var3;
            int var7 = var3.length;

            for(int var6 = 0; var6 < var7; ++var6) {
                PropertyDescriptor var5 = var8[var6];
                String var9 = var5.getName();
                if (var4.containsKey(var9) && !var9.equals("class") && !ArrayUtils.contains(var2, var9)) {
                    Object var10 = var4.get(var9);
                    if ((!(var10 instanceof JSONObject) || !JSONObject.fromObject(var10).isNullObject()) && (!(var10 instanceof JSONArray) || !JSONArray.fromObject(var10).isEmpty()) && !(var10 instanceof JSONNull)) {
                        var0.set(var9, var10);
                    }
                }
            }

        }

    private static void DA833A2AC4A7DCB2A62E5E5BC48CB993(Object var0) {
        if (var0 != null && var0 instanceof JSONObject) {
            JSONObject var1 = (JSONObject)var0;
            JSONObject var2 = JSONObject.fromObject(var1.toString());
            Iterator var3 = var2.keys();

            while(true) {
                while(var3.hasNext()) {
                    String var4 = (String)var3.next();
                    Object var5 = var1.get(var4);
                    if (var5 instanceof JSONObject) {
                        if (!JSONObject.fromObject(var5).isNullObject()) {
                            DA833A2AC4A7DCB2A62E5E5BC48CB993(var5);
                        }
                    } else if (var5 instanceof JSONArray) {
                        if (!JSONArray.fromObject(var5).isEmpty()) {
                            JSONArray var6 = (JSONArray)var5;
                            Iterator var7 = var6.iterator();

                            while(var7.hasNext()) {
                                Object var8 = var7.next();
                                DA833A2AC4A7DCB2A62E5E5BC48CB993(var8);
                            }
                        }
                    } else if (var5 instanceof JSONNull) {
                        var1.put(var4, (Object)null);
                    }
                }

                var2 = null;
                return;
            }
        }
    }
}
