package com.epicode.configBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfigurationMenu {
	
	@Bean
	@Scope("prototype")
	public Pizza pizza(String nome, Integer kcal, double prezzo) {
		return new Pizza(nome, kcal, prezzo);
	}
	
	@Bean
	@Scope("prototype")
	public Bevanda bevanda(String nome, Integer kcal, double prezzo) {
		return new Bevanda(nome, kcal, prezzo);
	}
	
	@Bean
	@Scope("prototype")
	public Topping topping(String nome, double prezzo) {
		return new Topping(nome, prezzo);
	}
	
	@Bean
	@Scope("prototype")
	public Franchise franchise(String nome, double prezzo) {
		return new Franchise(nome, prezzo);
	}

}
