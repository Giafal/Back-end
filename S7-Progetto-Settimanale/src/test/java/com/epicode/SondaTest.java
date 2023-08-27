package com.epicode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.epicode.model.CentroDiControllo;
import com.epicode.model.Sonda;

class SondaTest {

	@Test
	void testLatitude() {
       Sonda s = new Sonda();
       s.setLatitude(50.00);
       
       assertEquals(s.getLatitude(), 50.00);
	}
    
	
	@Test
	void testLongitude() {
       Sonda s = new Sonda();
       s.setLongitude(60.00);
       
       assertEquals(s.getLongitude(), 60.00);
	}
	
	@Test
	void testSmokeLevel() {
		Sonda s = new Sonda();
		s.setSmokeLevel(5);
		
		assertEquals(s.getSmokeLevel(), 5);
	}
	
	@Test
	void testCdc() {
		Sonda s = new Sonda();
		CentroDiControllo c = new CentroDiControllo();
		s.setListener(c);
		
		assertEquals(s.getListener().getId(), c.getId());
	}
}
