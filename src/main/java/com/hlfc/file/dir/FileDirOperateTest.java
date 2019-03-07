package com.hlfc.file.dir;

import com.hlfc.util.EnvironmentUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹创建，删除，包括父文件夹，子文件夹
 * @Auther: HXL
 * @Date: 2018/12/19 17:02
 */
public class FileDirOperateTest {


    /**
     * 文件创建
     */
    @Test
    public void FileCreate(){
        String filepath = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/fileDir1/fileDir2/File.txt";
        File file = new File(filepath);
        if (!file.getParentFile().exists()) {//父文件是否存在
            file.getParentFile().mkdirs();
        }
        try {
            //判断文件是否存在，存在先删除
            if(file.exists()&&file.isFile())
                file.delete();
            //文件创建
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
