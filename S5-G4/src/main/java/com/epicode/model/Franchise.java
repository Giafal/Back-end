package com.epicode.model;

import com.epicode.interfaces.MenuItem;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Franchise implements MenuItem{
	
	private String name;
	private Double price;
	
	
	
	public String getMenuItemLine() {
		return this.name + " - price: " + price;	
	}
	

}
