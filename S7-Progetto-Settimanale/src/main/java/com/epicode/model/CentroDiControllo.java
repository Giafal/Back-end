package com.epicode.model;



import org.springframework.stereotype.Component;

import com.epicode.interfaces.SondaListener;



@Component
public class CentroDiControllo implements SondaListener {
	

	@Override
	public void segnalaIncendio(Sonda sonda) {
		inviaAllarme(sonda);
		
	}
	
	private void inviaAllarme(Sonda sonda) {
        String url = "http://host/alarm?idsonda=" + sonda.getId() +
                     "&lat=" + sonda.getLatitude() +
                     "&lon=" + sonda.getLongitude() +
                     "&smokelevel=" + sonda.getSmokeLevel();
        System.out.println("Invio allarme: " + url);
    }

}
