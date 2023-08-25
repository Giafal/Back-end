package com.epicode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.interfaces.SondaListener;
import com.epicode.model.CentroDiControllo;
import com.epicode.model.Sonda;
import com.epicode.model.SondaFactory;
import com.epicode.repositories.SondaRepository;

@Service
public class SondaService {
    @Autowired
    private SondaFactory sondaFactory;
    @Autowired
    private CentroDiControllo centroDiControllo;
    @Autowired
    private SondaRepository repo;

    public void installaSonda(double latitude, double longitude) {
        Sonda sonda = sondaFactory.creaSonda(latitude, longitude);
        sonda.aggiungiAscoltatore(centroDiControllo);
        avviaAscoltoSonda(sonda);
        repo.save(sonda);
    }

    private void avviaAscoltoSonda(Sonda sonda) {
        if(sonda.getSmokeLevel() > 5) {
        	SondaListener cdc = (SondaListener) sonda.getAscoltatori();
        	cdc.segnalaIncendio(sonda);
        }
    }
}
