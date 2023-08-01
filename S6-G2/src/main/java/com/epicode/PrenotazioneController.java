package com.epicode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.model.Prenotazione;
import com.epicode.services.PrenotazioneService;

@RestController
@RequestMapping("/api/bookings")
public class PrenotazioneController {
	
	@Autowired PrenotazioneService ps;
	
	@GetMapping
	public ResponseEntity<List<Prenotazione>> getAll() {
		List<Prenotazione> listaPrenotazioni = ps.findAll();
		ResponseEntity<List<Prenotazione>> resp = new ResponseEntity<List<Prenotazione>>(listaPrenotazioni, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByID(@PathVariable Long id) {
		try {
			Prenotazione c = ps.findById(id);
			return new ResponseEntity<Prenotazione>(c, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Prenotazione p) {
		try {
			Prenotazione c = ps.salvaPrenotazione(p);
			return new ResponseEntity<Prenotazione>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Prenotazione p) {
		try {
			Prenotazione c = ps.updatePrenotazione(id, p);
			return new ResponseEntity<Prenotazione>(c, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> remove(@PathVariable Long id) {
		try {
			String msg = ps.rimuoviPrenotazioneById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
