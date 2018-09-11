package com.metacube.training.collection;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")

    	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfigration.class);
		CollectionExample collection=(CollectionExample) context.getBean(CollectionExample.class);
		collection.getNameList();
		System.out.println(collection.getNameList());
		System.out.println(collection.getNameSet());
		System.out.println(collection.getNameMap());
	}

}
