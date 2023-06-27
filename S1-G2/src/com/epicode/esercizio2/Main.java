package com.epicode.esercizio2;

public class Main {

	public static void main(String[] args) {
		
		Sim t1 = new Sim(389794152);
		Sim t2 = new Sim(379299146);
		
		t1.mostraSim();
		
		Chiamata uno = new Chiamata(t1, 1.5, t2);
		Chiamata due = new Chiamata(t1, 2.0, t2);
		Chiamata tre = new Chiamata(t1, 2.5, t2);
		Chiamata quattro = new Chiamata(t1, 1.7, t2);
		Chiamata cinque = new Chiamata(t1, 2.3, t2);
		
		t1.ultimeChiamate[0] = uno;
		t1.ultimeChiamate[1] = due;
		t1.ultimeChiamate[2] = tre;
		t1.ultimeChiamate[3] = quattro;
		t1.ultimeChiamate[4] = cinque;
		
		

	}

}
