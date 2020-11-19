package com.hlfc.controller.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HXL
 * @since 2018-1-4 下午4:05:25
 */
public class Utils {

	
	/**
	 * 将HttpServletRequest内容转换成 String
	 * @param request 请求对象 HttpServletRequest
	 * @param encode 编码 String
	 * @return 请求内容 String
	 */
	public static String readStringFromRequest(HttpServletRequest request,String encode) {
		StringBuffer json = new StringBuffer();
		InputStream in = null;
		try {
			in = request.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, encode);
			BufferedReader bufferReader = new BufferedReader(isr);
			String line = bufferReader.readLine();
			if(StringUtils.isEmpty(line)){
				line = "";
			}
			do {
				json.append(line);
				line = bufferReader.readLine();
				if(line != null){
					json.append("\n");
				}
			} while (line != null);
			//end mfy 2012-12-23
			
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
//			try {
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		return json.toString();
	}
	
	/**
	 * 打印JSONObject
	 * 
	 * @param response
	 * @param jsonStr
	 */
	public static void printStr(HttpServletResponse response,
			String jsonStr) {

		if (jsonStr == null) {
			return;
		}

		response.setContentType("application/json; charset=utf-8");
		try {
			response.getWriter().write(jsonStr.toString());
		} catch (IOException e) {
			e.getMessage();
		}
	}
}
