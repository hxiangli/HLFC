package com.hlfc.http.client;

/**
 * 请求测试类
 * @author HXL
 * @since 2017-10-17 下午5:45:28
 *
 * https://blog.csdn.net/justry_deng/article/details/81042379
 *
 * Accept代表发送端（客户端）希望接受的数据类型。
 *Content-Type代表发送端（客户端|服务器）发送的实体数据的数据类型。
 *
 *
 */
public class Test {
	
	public static void main(String[] args) {


		String formContentType = "application/x-www-form-urlencoded";
		String jsonContentType = "application/json";
		String urlstr = "http://127.0.0.1:9090/hlfc/rest/postTest?id=123123";


		//form表单提交方式
		String reqform = "operType=123";
		ClientRequest.commPostConnetionUrl(reqform, urlstr,formContentType);

		 urlstr = "http://127.0.0.1:9090/hlfc/rest/postTest2?id=123123";
		//json
		String reqjson = "{\"operType\":\"234\"}";
		ClientRequest.commPostConnetionUrl(reqjson, urlstr,jsonContentType);
	}

}
