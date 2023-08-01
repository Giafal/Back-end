package com.epicode.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epicode.model.Postazione;
import com.epicode.model.Prenotazione;
import com.epicode.model.Utente;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
	
	List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
	Prenotazione findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

}
