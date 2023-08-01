package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Edificio;

@Configuration
public class EdificioConfiguration {
	
	@Bean("edificioBean")
	@Scope("prototype")
	public Edificio edificio() {
		return new Edificio();
	}

}
