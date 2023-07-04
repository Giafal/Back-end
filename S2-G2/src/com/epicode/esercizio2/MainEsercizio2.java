package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.esercizio1.MainEsercizio1;

public class MainEsercizio2 {
	
	public static Logger log = LoggerFactory.getLogger(MainEsercizio1.class);
	public static Scanner sc = new Scanner(System.in);
	public static Random rand = new Random();

	public static void main(String[] args) {
		creaLista(5);
		invertiLista(creaLista(5));
		pariDispari(creaLista(5), false);

	}
	
	public static List<Integer> creaLista(int n) {
		List<Integer> lista = new ArrayList<Integer>();
	     for(int i = 0; i < n; i++) {
	    	 lista.add(rand.nextInt(101));
	     }
	     
	     Object[] arr = lista.toArray();
			for(int i=0; i< arr.length; i++) {
				log.info("Elemento: " + lista.get(i));
			}
			return lista;
	}
	
	public static void invertiLista(List<Integer> lista) {
		Collections.reverse(lista);
		Object[] arr = lista.toArray();
		for(int i=0; i< arr.length; i++) {
			log.info("Elemento: " + lista.get(i));
		}
		
	}
	
	public static void pariDispari(List<Integer> lista, boolean b) {
		for(int i = 0; i< lista.size(); i++) {
			if(b == true && lista.get(i)%2 == 0) {
				System.out.println(lista.get(i));
			} else if (b==false && lista.get(i)%2 != 0) {
				System.out.println(lista.get(i));
			}
		}
		
	}


}  
