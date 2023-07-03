package com.epicode.esercizio;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(Main.class);
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
//		log.info("Info log");
//		log.debug("Debug log");
//		log.error("Error log");
//		log.warn("Warning log");
		
		int[] arr = new int[5];
		
		System.out.println("Ecco un array di 5 numeri interi compresi fra 1 e 10:");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10) + 1;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		int posizione;
		int valore;
		do {
			try {System.out.println("Scegli un valore: ");
			valore = sc.nextInt();
			if (valore == 0) {
				break;
			} else if (valore >0 && valore < 10) {
				System.out.println("Scegli una posizione: ");
				posizione = sc.nextInt();
				arr[posizione] = valore;
				for(int i = 0; i < arr.length; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			} else {
				log.error("Errore, numero non valido!!!");
			}
			} catch (ArrayIndexOutOfBoundsException e) {
				log.error("Errore, posizione dell'array non valida!!!");
			}
		} while (true);
		
		
		
		

	}

}
