package com.epicode.esercizio2;

public class Chiamata {
	
	public double durata;
	public Sim numeroChiamato;
	public Sim x;
	public static int chiamata = 0;
	
	public Chiamata(Sim x, double durata, Sim numeroChiamato) {
		this.x = x;
		this.durata = durata;
		this.numeroChiamato = numeroChiamato;
		chiamata++;
	}

}
