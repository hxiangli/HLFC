package com.hlfc.mq.rabbitmq.confirm;

/**
 * 事务机制，有异步方式提供
 */

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.hlfc.mq.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class Recv {

	private static final String QUEUE_NAME="test_queue_confirm3";
	
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		channel.basicConsume(QUEUE_NAME, true,new DefaultConsumer(channel){
			
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,
					BasicProperties properties, byte[] body) throws IOException {
				System.out.println("recv[confirm] msg:"+new String(body,"utf-8"));
			}
		});
	}

}
