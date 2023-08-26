package com.epicode.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.epicode.model.CentroDiControllo;
import com.epicode.model.Sonda;
import com.epicode.services.CentroService;
import com.epicode.services.SondaService;

public class SondaRunner implements CommandLineRunner {
	
	@Autowired private SondaService sondaService;
	@Autowired private CentroService centroService;

	@Override
	public void run(String... args) throws Exception {
		
		Sonda s = sondaService.installaSonda(50.00, 60.00);
		
		CentroDiControllo c = centroService.creaCentro();
		
		s.setListener(c);
		s.setSmokeLevel(6);
		
		sondaService.avviaAscoltoSonda(s);
	}

}
