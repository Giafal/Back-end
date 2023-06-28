package com.epicode.esercizio2;

public class Main2 {

	public static void main(String[] args) {
		
		print(4);
		

	}
	
	public static void print(int numero) {
		switch(numero) {
		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("due");
		    break;
		case 3:
			System.out.println("tre");
			break;
		default:
			System.out.println("Numero non valido");
		}
		
		
	}

}
