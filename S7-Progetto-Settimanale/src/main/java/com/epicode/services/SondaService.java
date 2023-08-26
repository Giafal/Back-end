package com.epicode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.model.CentroDiControllo;
import com.epicode.model.Sonda;
import com.epicode.model.SondaFactory;
import com.epicode.repositories.SondaRepository;

@Service
public class SondaService {
    @Autowired
    private SondaFactory sondaFactory;
    
    @Autowired
    private SondaRepository repo;

    public Sonda installaSonda(double latitude, double longitude) {
        Sonda sonda = sondaFactory.creaSonda(latitude, longitude);
        repo.save(sonda);
        return sonda;
    }

    public void avviaAscoltoSonda(Sonda sonda) {
        if(sonda.getSmokeLevel() > 5) {
        	sonda.getListener().inviaAllarme(sonda);
        }
    }
}
