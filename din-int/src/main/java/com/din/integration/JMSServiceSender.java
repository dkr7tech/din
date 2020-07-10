package com.din.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSServiceSender {
	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
		System.out.println("Sending message -------- =" + message);
		jmsTemplate.convertAndSend("helloworld.q", message);
	}
}
