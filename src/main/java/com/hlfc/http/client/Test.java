package com.hlfc.http.client;

/**
 * 请求测试类
 * @author HXL
 * @since 2017-10-17 下午5:45:28
 */
public class Test {
	
	public static void main(String[] args) {
		
		String reqjson = "operType=123";
		String urlstr = "http://127.0.0.1:9090/hlfc/restfulservice/postTest?id=123123";
		ClientRequest.commPostConnetionUrl(reqjson, urlstr);
	}

}
