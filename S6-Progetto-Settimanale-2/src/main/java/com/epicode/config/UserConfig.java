package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.security.entity.User;

@Configuration
public class UserConfig {
	
	@Bean("userBean")
	@Scope("prototype")
	public User user() {
		return new User();
	}

}
