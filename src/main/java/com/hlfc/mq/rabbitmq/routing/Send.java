package com.hlfc.mq.rabbitmq.routing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.hlfc.mq.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 路由模式
 */

public class Send {
	
	private static final String EXCHANGE_NAME="test_exchange_direct";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		
		Connection connection = ConnectionUtils.getConnection();
		
		Channel channel = connection.createChannel();
		
		//exchange
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
		String  msg="hello direct!";
		
		
		String routingKey="info";
		channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
		
		System.out.println("send "+msg);
		
		channel.close();
		connection.close();
	}
}
