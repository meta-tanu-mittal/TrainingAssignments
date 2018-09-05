package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("Beans.xml");
		CollectionExample collection=(CollectionExample) context.getBean("collection");
		collection.getNameList();
		collection.getNameSet();
		collection.getNameMap();
	}

}
