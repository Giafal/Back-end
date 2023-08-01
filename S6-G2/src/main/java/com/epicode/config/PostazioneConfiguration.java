package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.Postazione;

@Configuration
public class PostazioneConfiguration {
	
	@Bean("postazioneBean")
	@Scope("prototype")
	public Postazione postazione() {
		return new Postazione();
	}

}
