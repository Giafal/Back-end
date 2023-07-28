package com.epicode.runners;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.enumerations.TipoPostazione;
import com.epicode.model.Edificio;
import com.epicode.model.Postazione;
import com.epicode.model.Utente;
import com.epicode.services.EdificioService;
import com.epicode.services.PostazioneService;
import com.epicode.services.PrenotazioneService;
import com.epicode.services.UtenteService;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired EdificioService edificioService;
	@Autowired PostazioneService postazioneService;
	@Autowired UtenteService utenteService;
	@Autowired PrenotazioneService prenotazioneService;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Run...");
		
		edificioService.creaEdificio("Palazzo Arnieci", "Via Canosa", "Andria");
		edificioService.creaEdificio("Palazzo Vitti", "Via Regina Margherita", "Barletta");
		edificioService.creaEdificio("Palazzo Nugnes", "Via Bovio", "Trani");
		
		Edificio edificio1 = edificioService.findById(1l);
		Edificio edificio2 = edificioService.findById(2l);
		Edificio edificio3 = edificioService.findById(3l);
		
		postazioneService.creaPostazione("Scrivania singola", TipoPostazione.PRIVATO, 1, edificio1, false);
		postazioneService.creaPostazione("Scrivania doppia", TipoPostazione.OPEN_SPACE, 2, edificio2, false);
		postazioneService.creaPostazione("Sala riunioni", TipoPostazione.SALA_RIUNIONI, 5, edificio3, false);
		
		Postazione postazione1 = postazioneService.findById(1l);
		Postazione postazione2 = postazioneService.findById(2l);
		Postazione postazione3 = postazioneService.findById(3l);
		
		utenteService.creaUtente("Giafal", "Gianluca Falcone", "g.falcone@yahoo.it");
		utenteService.creaUtente("Anba", "Andrea Bardi", "a.bardi@yahoo.it");
		utenteService.creaUtente("Vinsc", "Vincenzo Schembri", "v.schembri@yahoo.it");
		
		Utente utente1 = utenteService.findById(1l);
		Utente utente2 = utenteService.findById(2l);
		Utente utente3 = utenteService.findById(3l);
		
		prenotazioneService.creaPrenotazione(postazione1, utente1, LocalDate.of(2023, 7, 28));
		prenotazioneService.creaPrenotazione(postazione1, utente2, LocalDate.of(2023, 7, 28));
		prenotazioneService.creaPrenotazione(postazione3, utente3, LocalDate.of(2023, 8, 1));
		
		postazioneService.findByTipoAndCitta(TipoPostazione.PRIVATO, "Andria");
		
		
		
		
		
		
		
	}

}
