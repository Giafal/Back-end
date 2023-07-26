package com.epicode.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
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

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MenuRunner implements CommandLineRunner {


	private Menu menu;

    @Autowired
	private ApplicationContext ctx;

	@Value("${S5G2.costocoperto}")
	private Double costoCoperto;

	@Override
	public void run(String... args) throws Exception {

		Tavolo tavolo = new Tavolo(1, 5, true);

		Ordine ordine = creaOrdine(tavolo, 3, costoCoperto);

		valorizzaOrdine(ordine);

		stampaOrdine(ordine);

	}

	private void valorizzaOrdine(Ordine ordine) {

		for (int i = 0; i < 3; i++) {
			Pizza pizza = (Pizza) ctx.getBean(PizzaHawaiian.class);
			ordine.addMenuItem(pizza);
		}

		Pizza pizza = (Pizza) ctx.getBean(PizzaMargherita.class);
		Pizza pizzaTopping1 = (Pizza) ctx.getBean(ToppingCheese.class, pizza);
		pizzaTopping1 = (Pizza) ctx.getBean(ToppingHam.class, pizzaTopping1);
		ordine.addMenuItem(pizzaTopping1);

		pizza = ctx.getBean(PizzaHawaiian.class);

		pizzaTopping1 = ctx.getBean(ToppingCheese.class, pizza);
		pizzaTopping1 = ctx.getBean(ToppingHam.class, pizzaTopping1);
		ordine.addMenuItem(pizzaTopping1);

		pizza = (Pizza) ctx.getBean(PizzaSalami.class);

		Pizza pizzaTopping2 = new ToppingCheese(pizza);
		ordine.addMenuItem(pizzaTopping2);

		Pizza pizzaTopping3 = ctx.getBean(ToppingCheese.class, pizza);
		pizzaTopping3 = ctx.getBean(ToppingHam.class, pizzaTopping3);
		ordine.addMenuItem(pizzaTopping3);

		Drink drink = ctx.getBean(DrinkLemonade.class);
		ordine.addMenuItem(drink);
	}

	public Ordine creaOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto2) {
		Ordine ordine = ctx.getBean(Ordine.class);
		ordine.setTavolo(tavolo);
		ordine.setNumeroCoperti(numeroCoperti);
		ordine.setNumeroOrdine(1);
		ordine.setCostoCoperto(costoCoperto2);
		return ordine;
	}

	public void stampaOrdine(Ordine ordine) {
		log.info("****** ORDINE ******");
		log.info("Numero ordine: {}", ordine.getNumeroOrdine());
		log.info("Numero coperti: {}", ordine.getNumeroCoperti());
		log.info("Numero Tavolo: {}", ordine.getTavolo().getNumero());
		log.info("Stato ordine: {}", ordine.getStato());
		log.info("");
		for (MenuItem item : ordine.getOrdinato().keySet()) {
			log.info("{} - Quantità: {}", item.getName(), ordine.getOrdinato().get(item));
		}
		log.info("");
		log.info("Totale €: {}", ordine.getTotale());
	}
}
