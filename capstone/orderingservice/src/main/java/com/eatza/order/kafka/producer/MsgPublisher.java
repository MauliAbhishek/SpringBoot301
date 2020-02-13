package com.eatza.order.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.eatza.order.model.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@EnableBinding(Source.class)
public class MsgPublisher {
	
	
	 @Autowired

     MessageChannel output;

    

     private static final Logger LOG = LoggerFactory.getLogger(MsgPublisher.class);

     public Message sendMessage(@RequestBody Message message){

           output.send(MessageBuilder.withPayload(message).build());

           LOG.info("sending data='{}' to topic='{}'", message);

           return message;
    }
	/*
	 * @Autowired
	 * 
	 * private KafkaTemplate<String, String> kafkaTemplate;
	 * 
	 * 
	 * 
	 * @Value(value = "${kafka-topic}")
	 * 
	 * private String topic;
	 * 
	 * 
	 * 
	 * private final Logger logger = LoggerFactory.getLogger(MsgPublisher.class);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void sendMessage(String message) {
	 * 
	 * logger.info("sending message='{}' to topic='{}'", message, topic);
	 * 
	 * this.kafkaTemplate.send(topic, message);
	 * 
	 * }
	 */
}
