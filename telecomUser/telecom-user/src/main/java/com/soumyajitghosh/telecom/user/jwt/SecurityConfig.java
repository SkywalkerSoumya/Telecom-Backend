package com.soumyajitghosh.telecom.user.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	SignupDetailsService service;
	
	@Autowired
	SecurityFilter filter;
	
	
	@Bean
	AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
		
		http.csrf().disable().cors().disable()
		.authorizeHttpRequests()
		.antMatchers("/api/v1/user/register",
						"/api/v1/user/login",
						"/api/v1/user/{id}",
						"/api/v1/user/updateprofile/{id}",
						"/api/v1/user/get-user-all-details/{id}",
						"/api/v1/user/update-broadbandplan/{id}").permitAll()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.anyRequest().authenticated().and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
}