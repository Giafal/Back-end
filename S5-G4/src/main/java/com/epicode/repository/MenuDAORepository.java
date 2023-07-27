package com.epicode.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.model.Ordine;

public interface MenuDAORepository extends CrudRepository<Ordine, Long>{

}
