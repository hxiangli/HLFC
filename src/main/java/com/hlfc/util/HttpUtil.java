package com.hlfc.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class HttpUtil {
	public static String toUrl(Map<String,?> param){
		StringBuffer buff = new StringBuffer();
		for(String key : param.keySet()){
			
			buff.append( key + "=" + param.get(key) + "&" );
		}
		
		buff.deleteCharAt(buff.length() - 1);
		return buff.toString();
	}
	
	
	public static String sendPost(String url, Map<String,?> param) {
		return sendPost(url, toUrl(param));
	}
	
	public static String sendPost(String url, String param) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection) realUrl.openConnection();

			// 打开和URL之间的连接

			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST"); // POST方法
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(30000);
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded;charset=utf-8");

			conn.connect();

			// 获取URLConnection对象对应的输出流
			out = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
			// 发送请求参数
			out.write(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Map<String,String> param = new HashMap<String, String>();
		param.put("appCode", "123");
		try {
			param.put("accessKey", URLEncoder.encode("iFtrKweYi9fmN%2BM3iT2iLlxrLs%2FD5w5JT7iwP%2FQ%2FPF3o6XDufj5OKijM3EdSA%2BbC0yXZXQ6Ces7Y90Mfj1k1Fg%3D%3D","UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String result = HttpUtil.sendPost("http://127.0.0.1:7080/uam-provider/oauth/token/accessToken", param);
		System.out.println(result);
	}
	
}
