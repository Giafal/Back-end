package com.epicode.model;

import com.epicode.interfaces.MenuItem;

public class Franchise implements MenuItem{
	
	private String name;
	private Double price;
	
	
	
	public Franchise(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getMenuItemLine() {
		return this.name + " - price: " + price;	
	}
	

}
