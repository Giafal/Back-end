package com.epicode.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.model.CentroDiControllo;

@Configuration
public class CentroConfig {
	
	@Bean("centroBean")
	@Scope("singleton")
	public CentroDiControllo centro() {
		return new CentroDiControllo();
	}

}
