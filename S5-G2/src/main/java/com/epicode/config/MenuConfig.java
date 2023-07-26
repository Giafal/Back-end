package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.interfaces.Pizza;
import com.epicode.model.Drink;
import com.epicode.model.DrinkLemonade;
import com.epicode.model.Franchise;
import com.epicode.model.FranchiseMug;
import com.epicode.model.Menu;
import com.epicode.model.Ordine;
import com.epicode.model.PizzaHawaiian;
import com.epicode.model.PizzaMargherita;
import com.epicode.model.PizzaSalami;
import com.epicode.model.PizzaTopping;
import com.epicode.model.Tavolo;
import com.epicode.model.ToppingCheese;
import com.epicode.model.ToppingHam;

@Configuration
public class MenuConfig {

	@Bean
	@Scope("singleton")
	public Menu menu() {

		Menu menu = new Menu();

		menu.getMenuPizza().add(pizzaMargherita());
		menu.getMenuPizza().add(pizzaHawaiian());
		menu.getMenuPizza().add(pizzaSalami());
		menu.getMenuTopping().add(toppingCheese(null));
		menu.getMenuTopping().add(toppingHam(null));
		menu.getMenuDrink().add(drinkLemonade());
		return menu;
	}

	@Bean
	@Scope("prototype")
	public PizzaMargherita pizzaMargherita() {
		return new PizzaMargherita();
	}

	@Bean
	@Scope("prototype")
	public Ordine ordine() {
		return new Ordine();
	}
	
	
	@Bean
	@Scope("application")
	public Ordine tavolo() {
		return new Ordine();
	}

	@Bean
	@Scope("prototype")
	public Tavolo tavoloConstructor(Integer numero, Integer numeroMassimoCoperti, Boolean occupato) {
		return new Tavolo(numero, numeroMassimoCoperti, occupato);
	}

	@Bean
	@Scope("prototype")
	public PizzaHawaiian pizzaHawaiian() {
		return new PizzaHawaiian();
	}

	@Bean
	@Scope("prototype")
	public PizzaSalami pizzaSalami() {
		return new PizzaSalami();
	}

	@Bean
	@Scope("prototype")
	public Drink drinkLemonade() {
		return new DrinkLemonade();
	}

	@Bean
	@Scope("prototype")
	public Franchise franchiseMug() {
		return new FranchiseMug();
	}

	@Bean
	@Scope("prototype")
	public PizzaTopping toppingCheese(Pizza pizza) {
		return new ToppingCheese(pizza);
	}

	@Bean
	@Scope("prototype")
	public PizzaTopping toppingHam(Pizza pizza) {
		return new ToppingHam(pizza);
	}
}
