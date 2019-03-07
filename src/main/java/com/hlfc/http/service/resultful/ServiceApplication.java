package com.hlfc.http.service.resultful;


import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/**
 * 服务数据推送的接口
 * @author hxl
 * @since 2018-11-7
 */
public class ServiceApplication extends Application {
	
	// 定义服务对象
    Set<Object> services = new HashSet<Object>();  
    
    Set<Class<?>> classSet = new HashSet<Class<?>>();  
    
    /**
     * 初始化服务
     */
    public ServiceApplication()  
    {  
    	services.add(new RestfulService());//推送服务

    }


	@Override
    public Set<Class<?>> getClasses() {   
        return classSet;  
    }  
    
    /**
	 * 获取服务
	 * @return 服务对象
	 */
    @Override  
    public Set<Object> getSingletons() {   
        return services;  
    }  
      
      
  
}  
