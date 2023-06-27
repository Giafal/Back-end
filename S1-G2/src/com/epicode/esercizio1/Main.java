package com.epicode.esercizio1;

public class Main {

	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo(5, 10);
		//stem.out.println(r1.calcolaPerimetro());
		//stem.out.println(r1.calcolaArea());
		stampaRettangolo(r1);
		Rettangolo r2 = new Rettangolo(3, 5);
		stampaDueRettangoli(r1, r2);

	}
	
	public static void stampaRettangolo(Rettangolo x) {
		System.out.println("Perimetro:" + x.calcolaPerimetro());
		System.out.println("Area:" + x.calcolaArea());
	}
	
	public static void stampaDueRettangoli(Rettangolo x, Rettangolo y) {
		int sommaPerimetri = x.calcolaPerimetro() + y.calcolaPerimetro();
		int sommaAree = x.calcolaArea() + y.calcolaArea();
		System.out.println("Perimetro 1:" + x.calcolaPerimetro());
		System.out.println("Perimetro 2:" + y.calcolaPerimetro());
		System.out.println("Area 1:" + x.calcolaArea());
		System.out.println("Area 2:" + y.calcolaArea());
		System.out.println("Somma perimetri:" + sommaPerimetri);
		System.out.println("Somma aree:" + sommaAree);
	}

}
