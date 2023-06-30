package com.epicode.player;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			ElementoMultimediale[] arr = new ElementoMultimediale[5];
			
			System.out.println("Crea un'immagine");
			System.out.println("Inserisci un titolo: ");
			String titolo0 = sc.next();
			System.out.println("Scegli la luminosita da 1 a 5: ");
			int luminosita0 = sc.nextInt();
			arr[0] = new Immagine(titolo0, luminosita0);
			System.out.println("Crea un'altra immagine");
			System.out.println("Inserisci un titolo: ");
			String titolo1 = sc.next();
			System.out.println("Scegli la luminosita da 1 a 5: ");
			int luminosita1 = sc.nextInt();
			arr[1] = new Immagine(titolo1, luminosita1);
			System.out.println("Crea un file audio");
			System.out.println("Inserisci un titolo: ");
			String titolo2 = sc.next();
			System.out.println("Scegli la durata: ");
			int durata2 = sc.nextInt();
			System.out.println("Scegli il volume da 1 a 5: ");
			int volume2 = sc.nextInt();
			arr[2] = new Audio(titolo2, durata2, volume2);
			System.out.println("Crea un altro file audio");
			System.out.println("Inserisci un titolo: ");
			String titolo3 = sc.next();
			System.out.println("Scegli la durata: ");
			int durata3 = sc.nextInt();
			System.out.println("Scegli il volume da 1 a 5: ");
			int volume3 = sc.nextInt();
			arr[3] = new Audio(titolo3, durata3, volume3);
			System.out.println("Crea un file video");
			System.out.println("Inserisci un titolo: ");
			String titolo4 = sc.next();
			System.out.println("Scegli la durata: ");
			int durata4 = sc.nextInt();
			System.out.println("Scegli il volume da 1 a 5: ");
			int volume4 = sc.nextInt();
			System.out.println("Scegli la luminosita da 1 a 5: ");
			int luminosita4 = sc.nextInt();
			arr[4] = new Video(titolo4, durata4, volume4, luminosita4);
			
			int scelta = -1;
			while(scelta != 0) {
				System.out.println("Scegli quale elemento eseguire digitando un numero da 1 a 5, digita 0 per uscire");
				scelta = sc.nextInt();
				
				switch(scelta) {
				case 0:
					System.out.println("Uscita...");
					break;
				case 1:
					arr[0].show();
					break;
				case 2:
					arr[1].show();
					break;
				case 3:
					arr[2].play();
					break;
				case 4:
					arr[3].play();
					break;
				case 5:
					arr[4].play();
				    break;
				default:
					System.out.println("Errore, numero non valido!!!");
				}
			}
		}
		
		
		
		
		
		
		

	}

}
