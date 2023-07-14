package com.epicode.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.epicode.enumeration.Periodicita;

@Entity
@DiscriminatorValue("rivista")
public class Rivista extends Articolo {
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista() {
		super();
		
	}

	public Rivista(String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", getCodiceISBN()=" + getCodiceISBN() + ", getTitolo()="
				+ getTitolo() + ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumeroPagine()="
				+ getNumeroPagine() + "]";
	}
	
	

}
