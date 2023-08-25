package com.epicode.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Sonda;

@Configuration
public class SondaConfig {
	
	@Bean
	@Scope("singleton")
	public Sonda sonda() {
		return new Sonda();
	}

}
