package com.hlfc.file.image;

import com.hlfc.util.EnvironmentUtil;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片文件生成,并绘制
 * @Auther: HXL
 * @Date: 2018/12/19 17:25
 */
public class HTest {

    @Test
    public void ImageCreate(){
        String filepath = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/File.jpg";
        File file = new File(filepath);

        //图片流
        BufferedImage bi = new BufferedImage(800, 800,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();

        g.drawString("老婆吃饭了",100,100);
        try {
            ImageIO.write(bi, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
