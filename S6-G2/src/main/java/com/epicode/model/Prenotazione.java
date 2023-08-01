package com.epicode.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Postazione postazione;
	@ManyToOne
	private Utente utente;
	private LocalDate dataPrenotazione;
	
	
	
	public Prenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
		super();
		this.postazione = postazione;
		this.utente = utente;
		this.dataPrenotazione = dataPrenotazione;
	}
	
	

}
