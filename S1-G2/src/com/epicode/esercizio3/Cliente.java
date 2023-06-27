package com.epicode.esercizio3;

import java.util.Date;

public class Cliente {
	
	public int codiceCliente;
	public String nome;
	public String cognome;
	public String email;
	public Date dataIscrizione;
	
	public Cliente(int codiceCliente, String nome, String cognome, String email, Date dataIscrizione) {
		this.codiceCliente = codiceCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataIscrizione = dataIscrizione;
	}

}
