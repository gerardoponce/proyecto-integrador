package com.pe.project.food.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user")
				.password("123")
				.roles("USER")
			.and()
			.withUser("admin")
				.password("123")
				.roles("USER", "ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/v1/**").permitAll()
			.antMatchers(HttpMethod.PUT,"/api/v1/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/api/v1/**").permitAll()
			.antMatchers(HttpMethod.GET,"/api/v1/**").permitAll()
			.anyRequest()
			.authenticated();
	}
}
