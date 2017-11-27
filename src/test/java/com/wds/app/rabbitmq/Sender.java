package com.wds.app.rabbitmq;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-11-15 15:20
 */
public class Sender extends BaseConnector{

    public Sender(String queueName) throws IOException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }
}
