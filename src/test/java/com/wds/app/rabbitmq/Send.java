package com.wds.app.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-11-15 14:03
 */
public class Send {

    public static final String QUEUE_NAME = "hello_queue";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "hello wds";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("sent:" + message);
        channel.close();
        connection.close();
    }
}
