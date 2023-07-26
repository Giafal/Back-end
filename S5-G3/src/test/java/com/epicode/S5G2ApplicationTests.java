package com.epicode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.interfaces.Pizza;
import com.epicode.model.Ordine;
import com.epicode.model.PizzaHawaiian;
import com.epicode.model.PizzaMargherita;
import com.epicode.model.Tavolo;

@SpringBootTest
class S5G2ApplicationTests {

	private Ordine testOrdine;

	@BeforeEach
	public void setUp() {
		Tavolo tavolo = new Tavolo(1, 5, true);

		testOrdine = new Ordine();
		testOrdine.setTavolo(tavolo);
		testOrdine.setNumeroCoperti(4);
		testOrdine.setNumeroOrdine(1);
		testOrdine.setCostoCoperto(1d);

	}

	@Test
	void testAddOneItem() {

		PizzaHawaiian pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().size(), 1);

	}

	

	private void assertEquals(int size, int i) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void testAddTwoItemSameType() {

		PizzaHawaiian pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);

		pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().size(), 1);
		assertEquals(testOrdine.getOrdinato().get(pizza1), 2);

	}

	@Test
	void testAddTwoItemDifferentType() {

		PizzaHawaiian pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);

		Pizza pizza2 = new PizzaMargherita();
		testOrdine.addMenuItem(pizza2);
		assertEquals(testOrdine.getOrdinato().size(), 2);
		assertEquals(testOrdine.getOrdinato().get(pizza1), 1);
		assertEquals(testOrdine.getOrdinato().get(pizza2), 1);

	}

	@Test
	void testRemoveItem() {

		PizzaHawaiian pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);

		pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().get(pizza1), 2);

		testOrdine.removeMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().size(), 1);

	}

	@Test
	void testRemoveLastItem() {

		PizzaHawaiian pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);

		pizza1 = new PizzaHawaiian();
		testOrdine.addMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().get(pizza1), 2);

		testOrdine.removeMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().size(), 1);

		testOrdine.removeMenuItem(pizza1);
		assertEquals(testOrdine.getOrdinato().size(), 0);

	}
}
