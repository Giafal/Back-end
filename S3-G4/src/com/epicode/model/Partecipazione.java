package com.epicode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epicode.enumerations.Stato;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Persona persona;
	private Evento evento;
	private Stato stato;
	
	public Partecipazione() {
		super();
	}

	public Partecipazione(Persona persona, Evento evento, Stato stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Stato getStato() {
		return stato;
	}

	public void setStato(Stato stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}
	
	

}
