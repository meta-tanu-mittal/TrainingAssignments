package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin@gmail.com").password("{noop}admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("tanu@gmail.com").password("{noop}123456").roles("EMPLOYEE");
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/admin/*").access("hasRole('ADMIN')")
		.antMatchers("/user/*")
		.access("hasRole('EMPLOYEE')").
		and().formLogin().
		loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.loginProcessingUrl("/login").
		failureUrl("/login?error").
		usernameParameter("emailId").
		and().logout()
		.logoutSuccessUrl("/login")
		.logoutUrl("/logout");
		http.csrf().disable();

	}

}