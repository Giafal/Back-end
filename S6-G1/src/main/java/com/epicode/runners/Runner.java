package com.epicode.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.model.Contatto;
import com.epicode.services.ContattoService;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired ContattoService cs;

	@Override
	public void run(String... args) throws Exception {
		
		//Contatto c1 = cs.creaContatto("Andrea", "Bardi", "3294568971");
		//Contatto c2 = cs.creaContatto("Federico", "Morgante", "3331252444");
//		Contatto c3 = cs.creaContatto("Vincenzo", "Schembri", "3487596321");
		
		//cs.salvaContatto(c1);
//		cs.salvaContatto(c2);
//		cs.salvaContatto(c3);
		
//		Contatto contatto = cs.findById(5l);
//		System.out.println(contatto);
//		cs.rimuoviContatto(contatto);
		
	}

}
