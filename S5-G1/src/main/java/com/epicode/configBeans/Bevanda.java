package com.epicode.configBeans;

public class Bevanda {
	
	private String nome;
	private Integer kcal;
	private double prezzo;
	
	
	public Bevanda() {
		super();
	}


	public Bevanda(String nome, Integer kcal, double prezzo) {
		super();
		this.nome = nome;
		this.kcal = kcal;
		this.prezzo = prezzo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getKcal() {
		return kcal;
	}


	public void setKcal(Integer kcal) {
		this.kcal = kcal;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	@Override
	public String toString() {
		return "Bevanda [nome=" + nome + ", kcal=" + kcal + ", prezzo=" + prezzo + "]";
	}
	
	

}
