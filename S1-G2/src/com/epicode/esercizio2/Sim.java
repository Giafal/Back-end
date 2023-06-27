package com.epicode.esercizio2;

public class Sim {
	public int numero;
	public double credito;
	public int chiamate = 0;
	public Chiamata[] ultimeChiamate;
	
	
	public Sim(int numero) {
		this.numero = numero;
		this.credito = 0;
		this.ultimeChiamate = new Chiamata[5];
		
		
	}
	
	public void mostraSim() {
		System.out.println("Il tuo numero è:" + this.numero);
		System.out.println("Il tuo credito è:" + this.credito);
		System.out.println("Lista ultime 5 chiamate:");
		for (int i = 0; i < ultimeChiamate.length; i++){
			if(ultimeChiamate[i] != null) {
				System.out.println(ultimeChiamate[i].numeroChiamato);
			}
		}
		
	}
	
	

}
