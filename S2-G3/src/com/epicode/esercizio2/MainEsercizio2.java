package com.epicode.esercizio2;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.esercizio1.MainEsercizio1;

public class MainEsercizio2 {
	
	public static Logger log = LoggerFactory.getLogger(MainEsercizio1.class);
	public static Random rand = new Random();

	public static void main(String[] args) {
		
		int[] array = new int[3000];
		
		
		for(int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(101);
			
		}
		
		PrimoThread t1 = new PrimoThread(array);
		SecondoThread t2 = new SecondoThread(array);
		TerzoThread t3 = new TerzoThread(array);
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		
		System.out.println(t1.sum + t2.sum + t3.sum);
		
		

	}

}
