package com.epicode.esercizio3;

public class Carrello {
	public Cliente clienteAssociato;
	public Articolo[] elencoArticoli;
	public int totaleCosto;
	
	public Carrello(Cliente clienteAssociato, Articolo[] elencoArticoli, int totaleCosto) {
		this.clienteAssociato = clienteAssociato;
		this.elencoArticoli = elencoArticoli;
		this.totaleCosto = totaleCosto;
	}

}
