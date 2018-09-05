package com.metacube.training.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext contex = new ClassPathXmlApplicationContext("beans.xml");
		TextEditor textEditor = (TextEditor) contex.getBean("textEditor");
		textEditor.checkSpell();

	}

}
