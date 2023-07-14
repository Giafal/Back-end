package com.epicode.model;

import javax.persistence.*;


@Entity
@Table(name = "articoli")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoArticolo", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "ricercaPerAnno", query = "select c from Articolo c where c.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "ricercaPerAutore", query = "select c from Articolo c where c.autore = :autore")
@NamedQuery(name = "ricercaPerTitolo", query = "select c from Articolo c where c.titolo LIKE :titolo")

public class Articolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceISBN;
	@Column(nullable = false)
	private String titolo;
	@Column(nullable = false)
	private Integer annoPubblicazione;
	@Column(nullable = false)
	private Integer numeroPagine;
	
	public Articolo() {
		super();
		
	}

	public Articolo(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}

	public Long getCodiceISBN() {
		return codiceISBN;
	}

	public void setCodiceISBN(Long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String toString() {
		return "Articolo [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
	

}
