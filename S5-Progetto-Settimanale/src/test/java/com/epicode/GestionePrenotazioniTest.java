package com.epicode;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epicode.enumerations.TipoPostazione;
import com.epicode.model.Edificio;
import com.epicode.model.Postazione;
import com.epicode.model.Prenotazione;
import com.epicode.model.Utente;

class GestionePrenotazioniTest {
	
	private Prenotazione testPrenotazione;

	@BeforeEach
	void setUp() throws Exception {
		Edificio edificio = new Edificio("Palazzo Verdi", "Via Verdi", "Andria");
		Postazione postazione = new Postazione("Scrivania singola", TipoPostazione.PRIVATO, 1, edificio, true);
		Utente utente = new Utente("Giafal", "Gianluca Falcone", "gianluca.falcone@yahoo.it");
		testPrenotazione = new Prenotazione();
		testPrenotazione.setUtente(utente);
		testPrenotazione.setPostazione(postazione);
		testPrenotazione.setDataPrenotazione(LocalDate.now());
	}
	
	@Test
	void testUtente() {
		assertEquals(testPrenotazione.getUtente().getUsername(), "Giafal");
	}
	
	@Test
	void testPostazione() {
		assertEquals(testPrenotazione.getPostazione().getNumeroMassimoOccupanti(), 1);
	}

	@Test
	void changeUtente() {
		Utente utente1 = new Utente();
		testPrenotazione.setUtente(utente1);
		assertEquals(testPrenotazione.getUtente(), utente1);
	}
	
	@Test
	void changePostazione() {
		Postazione postazione1 = new Postazione();
		testPrenotazione.setPostazione(postazione1);
		assertEquals(testPrenotazione.getPostazione(), postazione1);
	}
	
	@Test
	void changeDataPrenotazione() {
		testPrenotazione.setDataPrenotazione(LocalDate.of(2023, 7, 31));
		assertEquals(testPrenotazione.getDataPrenotazione(), LocalDate.of(2023, 7, 31));
	}

}
