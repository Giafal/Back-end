package com.epicode.esercizio2;

public class Sim {
	public int numero;
	public double credito = 0;
	public int chiamate = 0;
	public Chiamata[] ultimeChiamate = new Chiamata[5];
	
	
	public Sim(int numero) {
		this.numero = numero;
		
	}
	
	public void mostraSim() {
		System.out.println("Il tuo numero è:" + this.numero);
		System.out.println("Il tuo credito è:" + this.credito);
		System.out.println("Hai effettuato" + " " + this.chiamate + " " + "chiamate");
		
	}
	
	

}
