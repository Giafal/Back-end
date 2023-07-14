package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Libro extends Articolo {
	
	
	private String autore;
	
	private String genere;
	
	public Libro() {
		super();
		
	}

	public Libro(String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
		
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", getCodiceISBN()=" + getCodiceISBN()
				+ ", getTitolo()=" + getTitolo() + ", getAnnoPubblicazione()=" + getAnnoPubblicazione()
				+ ", getNumeroPagine()=" + getNumeroPagine() + "]";
	}
	
	
	

}
