package com.epicode.model;

import com.epicode.interfaces.FoodItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Drink implements FoodItem {
	
	private String name;
	private Double price;
	private Double calories;
	
	

	
	@Override
	public String getMenuItemLine() {
		return this.name + " - calories: " + calories + " - price: " + price;
	}

	

}
