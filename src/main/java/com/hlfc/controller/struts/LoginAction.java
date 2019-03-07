package com.hlfc.controller.struts;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.hlfc.db.mybatislpus.bean.User;

import org.apache.struts2.ServletActionContext;

import com.hlfc.controller.util.ResponseResult;
import com.hlfc.controller.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts 请求测试
 * @author HXL
 * @since 2018-1-4 下午1:46:47
 */
public class LoginAction extends ActionSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
	    HttpServletResponse response = ServletActionContext.getResponse();
	    
	    ResponseResult responseResult = new ResponseResult();
		boolean isuccess = false;
		Object content = null;
		String fn = request.getParameter("fn");
		Gson gson = new Gson();
		try{
			//新增
			if("add".equals(request.getParameter("fn"))){

				String jsonStr =  Utils.readStringFromRequest(request, "UTF-8");
				User user = gson.fromJson(jsonStr,User.class);

		    	isuccess = true;
		    }

		    //修改
			else if("update".equals(fn)){

				String jsonStr =  Utils.readStringFromRequest(request, "UTF-8");
				User user = gson.fromJson(jsonStr,User.class);

			}

			//删除
			else if ("delete".equals(fn)){
			}

			//查询
			else if("query".equals(fn)){

			}

	    }catch(Exception e){
	    	
	    	isuccess = false;
	    	responseResult.setMessage(e.getMessage());
	    }
    	responseResult.setContent(content);
    	responseResult.setSuccess(isuccess);
        Utils.printStr(response, gson.toJson(responseResult));
        
    	return null;
    }

}