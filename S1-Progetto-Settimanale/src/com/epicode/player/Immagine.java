package com.epicode.player;

public class Immagine extends ElementoMultimediale implements Luminosita {
	

	public int luminosita;
	
	public Immagine(String titolo, int luminosita) {
		super(titolo);
		this.luminosita = luminosita;
	}
	
	@Override
	public int aumentaLuminosita() {
		return this.luminosita++;
	}
	
	@Override
	public int diminuisciLuminosita() {
		return this.luminosita--;
	}
	
	public void show() {
		System.out.print(titolo);
		for(int i = 0; i < luminosita; i++) {
			System.out.print("*");
		}
		System.out.println();
		
	}

	@Override
	protected void play() {}
	

}
