package com.epicode.configBeans;

public class Topping {
	
	private String nome;
	private double prezzo;
	
	
	public Topping() {
		super();
	}


	public Topping(String nome, double prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Topping [nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	
	

}
