package com.epicode.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.model.Edificio;
import com.epicode.model.Utente;
import com.epicode.repositories.UtenteRepository;

@Service
public class UtenteService {
	
	Logger log = LoggerFactory.getLogger(UtenteService.class);
	
	@Autowired UtenteRepository repo;
	
	@Autowired @Qualifier("utenteBean") private ObjectProvider<Utente> utenteProvider;
	
	
	public Utente creaUtente(String username, String fullname, String email) {
		Utente u = utenteProvider.getObject();
		u.setUsername(username);
		u.setFullname(fullname);
		u.setEmail(email);
		repo.save(u);
		log.info("Utente " + u.getUsername() + " salvato nel DB!!!");
		return u;
	}
	
	public void modificaUtente(Utente u) {
		repo.save(u);
		log.info("Utente " + u.getUsername() + " modificato nel DB!!!");
	}
	
	public Utente findById(Long id) {
		return repo.findById(id).get();
	}
	
	public void findAll() {
		repo.findAll().forEach(e -> System.out.println(e));
	}
	
	public void rimuoviUtente(Utente u) {
		repo.delete(u);
		log.info("Utente " + u.getUsername() + " eliminato dal DB!!!");
	}


}
