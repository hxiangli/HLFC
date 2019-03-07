package com.hlfc.http;

import com.hlfc.util.EnvironmentUtil;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * http请求文件下载
 * @Auther: HXL
 * @Date: 2018/12/20 16:30
 */
public class HttpWebDownloadTest {

    /**
     * 文件下载
     */
    public void downflowFile() throws UnsupportedEncodingException {

        String filepath = EnvironmentUtil.getInstance().getWebInfPath()+ "/other/file/File.xlsx";
        HttpServletResponse response = ServletActionContext.getResponse();
        //下载
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode("流程监控图与日志","UTF-8")+".xlsx");
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/octet-stream");

        OutputStream ops = null;
        FileInputStream fis =null;
        byte[] buffer = new byte[8192];
        int bytesRead = 0;

        try {
            ops = response.getOutputStream();
            fis = new FileInputStream(filepath);
            while((bytesRead = fis.read(buffer, 0, 8192)) != -1){
                ops.write(buffer, 0, bytesRead);
            }
            ops.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(ops != null){
                    ops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
