package com.epicode.player;

public class Audio extends ElementoMultimediale implements Volume{
	
	public int durata;
	public int volume;

	public Audio(String titolo, int durata, int volume) {
		super(titolo);
		this.durata = durata;
		this.volume = volume;	
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
	public void play() {
		for(int i = 0; i < durata; i++) {
			System.out.print(titolo);
			for(int j = 0; j< volume; j++) {
				System.out.print("!");
			}
			System.out.println();
		}
	}

	@Override
	protected void show() {}
	

	
   
}
