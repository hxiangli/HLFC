package com.hlfc.http.service.resultful;

import com.hlfc.controller.util.ResponseResult;
import org.jboss.resteasy.annotations.interception.Precedence;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * restful测试
 * @author hxl
 * @since  2018-11-7
 */
@Path("restfulservice")
@Precedence(MediaType.APPLICATION_JSON)
public class RestfulService {


	@POST
    @Path("postTest")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseResult getManagerList(@FormParam("operType") String operType) {
		Boolean bean = true;
		ResponseResult result = new ResponseResult(operType);
		return result;
	}	
	

}
