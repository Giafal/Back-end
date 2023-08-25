package com.epicode.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.epicode.services.SondaService;

public class SondaRunner implements CommandLineRunner {
	
	@Autowired private SondaService service;

	@Override
	public void run(String... args) throws Exception {
		
		service.installaSonda(50.00, 60.00);
	}

}
