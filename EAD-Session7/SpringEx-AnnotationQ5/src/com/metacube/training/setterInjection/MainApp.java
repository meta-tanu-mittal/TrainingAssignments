package com.metacube.training.setterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext contex = new AnnotationConfigApplicationContext(AppConfigration.class);
		TextEditor textEditor = (TextEditor) contex.getBean(TextEditor.class);
		textEditor.checkSpell();

	}

}
