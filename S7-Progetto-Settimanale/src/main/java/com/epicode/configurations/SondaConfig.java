package com.epicode.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Sonda;

@Configuration
public class SondaConfig {
	
	@Bean("sondaBean")
	@Scope("prototype")
	public Sonda sonda() {
		return new Sonda();
	}

}
