package com.din.integration;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JmsProvider {
	@Autowired
	private JMSServiceSender jmsServiceSender;

	@Autowired
   private JMSServiceReceiver serviceReceiver;

	public void receive() throws Exception {
		jmsServiceSender.send("Hello Spring JMS ActiveMQ!");
		
		serviceReceiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		long count=serviceReceiver.getLatch().getCount();
		System.out.println("jms"+count);
		
		
		
		System.out.println("JMS  ###  " );
	}
}
