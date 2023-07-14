package com.epicode.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.epicode.enumerations.Sesso;

@Entity
@Table(name = "persone")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataDiNascita;
	private Sesso sesso;
	private List<Partecipazione> listaPartecipazioni;
	
	public Persona() {
		super();
		
	}

	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			List<Partecipazione> listaPartecipazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}

	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", dataDiNascita="
				+ dataDiNascita + ", sesso=" + sesso + ", listaPartecipazioni=" + listaPartecipazioni + "]";
	}
	
	
	
	
	

}
