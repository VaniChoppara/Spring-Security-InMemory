package com.app.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager getUsers() {
		
		UserDetails adminUser= User.withDefaultPasswordEncoder()
				.username("Sandya")
				.password("Sandya")
				.authorities("ADMIN")
				.build();
		UserDetails empUser= User.withDefaultPasswordEncoder()
				.username("Ravi")
				.password("Ravi")
				.authorities("USER")
				.build();


		return new InMemoryUserDetailsManager(empUser,adminUser);
	}
	@Bean
	public SecurityFilterChain createFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> 
				authorize.requestMatchers("/contact", "/about").permitAll()
						 .anyRequest().authenticated()).httpBasic(withDefaults()).formLogin(withDefaults());
		return http.build();

	}
}
