package com.epicode.player;

public class Video extends ElementoMultimediale implements Volume, Luminosita{
	
	
	public int durata;
	public int volume;
	public int luminosita;
	
	
	public Video(String titolo, int durata, int volume, int luminosita) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;
		this.luminosita = luminosita;
	}
	
	@Override
	public int alzaVolume() {
		return this.volume++;
	}
	
	@Override
	public int abbassaVolume() {
		return this.volume--;
	}
	
	@Override
	public int aumentaLuminosita() {
		return this.luminosita++;
	}
	
	@Override
	public int diminuisciLuminosita() {
		return this.luminosita--;
	}
	
	public void play() {
		for(int i = 0; i < durata; i++) {
			System.out.print(titolo);
			for(int j = 0; j< volume; j++) {
				System.out.print("!");	
			}
			for(int k = 0; k < luminosita; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Override
	protected void show() {}

}
