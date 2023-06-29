package com.epicode.esercizio;

public class Dipendenti {
	
	public static double stipendioBase = 1000;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	
	public Dipendenti(int matricola, Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}


	public Dipendenti(int matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}


	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}


	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}


	public Dipartimento getDipartimento() {
		return dipartimento;
	}


	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}


	public static double getStipendioBase() {
		return stipendioBase;
	}


	public int getMatricola() {
		return matricola;
	}


	public double getStipendio() {
		return stipendio;
	}


	public Livello getLivello() {
		return livello;
	}
	
	public void stampaDatiDipendente(Dipendenti x) {
		System.out.println("Stipendio base: " + Dipendenti.stipendioBase + " " +
				"Matricola: " + x.matricola + " " +
				"Stipendio: " + x.stipendio + " " +
				"Straordinari: " + x.importoOrarioStraordinario + " " +
				"Livello: " + x.livello + " " +
				"Dipartimento: " + x.dipartimento );
	}
	
	public static void promuovi(Dipendenti x) {
		switch(x.livello) {
		case OPERAIO:
			x.livello = Livello.IMPIEGATO;
			x.stipendio = stipendioBase * 1.2;
			break;
		case IMPIEGATO:
			x.livello = Livello.QUADRO;
			x.stipendio = stipendioBase * 1.5;
			break;
		case QUADRO:
			x.livello = Livello.DIRIGENTE;
			x.stipendio = stipendioBase * 2;
			break;
		default:
			System.out.println("Non puoi essere promosso");
		}
		System.out.println("Il dipendente è stato promosso a " + x.livello);
	}
	
	public static double calcolaPaga(Dipendenti x) {
		return x.stipendio;
	}
	
	public double calcolaPaga(Dipendenti x, int n) {
		return x.stipendio + (this.importoOrarioStraordinario*n);
	}
	
	
	

}
