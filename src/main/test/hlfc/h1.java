package hlfc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: hxl
 * @Date: 2023/1/11 10:09
 */
public class h1 {
    public Map a = new HashMap();

    private static class InstanceHold {
        private static h1 lineAudioCaptureTesting = new h1();
    }

    public static h1 getInstance() {
        h1 instance = InstanceHold.lineAudioCaptureTesting;
        return instance;
    }
}
