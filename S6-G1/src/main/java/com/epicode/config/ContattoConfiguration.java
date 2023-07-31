package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.model.Contatto;

@Configuration
public class ContattoConfiguration {
	
	@Bean("contattoBean")
	public Contatto contatto() {
		return new Contatto();
	}

}
