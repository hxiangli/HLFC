package com.hlfc.db.mybatislpus;

import com.hlfc.db.mybatislpus.bean.User;
import com.hlfc.db.mybatislpus.service.IUserService;
import com.hlfc.db.mybatislpus.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by HXL on 2018/9/4.
 */
public class HTest {

    private IUserService userService;

    private static ApplicationContext context;

    static {
         context = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
    }

    @Test
    public void test1(){


        //读取一个文件

//        IUserService userService11 = (IUserService)context.getBean("UserServiceImpl");
        userService =  context.getBean(IUserService.class);

        //mybatiseplus 查询
        List<User> user = userService.getByName("123");
    }
}
