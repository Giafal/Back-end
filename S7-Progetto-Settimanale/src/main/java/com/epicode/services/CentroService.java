package com.epicode.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.model.CentroDiControllo;
import com.epicode.repositories.CentroRepository;

@Service
public class CentroService {
	
	@Autowired CentroRepository repo;
	
	@Autowired @Qualifier("centroBean") private ObjectProvider<CentroDiControllo> centroProvider;
	
	
	public CentroDiControllo creaCentro() {
		CentroDiControllo c = centroProvider.getObject();
		repo.save(c);
		return c;
	}

}
