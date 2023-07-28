package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Prenotazione;

@Configuration
public class PrenotazioneConfiguration {
	
	@Bean("prenotazioneBean")
	@Scope("prototype")
	public Prenotazione prenotazione() {
		return new Prenotazione();
	}

}
