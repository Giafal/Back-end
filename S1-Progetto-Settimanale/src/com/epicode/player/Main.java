package com.epicode.player;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			ElementoMultimediale[] arr = new ElementoMultimediale[5];
			
			for(int i = 0; i < arr.length; i++) {
				System.out.println("Che tipo di elemento multimediale vuoi creare?");
				System.out.println("Per creare un'immagine digita 1");
				System.out.println("Per creare un audio digita 2");
				System.out.println("Per creare un video digita 3");
				int selezione = sc.nextInt();
				
				switch(selezione) {
				case 1:
					System.out.println("Crea un'immagine");
					System.out.println("Inserisci un titolo: ");
					String titolo0 = sc.next();
					System.out.println("Scegli la luminosita da 1 a 5: ");
					int luminosita0 = sc.nextInt();
					arr[i] = new Immagine(titolo0, luminosita0);
					break;
				case 2:
					System.out.println("Crea un file audio");
					System.out.println("Inserisci un titolo: ");
					String titolo2 = sc.next();
					System.out.println("Scegli la durata: ");
					int durata2 = sc.nextInt();
					System.out.println("Scegli il volume da 1 a 5: ");
					int volume2 = sc.nextInt();
					arr[i] = new Audio(titolo2, durata2, volume2);
					break;
				case 3:
					System.out.println("Crea un file video");
					System.out.println("Inserisci un titolo: ");
					String titolo4 = sc.next();
					System.out.println("Scegli la durata: ");
					int durata4 = sc.nextInt();
					System.out.println("Scegli il volume da 1 a 5: ");
					int volume4 = sc.nextInt();
					System.out.println("Scegli la luminosita da 1 a 5: ");
					int luminosita4 = sc.nextInt();
					arr[i] = new Video(titolo4, durata4, volume4, luminosita4);
					break;
				default:
					System.out.println("Errore, numero non valido!!!");
				}
			}			
			
			
			int scelta = -1;
			while(scelta != 0) {
				System.out.println("Scegli quale elemento eseguire digitando un numero da 1 a 5, digita 0 per uscire");
				scelta = sc.nextInt();
				
				switch(scelta) {
				case 0:
					System.out.println("Uscita...");
					break;
				case 1:
					if(arr[0] instanceof Immagine) {
						arr[0].show();
					} else {
						arr[0].play();
					}
					break;
				case 2:
					if(arr[1] instanceof Immagine) {
						arr[1].show();
					} else {
						arr[1].play();
					}
					break;
				case 3:
					if(arr[2] instanceof Immagine) {
						arr[2].show();
					} else {
						arr[2].play();
					} 
					break;
				case 4:
					if(arr[3] instanceof Immagine) {
						arr[3].show();
					} else {
						arr[3].play();
					}
					break;
				case 5:
					if(arr[4] instanceof Immagine) {
						arr[4].show();
					} else {
						arr[4].play();
					}
				    break;
				default:
					System.out.println("Errore, numero non valido!!!");
				}
			}
		}
		
		
		
		
		
		
		

	}

}
