package com.metacube.training.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigration {

	@Bean
	@Scope("prototype")
	public Person person()
	{
		Person person=new Person();
		person.setName("abc");
		return person;
	}

}
