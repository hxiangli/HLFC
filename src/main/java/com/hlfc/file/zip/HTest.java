package com.hlfc.file.zip;

import com.hlfc.util.EnvironmentUtil;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 文件压缩
 * @Auther: HXL
 * @Date: 2018/12/19 17:50
 */
public class HTest {

    /**
     * 文件压缩
     */
    @Test
    public void toZip(){

        //源文件路径
        String srcDir = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/xml";
        //输出文件路径
        String fos = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/file";

        FileOutputStream fos1 = null;
        try {
            //输出流
            fos1 = new FileOutputStream(new File(fos + ".zip"));
            FileToZip.toZip(srcDir,fos1,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
