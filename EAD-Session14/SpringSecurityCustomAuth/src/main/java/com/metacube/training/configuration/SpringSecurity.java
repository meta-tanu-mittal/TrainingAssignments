package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	// @Autowired
	// DataSource dataSource;

	// @SuppressWarnings("deprecation")
	// @Autowired
	// public void configAuthentication(AuthenticationManagerBuilder auth)
	// throws Exception {
	//
	// auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
	// .usersByUsernameQuery(
	// "select email_id as username,password,enabled from employee where email_id=?")
	// .authoritiesByUsernameQuery(
	// "select email_id as username,role from user_roles where email_id=?");
	//
	// }
	// protected void configure(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication().withUser("admin@gmail.com").password("{noop}admin").roles("ADMIN");
	// auth.inMemoryAuthentication().withUser("tanu@gmail.com").password("{noop}123456").roles("EMPLOYEE");
	// }

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')").and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/dashboard")
				.loginProcessingUrl("/login").failureUrl("/login?error")
				.usernameParameter("emailId").and().logout()
				.logoutSuccessUrl("/login").logoutUrl("/logout");
		http.csrf().disable();

	}

}