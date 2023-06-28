package com.epicode.esercizio3;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		esercizio();
		

	}
	
	public static void esercizio() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("Inserisci una stringa: ");
			String testo = sc.nextLine();
			if (testo.equals(":q")) {
				break;
			}
			String [] testoSplittato = testo.split("");
			for (int i = 0; i < testoSplittato.length; i++) {
				System.out.print(testoSplittato[i] + ",");
			}
			System.out.println();
		}
		System.out.println("FINE CICLO");
	}

}
