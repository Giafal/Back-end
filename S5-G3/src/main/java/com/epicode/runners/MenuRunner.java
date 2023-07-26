package com.epicode.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.epicode.interfaces.MenuItem;
import com.epicode.interfaces.Pizza;
import com.epicode.model.Drink;
import com.epicode.model.DrinkLemonade;
import com.epicode.model.Menu;
import com.epicode.model.Ordine;
import com.epicode.model.PizzaHawaiian;
import com.epicode.model.PizzaMargherita;
import com.epicode.model.PizzaSalami;
import com.epicode.model.Tavolo;
import com.epicode.model.ToppingCheese;
import com.epicode.model.ToppingHam;
import com.epicode.services.MenuService;

import lombok.extern.slf4j.Slf4j;

@Component
@PropertySource("classpath:application.properties")
public class MenuRunner implements CommandLineRunner {


	@Autowired private MenuService ms;

	@Value("${S5G2.costocoperto}")
	private Double costoCoperto;

	@Override
	public void run(String... args) throws Exception {
		
		Tavolo tavolo = ms.creaTavolo(1, 5, true);
		
		Ordine ordine = ms.createOrdine(tavolo, 3, costoCoperto);
		
		ms.valorizzaOrdine(ordine);
		
		ms.stampaOrdine(ordine);
		
		


	}

	
}
