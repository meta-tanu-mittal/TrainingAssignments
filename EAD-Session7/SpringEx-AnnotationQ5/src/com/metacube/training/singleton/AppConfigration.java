package com.metacube.training.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigration {

	@Bean
	@Scope("singleton")
	public Person person()
	{
		Person person=new Person();
		person.setName("abc");
		return person;
	}

}
