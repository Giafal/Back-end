package com.epicode.esercizio1;

public class Main1 {

	public static void main(String[] args) {
		
		pariDispari("ciao");
		bisestile(2000);
		

	}
	
	public static void pariDispari(String str) {
		if(str.length() % 2 == 0) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
	
	public static void bisestile(int anno) {
		if(anno % 4 == 0 || (anno % 100 == 0 && anno % 400 == 0)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
