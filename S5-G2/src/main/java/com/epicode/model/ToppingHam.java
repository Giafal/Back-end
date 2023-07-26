package com.epicode.model;

import com.epicode.interfaces.Pizza;

public class ToppingHam extends PizzaTopping {

	public ToppingHam(Pizza pizza) {
		super(pizza,"Ham", 0.99, 35d);
	}

}
