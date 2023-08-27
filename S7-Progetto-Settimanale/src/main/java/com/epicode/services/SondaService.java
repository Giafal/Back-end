package com.epicode.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.epicode.model.Sonda;
import com.epicode.repositories.SondaRepository;

@Service
public class SondaService {
    
    @Autowired private SondaRepository repo;
    
    @Autowired @Qualifier("sondaBean") private ObjectProvider<Sonda> sondaProvider;

    public Sonda installaSonda(double latitude, double longitude) {
        Sonda sonda = sondaProvider.getObject();
        sonda.setLatitude(latitude);
        sonda.setLongitude(longitude);
        repo.save(sonda);
        return sonda;
    }

    public void avviaAscoltoSonda(Sonda sonda) {
        if(sonda.getSmokeLevel() > 5) {
        	sonda.getListener().inviaAllarme(sonda);
        }
    }
}
