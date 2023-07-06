package com.epicode.esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static List<Product> listaProdotti = new ArrayList<Product>();
    static List<Order> listaOrdini = new ArrayList<Order>();
    static List<Product> listaProdotti2 = new ArrayList<Product>();

	public static void main(String[] args) {
		
		
		Product p1 = new Product(001,"Lo Hobbit", "books", 50);
		Product p2 = new Product(002,"Dexter", "books", 150);
		Product p3 = new Product(003, "Bambola", "baby", 25);
		Product p4 = new Product(004, "Ciuccio", "baby", 10);
		Product p5 = new Product(005, "Fumetti", "boys", 50);
		Product p6 = new Product(006, "Sigarette", "boys", 5);
		Product p7 = new Product(007, "Gomme", "boys", 2);
		Product p8 = new Product(8, "Skateboard", "boys", 30);
		Product p9 = new Product(9, "Scarpe", "boys", 100);
		Product p10 = new Product(010, "Maglia", "boys", 50);
		
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		listaProdotti.add(p4);
		listaProdotti.add(p5);
		listaProdotti2.add(p6);
		listaProdotti2.add(p7);
		listaProdotti2.add(p8);
		listaProdotti2.add(p9);
		listaProdotti2.add(p10);
		
		List<Product> lf = filtroBooks(listaProdotti);
		System.out.println(lf);
		
		Customer c1 = new Customer(001, "Gianluca", 2);
		Customer c2 = new Customer(002, "Andrea", 1);
		Customer c3 = new Customer(003, "Luca", 3);
		
		Order o1 = new Order(001, "pending", LocalDate.now(), LocalDate.of(2023,7,8), listaProdotti, c1);
		Order o2 = new Order(002, "pending", LocalDate.now(), LocalDate.of(2023,7,8), listaProdotti2, c2);
		Order o3 =new Order(002, "pending", LocalDate.now(), LocalDate.of(2023,7,8), listaProdotti2, c3);
		
		
		listaOrdini.add(o1);
		listaOrdini.add(o2);
		listaOrdini.add(o3);
		
		List<Product> lf1 = filtroBaby(o1);
		System.out.println(lf1);
		
		List<Order> lf2 = filtroBaby2(listaOrdini);
		System.out.println(lf2);
		
		List<Product> lf3 = filtroBoys(listaProdotti);
		System.out.println(lf3);
		
		
		

	}
	
	public static List<Product> filtroBooks(List<Product> lista) {
		List<Product> listaFiltrata = lista.stream()
				.filter(e -> e.getCategory() == "books")
				.filter(e -> e.getPrice() > 100)
				.collect(Collectors.toList());
		return listaFiltrata;
	}
	
	public static List<Product> filtroBaby(Order lista) {
		List<Product> listaFiltrata = lista.getProducts()
				.stream().filter(e -> e.getCategory() == "baby")
				.collect(Collectors.toList());
		return listaFiltrata;
	}
	
	public static List<Order> filtroBaby2(List<Order> lista) {
		List<Order> listaFiltrata = lista.stream()
		 .filter(e -> e.contieneProdotti("baby"))
		.collect(Collectors.toList());
		return listaFiltrata;
		}
	
	public static List<Product> filtroBoys(List<Product> lista) {
		List<Product> listaFiltrata = lista.stream().filter(e -> e.getCategory() == "boys").map(e -> new Product(e.getId(), e.getName(), e.getCategory(), e.getPrice()*0.9)).collect(Collectors.toList());
		
		return listaFiltrata;
	}
		
	}
	

