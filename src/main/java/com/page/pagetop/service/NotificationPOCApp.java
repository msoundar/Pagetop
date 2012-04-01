package com.page.pagetop.service;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Location Update POC App
 */
public class NotificationPOCApp {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-context.xml", NotificationPOCApp.class);
				
	}
	
}
