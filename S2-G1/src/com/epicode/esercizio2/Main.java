package com.epicode.esercizio2;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Logger log = LoggerFactory.getLogger(Main.class);
		
		try { System.out.println("Inserisci i km percorsi: ");
		int km = sc.nextInt();
		System.out.println("Inserisci i litri di benzina consumati: ");
		int litri = sc.nextInt();
		
		int consumi = km / litri;
		System.out.println("Il consumo della tua macchina è di " + consumi + "km per litro.");
		} catch (ArithmeticException e) {
			log.error("Errore, non si può dividere per 0!!!");
		}
	

	}

}
