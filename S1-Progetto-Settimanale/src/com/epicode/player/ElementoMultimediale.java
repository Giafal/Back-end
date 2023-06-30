package com.epicode.player;

abstract public class ElementoMultimediale {
	
	public String titolo;

	public ElementoMultimediale(String titolo) {
		super();
		this.titolo = titolo;
	}

	protected abstract void show();

	protected abstract void play();
	
	

}
