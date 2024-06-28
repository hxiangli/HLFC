package com.hlfc.http.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



/**
 * 请求发送工具类
 *
 * @author HXL
 * @since 2017-10-17 下午5:21:04
 */
public class ClientRequest {
	
    /**
     * 通用POST连接方式
     * @param reqjson  请求参数
     * @param urlstr   请求路径
     * @return
     */
    public static String commPostConnetionUrl(String reqjson,String urlstr,String contentType){

        String message= null;


        InputStream is = null;

        try {

            URL httpclient =new URL(urlstr);
            HttpURLConnection conn =(HttpURLConnection) httpclient.openConnection();
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(30000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",contentType);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            OutputStream os= conn.getOutputStream();
            System.out.println("请求类型："+contentType+"参数req:"+reqjson);
            os.write(reqjson.getBytes("UTF-8"));//传入参数
            os.flush();
            os.close();

            is =conn.getInputStream();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            message=new String(jsonBytes,"UTF-8");
            System.out.println("返回结果resp:"+message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return message;
    }

    /**
     * 文件下载POST连接方式
     * @param reqjson  请求参数
     * @param urlstr   请求路径
     * @return
     */
    public static byte[] PostFileConnetionUrl(String reqjson,String urlstr,String contentType){

        String message= null;
        InputStream is = null;

        try {

            URL httpclient =new URL(urlstr);
            HttpURLConnection conn =(HttpURLConnection) httpclient.openConnection();
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(30000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",contentType);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            InputStream inputStream =conn.getInputStream();
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            byte[] buff = new byte[1024*1024]; //如果是稍微大的文件，这里配置的大一些
            int len = 0;
            while((len = inputStream.read(buff)) > 0) {
                //把从服务端读取的文件流保存到ByteArrayOutputSteam中
                byteArray.write(buff, 0, len);
                byteArray.flush();
            }
            inputStream.close();
            return byteArray.toByteArray();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    /**
	 * 通用GET连接方式
	 * @param urlstr   请求路径
	 * @return
	 */
	public static String commGetConnectionUrl(String urlstr){
		
		URL url;
		

		InputStreamReader isr =  null;
      
		BufferedReader bufferReader = null;
      
        try {
            url = new URL(urlstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();        
            http.setRequestMethod("GET");        
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");    
            http.setDoInput(true);
            InputStream is =http.getInputStream();
           
            isr = new InputStreamReader(is, "UTF-8");
            bufferReader = new BufferedReader(isr);
            
            StringBuilder resp = new StringBuilder();
            
            String line = bufferReader.readLine();
            if (StringUtils.isEmpty(line)) {
              line = "";
            }
            do
            {
              resp.append(line);
              line = bufferReader.readLine();
              if (line != null) {
            	  resp.append("\n");
              }
            } while (line != null);
           
            //System.out.println("返回结果resp:"+jsonObject.toString());
            return bufferReader.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
             return bufferReader.toString();
             
        } catch (IOException e) {
            e.printStackTrace();
             return bufferReader.toString();
         
        }finally{
        	if(bufferReader!=null){
	        	try {
					bufferReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(isr!=null){
	        	try {
	        		isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
	}
	
}
