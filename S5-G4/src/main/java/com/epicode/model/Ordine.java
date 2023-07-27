package com.epicode.model;

import java.util.HashMap;
import java.util.Map;

import com.epicode.enumerations.StatoOrdine;
import com.epicode.interfaces.MenuItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ordine {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroOrdine;
	@OneToOne
	private Tavolo tavolo;
//	@ManyToMany
//	private final Map<MenuItemClass, Integer> ordinato = new HashMap<MenuItemClass, Integer>();
	private StatoOrdine stato = StatoOrdine.IN_CORSO;
	private Integer numeroCoperti = 1;
	private Double costoCoperto;

//	public Integer addMenuItem(MenuItemClass item) {
//		if (!ordinato.containsKey(item)) {
//			ordinato.put(item, 1);
//		} else {
//			ordinato.put(item, ordinato.get(item) + 1);
//		}
//
//		return ordinato.get(item);
//	}
//
//	public Integer removeMenuItem(MenuItemClass item) {
//		if (ordinato.containsKey(item)) {
//			int currentNumber = ordinato.get(item);
//			if (currentNumber == 1) {
//				ordinato.remove(item);
//				return 0;
//			} else {
//				ordinato.put(item, ordinato.get(item) - 1);
//				return ordinato.get(item);
//			}
//		} else
//			return 0;
//	}
//
//	public Double getTotale() {
//		Double totale = 0d;
//		for (MenuItemClass item : ordinato.keySet()) {
//			totale += (item.getPrice() * ordinato.get(item));
//		}
//		totale += numeroCoperti * getCostoCoperto();
//		return totale;
//	}

}
