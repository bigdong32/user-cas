package com.wds.app.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-11-15 14:59
 */
public class BaseConnector {

    protected Channel channel;

    protected Connection connection;

    protected String queueName;

    public BaseConnector(String queueName) throws IOException {
        this.queueName = queueName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
    }
}
