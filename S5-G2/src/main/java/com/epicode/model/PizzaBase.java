package com.epicode.model;

import com.epicode.interfaces.Pizza;

public abstract class PizzaBase implements Pizza {
	
	private final String name;
	private final Double price;
	private final Double calories;
	
	
	public PizzaBase(String name, Double price, Double calories) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
	}


	public String getName() {
		return name;
	}


	public Double getPrice() {
		return price;
	}


	public Double getCalories() {
		return calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

}
