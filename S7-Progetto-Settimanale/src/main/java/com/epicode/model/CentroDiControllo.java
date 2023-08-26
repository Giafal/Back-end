package com.epicode.model;





import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CentroDiControllo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Sonda> sonde;
	

	
	public void inviaAllarme(Sonda sonda) {
        String url = "http://host/alarm?idsonda=" + sonda.getId() +
                     "&lat=" + sonda.getLatitude() +
                     "&lon=" + sonda.getLongitude() +
                     "&smokelevel=" + sonda.getSmokeLevel();
        System.out.println("Invio allarme: " + url);
    }

}
