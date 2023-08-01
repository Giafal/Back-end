package com.epicode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.epicode.enumerations.TipoPostazione;
import com.epicode.model.Postazione;

public interface PostazioneRepository extends CrudRepository<Postazione, Long>{
	
	@Query("SELECT p FROM Postazione p WHERE p.tipo LIKE :tipo AND p.edificio.citta LIKE :citta")
	List<Postazione> findByTypeAndCity(@Param("tipo") TipoPostazione tipo, @Param("citta") String citta);

}
