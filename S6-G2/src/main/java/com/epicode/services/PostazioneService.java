package com.epicode.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.enumerations.TipoPostazione;
import com.epicode.model.Edificio;
import com.epicode.model.Postazione;
import com.epicode.repositories.PostazioneRepository;

@Service
public class PostazioneService {
	
	Logger log = LoggerFactory.getLogger(PostazioneService.class);
	
	@Autowired PostazioneRepository repo;
	
	@Autowired @Qualifier("postazioneBean") private ObjectProvider<Postazione> postazioneProvider;
	
	
	public Postazione creaPostazione(String descrizione, TipoPostazione tipo, Integer numeroMassimoOccupanti, Edificio edificio,
			boolean occupata) {
		Postazione p = postazioneProvider.getObject();
		p.setDescrizione(descrizione);
		p.setTipo(tipo);
		p.setNumeroMassimoOccupanti(numeroMassimoOccupanti);
		p.setEdificio(edificio);
		p.setOccupata(occupata);
		repo.save(p);
		log.info("Postazione numero: " + p.getId() + " salvata nel DB!!!");
		return p;
	}
	
	public void modificaPostazione(Postazione p) {
		repo.save(p);
		log.info("Postazione numero: " + p.getId() + " modificata nel DB!!!");
	}
	
	public Postazione findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void findAll() {
		repo.findAll().forEach(e -> System.out.println(e));
	}
	
	public void rimuoviPostazione(Postazione e) {
		repo.delete(e);
		log.info("Postazione numero: " + e.getId() + " eliminata dal DB!!!");
	}
	
	public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta) {
		List<Postazione> risultato = repo.findByTypeAndCity(tipo, citta);
		if(risultato.size() == 0) {
			log.info("Non ci sono postazioni di questo tipo nella citta ricercata");
			return null;
		} else {
			log.info("Ci sono postazioni di questo tipo nella citta ricercata");
			risultato.forEach(r -> System.out.println(r));
			return risultato;
		}
	}

}
