package com.epicode.esercizio1;

public class MainEsercizio1 {

	public static void main(String[] args) {
		
		TestThread t1 = new TestThread("*");
		TestThread t2 = new TestThread("#");
		
		t1.start();
		t2.start();

	}

}
