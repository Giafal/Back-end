package com.epicode.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.enumerations.StatoOrdine;
import com.epicode.interfaces.MenuItem;
import com.epicode.interfaces.Pizza;
import com.epicode.model.Drink;
import com.epicode.model.Franchise;
import com.epicode.model.Menu;
import com.epicode.model.Ordine;
import com.epicode.model.PizzaHawaiian;
import com.epicode.model.PizzaMargherita;
import com.epicode.model.PizzaSalami;
import com.epicode.model.PizzaTopping;
import com.epicode.model.Tavolo;

@Service
public class MenuService {
	
	Logger log = LoggerFactory.getLogger(MenuService.class);
	
	@Autowired @Qualifier("menuBean") private ObjectProvider<Menu> menuProvider;
	@Autowired @Qualifier("ordineBean") private ObjectProvider<Ordine> ordineProvider;
	@Autowired @Qualifier("tavoloBean") private ObjectProvider<Tavolo> tavoloProvider;
	@Autowired @Qualifier("margheritaBean") private ObjectProvider<PizzaMargherita> margheritaProvider;
	@Autowired @Qualifier("hawaiianBean") private ObjectProvider<PizzaHawaiian> hawaiianProvider;
	@Autowired @Qualifier("salamiBean") private ObjectProvider<PizzaSalami> salamiProvider;
	@Autowired @Qualifier("drinkLemonadeBean") private ObjectProvider<Drink> lemonadeProvider;
	@Autowired @Qualifier("franchiseMugBean") private ObjectProvider<Franchise> mugProvider;
	@Autowired @Qualifier("toppingCheeseBean") private ObjectProvider<PizzaTopping> cheeseProvider;
	@Autowired @Qualifier("toppingHamBean") private ObjectProvider<PizzaTopping> hamProvider;
	
	
	
	
	
	
	public void stampaMenu() {
		Menu m = menuProvider.getObject();
		System.out.println("***MENU***");
		System.out.println();
		System.out.println("PIZZE:");
		List<Pizza> listaPizze = m.getMenuPizza();
		listaPizze.forEach(p -> System.out.println(p.getMenuItemLine()));
		System.out.println();
		System.out.println("DRINK:");
		List<Drink> listaDrink = m.getMenuDrink();
		listaDrink.forEach(d -> System.out.println(d.getMenuItemLine()));
		System.out.println();
		System.out.println("TOPPING:");
		List<PizzaTopping> listaTopping = m.getMenuTopping();
		listaTopping.forEach(t -> System.out.println(t.getMenuItemLine()));
		System.out.println();
		System.out.println("FRANCHISE:");
		List<Franchise> listaFranchise = m.getMenuFranchise();
		listaFranchise.forEach(f -> System.out.println(f.getMenuItemLine()));
		
	}
	
	public Tavolo creaTavolo(Integer numero, Integer numeroMassimoCoperti, boolean occupato) {
		Tavolo t = tavoloProvider.getObject();
		t.setNumero(numero);
		t.setNumeroMassimoCoperti(numeroMassimoCoperti);
		t.setOccupato(occupato);
		return t;
	}
	
	public Ordine createOrdine(Tavolo tavolo, Integer numeroCoperti, Double costoCoperto) {
		Ordine o = ordineProvider.getObject();
		o.setTavolo(tavolo);
		o.setNumeroCoperti(numeroCoperti);
		o.setCostoCoperto(costoCoperto);
		o.setNumeroOrdine(1);
		o.setStato(StatoOrdine.IN_CORSO);
		return o;
	}
	
	public void valorizzaOrdine(Ordine ordine) {
		Pizza p1 = margheritaProvider.getObject();
		ordine.addMenuItem(p1);
		Pizza p2 = hawaiianProvider.getObject();
		ordine.addMenuItem(p2);
		Pizza p3 = salamiProvider.getObject();
		ordine.addMenuItem(p3);
		Drink d1 = lemonadeProvider.getObject();
		ordine.addMenuItem(d1);
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
