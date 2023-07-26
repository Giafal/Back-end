package com.epicode.model;

import com.epicode.interfaces.Pizza;

public class PizzaTopping implements Pizza {
	
	private Pizza pizza;
	private String name;
	private Double price;
	private Double calories;
	
	
	
	public PizzaTopping(Pizza pizza, String name, Double price, Double calories) {
		super();
		this.pizza = pizza;
		this.name = name;
		this.price = price;
		this.calories = calories;
	}
	
	

	public Pizza getPizza() {
		return pizza;
	}



	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public void setCalories(Double calories) {
		this.calories = calories;
	}



	@Override
	public String getName() {
		return this.pizza.getName() + " + " + this.name;
	}

	@Override
	public Double getPrice() {
		return this.pizza.getPrice() + this.price;
	}

	@Override
	public Double getCalories() {
		return this.pizza.getCalories() + this.calories;
	}
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

}
