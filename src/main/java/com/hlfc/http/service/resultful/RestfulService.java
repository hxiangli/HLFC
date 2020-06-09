package com.hlfc.http.service.resultful;

import com.hlfc.controller.util.ResponseResult;
import org.apache.http.HttpResponse;
import org.jboss.resteasy.annotations.interception.Precedence;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.Base64;
import java.util.Map;

/**
 *
 * https://blog.csdn.net/private66/article/details/82259664
 * restful测试
 * @author hxl
 * @since  2018-11-7
 */
@Path("rest")
//@Precedence(MediaType.APPLICATION_JSON)
//@Consumes，标注可接受请求的MIME媒体类型
public class RestfulService {


	/**
	 *  application/x-www-form-urlencoded"接受
	 * @param operType
	 * @return
	 */
	@POST
    @Path("postTest")
    @Produces(MediaType.APPLICATION_JSON) //返回格式
    public ResponseResult getManagerList(@FormParam("operType") String operType,@QueryParam(value = "id")  String id) {
		Boolean bean = true;
		ResponseResult result = new ResponseResult(operType);
		return result;
	}


	/**
	 * application/json接受
	 * @param map
	 * @return
	 */
	@POST
	@Path("postTest2")
	@Produces(MediaType.APPLICATION_JSON) //返回格式
	public ResponseResult getManagerList22( Map map,@QueryParam(value = "id")  String id) {
		Boolean bean = true;
		ResponseResult result = new ResponseResult(map);
		return result;
	}

	//----获取文件流----
	/**
	 * application/json接受
	 * @return
	 */
	@POST
	@Path("postFile")
	public void getFile(@Context HttpServletResponse httpResponse) {
		Boolean bean = true;
		ResponseResult result = new ResponseResult();
		OutputStream outputStream = null;
		try {
			//创建文件输出流
			//得到输入流
			FileInputStream inputStream = new FileInputStream("C:\\Users\\ASUS\\Desktop\\temp\\tran_01.doc");
			outputStream =  httpResponse.getOutputStream();
			byte[] buff = new byte[100];
			int rc = 0;
			while ((rc = inputStream.read(buff, 0, 100)) > 0) {
				outputStream.write(buff, 0, rc);
			}
			outputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
