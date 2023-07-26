package com.epicode.model;

import com.epicode.interfaces.Pizza;

public class ToppingCheese extends PizzaTopping {

	public ToppingCheese(Pizza pizza) {
		super(pizza,"Cheese", 0.69, 92d);
	}

}
