package com.din.integration;

import java.util.concurrent.CountDownLatch;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
@Service
public class JMSServiceReceiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@JmsListener(destination = "helloworld.q")
	public void receive(String message) {
		System.out.println("received messag$$$$e={}"+message);
		latch.countDown();
	}
}
