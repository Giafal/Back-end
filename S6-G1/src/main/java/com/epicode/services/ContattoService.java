package com.epicode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.model.Contatto;
import com.epicode.repositories.ContattoRepository;

@Service
public class ContattoService {
	
	Logger log = LoggerFactory.getLogger(ContattoService.class);
	
	@Autowired ContattoRepository repo;
	
	@Autowired @Qualifier("contattoBean") private ObjectProvider<Contatto> contattoProvider;
	
	
	public Contatto creaContatto(String nome, String cognome, String numeroTelefono) {
		Contatto c = contattoProvider.getObject();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setNumeroTelefono(numeroTelefono);
		repo.save(c);
		return c;
	}
	
	public void salvaContatto(Contatto c) {
		repo.save(c);
		log.info(c.getNome() + c.getCognome() + " salvato nel DB!!!");
	}
	
	public Contatto findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void rimuoviContatto(Contatto e) {
		repo.delete(e);
		log.info("Edificio " + e.getNome() + " eliminato dal DB!!!");
	}

}
