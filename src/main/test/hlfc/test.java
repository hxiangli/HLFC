package hlfc;
//exports com.hao.test;

import com.alibaba.druid.support.json.JSONUtils;
import com.rabbitmq.tools.json.JSONUtil;
import net.sf.json.JSONObject;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: hxl11
 * @Date: 2021/1/27 14:35
 */
public class test {

    public static void main(String[] args) {
        h1 h = h1.getInstance();
        h.a.put("123", "123");
        h1 h2 = h1.getInstance();
        h2.a.put("234", "234");
        System.out.println(JSONUtils.toJSONString(h2.a));
    }
}
