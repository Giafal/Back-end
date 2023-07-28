package com.epicode.services;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.model.Postazione;
import com.epicode.model.Prenotazione;
import com.epicode.model.Utente;
import com.epicode.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	Logger log = LoggerFactory.getLogger(PrenotazioneService.class);
	
	@Autowired PrenotazioneRepository repo;
	
	@Autowired @Qualifier("prenotazioneBean") private ObjectProvider<Prenotazione> prenotazioneProvider;
	
	
	public Prenotazione creaPrenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
		if(repo.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione).size() < postazione.getNumeroMassimoOccupanti()) {
			if (repo.findByUtenteAndDataPrenotazione(utente, dataPrenotazione) == null) {
		Prenotazione p = prenotazioneProvider.getObject();
		p.setPostazione(postazione);
		p.setUtente(utente);
		p.setDataPrenotazione(dataPrenotazione);
		repo.save(p);
		log.info("Prenotazione numero: " + p.getId() + " salvata nel DB!!!");
		postazione.setOccupata(true);
		return p;
		} else {
			log.error("Hai già prenotato una postazione in questa data!!!");
			return null;
		}
		} else {
			log.error("La postazione scelta è già occupata!!!");
			return null;
		}
	
	}
	
	public void modificaPrenotazione(Prenotazione p) {
		repo.save(p);
		log.info("Prenotazione numero: " + p.getId() + " modificata nel DB!!!");
	}
	
	public Prenotazione findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void findAll() {
		repo.findAll().forEach(e -> System.out.println(e));
	}
	
	public void rimuoviPrenotazione(Prenotazione e) {
		repo.delete(e);
		log.info("Prenotazione numero: " + e.getId() + " eliminata dal DB!!!");
	}

}
