package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Utente;

@Configuration
public class UtenteConfiguration {
	
	@Bean("utenteBean")
	@Scope("prototype")
	public Utente utente() {
		return new Utente();
	}

}
