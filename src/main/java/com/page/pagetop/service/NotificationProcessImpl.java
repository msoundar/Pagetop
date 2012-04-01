package com.page.pagetop.service;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;


@WebService(endpointInterface = "com.page.pagetop.service.notificationservice.NotificationProcess")
public class NotificationProcessImpl implements ApplicationContextAware{

	 ApplicationContext context = null;
	 public void notify(NotificationMessage message) {
		 System.out.println("asdf");
		 
		MessageChannel inChannel = context.getBean("unMarshalledMessageChannel", MessageChannel.class);
		Message<NotificationMessage> msg = new GenericMessage<NotificationMessage>(message);
		inChannel.send( msg );		 
	 }
	 
	 public void setApplicationContext( ApplicationContext ctx )
	 {
		 this.context = ctx;
	 }
}
