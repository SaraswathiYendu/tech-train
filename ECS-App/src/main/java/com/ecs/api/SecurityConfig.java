package com.ecs.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(getPasswordEncoder())
		.withUser("harry@gmail.com").password(getPasswordEncoder().encode("potter@123"))
		.authorities("EMPLOYEE")
		.and()
		.withUser("ronald@gmail.com").password(getPasswordEncoder().encode("weasley@123"))
		.authorities("EMPLOYEE")
		.and()
		.withUser("albus@gmail.com").password(getPasswordEncoder().encode("albus@123"))
		.authorities("MANAGER")
		.and()
		.withUser("severus@gmail.com").password(getPasswordEncoder().encode("snape@gmail.com"))
		.authorities("MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/api/user/login").permitAll()
		.antMatchers("/api/manager/one").permitAll()
		.antMatchers("/api/employee/all").permitAll()
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();	
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
}
