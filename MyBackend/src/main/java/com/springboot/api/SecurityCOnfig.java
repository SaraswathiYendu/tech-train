package com.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.api.service.MyUserDetailsService;

@Configuration
public class SecurityCOnfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 /* Using AuthenticationManagerBuilder, I will pass my own authentication
		   implementation */
		/* 
		auth.inMemoryAuthentication()
		.passwordEncoder(getPasswordEncoder())
			.withUser("harry")
			.password(getPasswordEncoder().encode("potter"))
			.authorities("ADMIN")
			.and()
			.withUser("ronald")
			.password(getPasswordEncoder().encode("weasley"))
			.authorities("CUSTOMER")
			.and()
			.withUser("severus")
			.password(getPasswordEncoder().encode("snape"))
			.authorities("INSTRUCTOR");
			*/
		
		auth.authenticationProvider(getDBAuth());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* Using http, I will define security of my api(s) on the basis of roles. */
		http.authorizeRequests()
		.antMatchers("/employees/all").authenticated()
		.antMatchers("/department/all").hasAuthority("ADMIN")
		.antMatchers("/course/all").hasAnyAuthority("ADMIN","INSTRUCTOR")
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public DaoAuthenticationProvider getDBAuth(){
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		/* provide pass encoder details */
		dao.setPasswordEncoder(getPasswordEncoder());
		/* provide details of service class that will take this Auth to DB */
		dao.setUserDetailsService(myUserDetailsService);
		return dao; 
	}
	
}
