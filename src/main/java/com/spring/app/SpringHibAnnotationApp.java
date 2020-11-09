package com.spring.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.model.User;
import com.spring.service.UserService;

public class SpringHibAnnotationApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext  appCtx = new AnnotationConfigApplicationContext();
		appCtx.scan("com.spring"); 
		appCtx.refresh();
		
		UserService userService = (UserService) appCtx.getBean("userService");

		userService.saveUser(new User("Harish", "New Delhi"));
		userService.saveUser(new User("Nbj", "Bengaluru"));
		userService.saveUser(new User("popo", "Chennai"));

		List<User> userList = userService.findAllUsers();
		for (User u : userList) {
			System.out.println("Id: " + u.getUserId() + "\tName: " + u.getName());
		}
		appCtx.close();
	}
}
