package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

import com.epicode.interfaces.Pizza;

import lombok.Getter;

@Getter
public class Menu {
	
	private final List<Pizza> menuPizza = new ArrayList<>();
	private final List<PizzaTopping> menuTopping = new ArrayList<>();
	private final List<Drink> menuDrink = new ArrayList<>();
	private final List<Franchise> menuFranchise = new ArrayList<>();
	
	
	
	
	

}
