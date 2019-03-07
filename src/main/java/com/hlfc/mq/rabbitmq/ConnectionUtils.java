package com.hlfc.mq.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 连接mq队列工具类
 * @Auther: HXL
 * @Date: 2018/11/23 13:54
 */
public class ConnectionUtils {


    /**
     * 获取MQ的连接
     * @return
     */
    public static Connection getConnection() throws IOException, TimeoutException {

        //定义一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务器地址
        factory.setHost("127.0.0.1");

        //AMQP 5672
        factory.setPort(5672);

        //vhost
        factory.setVirtualHost("/vhost_hlfc");

        //用户名
        factory.setUsername("hlfc");

        //密码
        factory.setPassword("hlfc");

        return factory.newConnection();
    }
}
