package com.hlfc.db.hibernate;

import com.hlfc.db.hibernate.bean.User;
import com.hlfc.db.hibernate.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by HXL on 2018/9/4.
 */
public class HTest {

    private IUserService userService;

    private static ApplicationContext context;

     {
         context = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
         userService =  context.getBean(IUserService.class);
    }

    @Test
    public void test1(){

        //mybatiseplus 查询
        User user = userService.getById("123123123");

    }

    @Test
    public void test11(){



        //mybatiseplus 查询
        List<User> users = userService.findByUserName("你好");

    }
}
