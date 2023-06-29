package com.epicode.esercizio;

public class GestioneDipendenti {

	public static void main(String[] args) {
		
		Dipendenti d1 = new Dipendenti(1, 1000, 10, Livello.OPERAIO, Dipartimento.PRODUZIONE );
		Dipendenti d2 = new Dipendenti(2, 1000, 10, Livello.OPERAIO, Dipartimento.PRODUZIONE );
		Dipendenti d3 = new Dipendenti(3, 1200, 10, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendenti d4 = new Dipendenti(4, 2000, 10, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		Dipendenti.promuovi(d1);
		Dipendenti.promuovi(d3);
		
		d1.stampaDatiDipendente(d1);
		d2.stampaDatiDipendente(d2);
		d3.stampaDatiDipendente(d3);
		d4.stampaDatiDipendente(d4);
		
		double d1paga = d1.calcolaPaga(d1, 5);
		double d2paga = d2.calcolaPaga(d2, 5);
		double d3paga = d3.calcolaPaga(d3, 5);
		double d4paga = d4.calcolaPaga(d4, 5);
		System.out.println("Somma di tutti gli stipendi:");
		System.out.println(d1paga + d2paga + d3paga + d4paga);
		

	}

}
