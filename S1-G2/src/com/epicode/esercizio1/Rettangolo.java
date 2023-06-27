package com.epicode.esercizio1;

public class Rettangolo {
	
	public int base;
	public int altezza;
	
	public Rettangolo(int base, int altezza) {
		this.base = base;
		this.altezza = altezza;
	}
	
	public int calcolaPerimetro() {
		return base*2 + altezza*2;
	}
	
	public int calcolaArea() {
		return base * altezza;
	}

}
