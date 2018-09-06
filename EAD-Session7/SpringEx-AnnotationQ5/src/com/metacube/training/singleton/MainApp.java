package com.metacube.training.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigration.class);
		 Person person1=(Person) context.getBean("person");
	        System.out.println(person1.getName());
	        person1.setName("Tanu");
	        Person person2=(Person) context.getBean("person");
	        System.out.println(person2.getName());

	}

}
