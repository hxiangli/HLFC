package com.hlfc.mq.rabbitmq.simple;

/**
 * 简单队列模式
 * 生成者
 * 耦合性高 生产消费一一对应(如果有多个消费者想都消费这个消息,就不行了) 队列名称变更时需要同时更改
 */

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.hlfc.mq.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {
	private static final String QUEUE_NAME="test_simple_queue";
	public static void main(String[] args) throws IOException, TimeoutException {
		
		//获取一个连接
		Connection connection = ConnectionUtils.getConnection();
		
		//从连接中获取一个通道
		Channel channel = connection.createChannel();
		//创建队列声明 
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String msg="hello simple !";
		
		channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
		
		System.out.println("--send msg:"+msg);
		
		channel.close();
		connection.close();
	}

}
