package com.epicode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.model.Edificio;
import com.epicode.repositories.EdificioRepository;

@Service
public class EdificioService {
	
	Logger log = LoggerFactory.getLogger(EdificioService.class);
	
	@Autowired EdificioRepository repo;
	
	@Autowired @Qualifier("edificioBean") private ObjectProvider<Edificio> edificioProvider;
	
	
	public Edificio creaEdificio(String nome, String indirizzo, String citta) {
		Edificio e = edificioProvider.getObject();
		e.setNome(nome);
		e.setIndirizzo(indirizzo);
		e.setCitta(citta);
		repo.save(e);
		log.info("Edificio " + e.getNome() + " salvato nel DB!!!");
		return e;
	}
	
	public void modificaEdificio(Edificio e) {
		repo.save(e);
		log.info("Edificio " + e.getNome() + " modificato nel DB!!!");
	}
	
	public Edificio findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void findAll() {
		repo.findAll().forEach(e -> System.out.println(e));
	}
	
	public void rimuoviEdificio(Edificio e) {
		repo.delete(e);
		log.info("Edificio " + e.getNome() + " eliminato dal DB!!!");
	}

}
