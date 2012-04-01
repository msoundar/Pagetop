package com.page.pagetop.service;

import java.util.List;

import org.springframework.integration.Message;
import org.springframework.integration.aggregator.CorrelationStrategy;

public class NotificationAggregator implements CorrelationStrategy {

	 public NotificationMessage aggregate(List<NotificationMessage> results) {
		 
		 	System.out.println("++++++ Aggregating: depth:" + results.size() );
		 	NotificationMessage msg = new NotificationMessage();
		 	msg.toAddress = results.get(0).getToAddress();
		 	msg.fromAddress = results.get(0).getFromAddress();
		 	msg.messageBody = "You have received " + results.size() + " messages so far.";
		 	msg.outBoundChannel = results.get(0).outBoundChannel;
		 	
		    return msg;
	}
	 
	 // Release strategy
	 public boolean canRelease(List<NotificationMessage> msgs) {
		 	System.out.println("******** Can Release called - depth:" + msgs.size() );
		    return (msgs != null) && msgs.size() >= 5;
	 }

	public Object getCorrelationKey(Message<?> arg0) {
		// TODO Auto-generated method stub		
	 	System.out.println("------- getCorrletionKey:" +  ((NotificationMessage) arg0.getPayload()).getToAddress());
		return ((NotificationMessage) arg0.getPayload()).getToAddress();
	}

}
