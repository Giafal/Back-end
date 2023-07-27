package com.epicode.model;

import com.epicode.interfaces.Pizza;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PizzaTopping  implements Pizza {
	
	private Pizza pizza;
	private String name;
	private Double price;
	private Double calories;
	
	
	
	



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
