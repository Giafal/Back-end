package com.epicode.model;

import com.epicode.interfaces.FoodItem;


public class Drink implements FoodItem {
	
	private String name;
	private Double price;
	private Double calories;
	
	

	public Drink(String name, Double price, Double calories) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
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
		return this.name;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;
	}

	@Override
	public Double getCalories() {
		return this.calories;
	}

}
