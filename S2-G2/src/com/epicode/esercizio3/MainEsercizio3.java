package com.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainEsercizio3 {
	
	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args) {
		
		aggiungiContatto("Gianluca", "3792991466");
		aggiungiContatto("Alberto", "3897941528");
		aggiungiContatto("Marco", "3475642103");
		stampaContatti();
		rimuoviContatto("Marco");
		stampaContatti();
		String nome = ricercaPerNumero("3792991466");
		System.out.println(nome);
		String numero = ricercaPerNome("Gianluca");
		System.out.println(numero);
		

	}
	
	public static void aggiungiContatto(String nome, String telefono) {
		rubrica.put(nome, telefono);
		System.out.println("Contatto aggiunto in rubrica!!!");
	}
	
	public static void rimuoviContatto(String nome) {
		rubrica.remove(nome);
		System.out.println("Contatto rimosso dalla rubrica!!!");
	}
	
	public static String ricercaPerNumero(String numero) {
		Set<String> key = rubrica.keySet();
		for(String k : key) {
			if(numero.equals(rubrica.get(k))) {
				return k;
			}
		}
		return null;
	}
	
	public static String ricercaPerNome(String nome) {
		return rubrica.get(nome);
	}
	
	public static void stampaContatti() {
		System.out.println("****Contatti****");
		Set<String> key = rubrica.keySet();
		for(String k : key) {
			System.out.println("Nome contatto: " + k + " Numero contatto: " + rubrica.get(k));
		}
	}

}
