package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

import com.epicode.interfaces.SondaListener;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Sonda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double latitude;
	private double longitude;
	private int smokeLevel;
	private List<SondaListener> ascoltatori = new ArrayList<>();
	
	
	public void aggiungiAscoltatore(SondaListener ascoltatore) {
        ascoltatori.add(ascoltatore);
    }

}
