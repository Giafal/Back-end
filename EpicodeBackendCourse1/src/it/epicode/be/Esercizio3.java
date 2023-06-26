package it.epicode.be;

import java.util.Scanner;

public class Esercizio3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci il tuo nome:");
		String nome = sc.nextLine();
		System.out.print("Inserisci il tuo cognome:");
		String cognome = sc.nextLine();
		System.out.print("Inserisci la tua età:");
		int eta = sc.nextInt();
		System.out.println("Mi chiamo " + nome + "" + cognome + ", ho " + eta + " anni.");

	}

}
