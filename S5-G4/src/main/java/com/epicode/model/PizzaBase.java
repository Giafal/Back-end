package com.epicode.model;

import com.epicode.interfaces.Pizza;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public abstract class PizzaBase implements Pizza {
	
	private final String name;
	private final Double price;
	private final Double calories;
	
	
	
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;	
	}

}
