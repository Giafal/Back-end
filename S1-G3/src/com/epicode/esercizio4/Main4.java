package com.epicode.esercizio4;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		
		countdown();
		

	}
	
	public static void countdown() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		int numero = sc.nextInt();
		for(int i = numero; i >= 0; i--) {
			System.out.println(i);
		}
	}

}
