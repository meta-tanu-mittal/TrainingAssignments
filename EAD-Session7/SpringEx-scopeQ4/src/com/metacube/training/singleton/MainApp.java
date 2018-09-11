package com.metacube.training.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("singletonBean.xml");
		Person person1 = (Person) context.getBean("person");
		person1.setName("tanu");
		System.out.println(person1.getName());

		Person person2 = (Person) context.getBean("person");
		System.out.println(person2.getName());

	}

}
