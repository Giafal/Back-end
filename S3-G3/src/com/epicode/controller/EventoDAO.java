package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Evento;
import com.epicode.model.Type;
import com.epicode.utils.JpaUtil;

public class EventoDAO {
	
	static Logger log = LoggerFactory.getLogger(EventoDAO.class);
	
	static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		
		//Evento e1 = new Evento("Concerto", LocalDate.of(2023, 7, 12), "Dente in acustico", Type.PUBBLICO, 200);
		try {
			//salvaEvento(e1);
			Evento e = getEventoById(2);
			
			e.setTipoEvento(Type.PRIVATO);
			//modificaEvento(e);
			System.out.println(e);
			refreshEvento(e);
			//cancellaEvento(e);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		

	}
	
	public static void salvaEvento(Evento e) throws SQLException {
		em.getTransaction().begin(); 
		em.persist(e);
		em.getTransaction().commit(); 
		log.info("Evento " + e.getTitolo() + " salvato nel database.");
	}
	
	public static Evento getEventoById(long id) throws SQLException {
		em.getTransaction().begin();
		Evento e = em.find(Evento.class, id);
		em.getTransaction().commit();
		return e;
	}
	
	public static void cancellaEvento(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.remove(e); 
		em.getTransaction().commit();
		log.info("Evento " + e.getTitolo() + " cancellato dal database.");
	}
	
	public static void modificaEvento(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.merge(e); 
		em.getTransaction().commit();
		log.info("Evento" + e.getTitolo() + " modificato!!!");
	}
	
	public static void refreshEvento(Evento e) throws SQLException {
		em.refresh(e);
		log.info("Refresh effettuato con successo");
	}

}
