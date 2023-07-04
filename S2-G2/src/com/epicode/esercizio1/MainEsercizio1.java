package com.epicode.esercizio1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEsercizio1 {
	
	public static Logger log = LoggerFactory.getLogger(MainEsercizio1.class);
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Set<String> elenco = new HashSet<String>();
		List<String> elencoDuplicati = new ArrayList<String>();
		
		System.out.println("Scegli un numero da 1 a 10: ");
		int numero = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < numero; i++) {
			System.out.println("Inserisci una parola: ");
			String parola = sc.nextLine();
			elenco.add(parola);
			if (!elenco.add(parola)) {
				elencoDuplicati.add(parola);
			}
		}
		
		System.out.println("Stampa gli elementi di elenco: ");
		for(String parola : elenco) {
			System.out.println(parola);
		}
		
		System.out.println("Stampa gli elementi di elenco duplicati: ");
		for(String parola : elencoDuplicati) {
			System.out.println(parola);
		}
		
		

	}
	
	
	}


