package com.epicode.esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.esercizio1.TestThread;

public class PrimoThread extends Thread {
	
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	
	private int[] partizione;
	public int sum;

	public PrimoThread(int[] partizione) {
		super();
		this.partizione = partizione;
	}

	@Override
	public void run() {
		
		for(int i = 0; i < 1000; i++) {
			sum += partizione[i];
			
		}
		log.info("La somma dei numeri è: " + sum);
	}
	
	

}
