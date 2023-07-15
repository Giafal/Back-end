package com.epicode.controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Articolo;
import com.epicode.model.Libro;
import com.epicode.model.Prestito;
import com.epicode.model.Utente;

public class Archivio {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("S3-Progetto-Settimanale");
	static EntityManager em = emf.createEntityManager();
	
	static Logger log = LoggerFactory.getLogger(Archivio.class);

	public static void main(String[] args) {
		
		//Libro l1 = new Libro("Il Signore degli anelli", 1970, 900, "Tolkien", "fantasy");
		//Libro l2 = new Libro("Il nome della rosa", 1970, 250, "Umberto Eco", "romanzo");
		
		//aggiungiArticolo(l2);
		
		//eliminaArticoloByISBN(6);
		
		//Articolo a = getArticoloByISBN(1);
		//System.out.println(a);
		
		//Articolo a2 = getArticoloByISBN(8);
		//System.out.println(a2);
		
		//Utente u = getUtenteById(1);
		//System.out.println(u);
		
		//Utente utente = getUtenteById(8);
		//System.out.println(utente);
		
		//List<Articolo> listaPerAnno = getArticoliByAnno(1970);
		//listaPerAnno.forEach(a -> System.out.println(a));
		
		//List<Articolo> listaPerAutore = getArticoliByAutore("Tolkien");
		//listaPerAutore.forEach(a -> System.out.println(a));
		
		//List<Articolo> listaPerTitolo = getArticoliByTitolo("Il Signore degli anelli");
		//listaPerTitolo.forEach(a -> System.out.println(a));
		
		//Utente u1 = new Utente("Gianluca", "Falcone", LocalDate.of(1987,6,1));
		//Utente u2 = new Utente("Andrea", "Bardi", LocalDate.of(2001,5,5));
		//aggiungiUtente(u2);
		
		//Prestito p1 = new Prestito(u, a, LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 2).plusDays(30) , LocalDate.of(2023, 3, 3));
	    //Prestito p2 = new Prestito(utente, a2, LocalDate.of(2023,5,5), LocalDate.of(2023,5,5).plusDays(30), LocalDate.of(2023,7,5));
		//aggiungiPrestito(p2);
		//eliminaPrestito(8);
		
		//List<Articolo> listaPerNumeroTessera = getArticoliInPrestitoByNumeroTessera(1);
		//listaPerNumeroTessera.forEach(b -> System.out.println(b));
		
		//List<Prestito> listaPrestitiScaduti = getPrestitiScaduti();
		//listaPrestitiScaduti.forEach(c -> System.out.println(c));
		

	}
	
	public static void aggiungiArticolo(Articolo a) {
		try { 
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		log.info("Articolo " + a.getTitolo() + " aggiunto al database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
		
	}
	
	public static void aggiungiUtente(Utente u) {
		try { 
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		log.info("Utente " + u.getNome() + " " + u.getCognome() + " aggiunto al database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void aggiungiPrestito(Prestito p) {
		try {
 		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		log.info("Prestito " + p.getIdPrestito() + " aggiunto al database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void eliminaArticoloByISBN(long id) {
		try {
		em.getTransaction().begin();
		Articolo a = em.find(Articolo.class, id);
		em.remove(a);
		em.getTransaction().commit();
		log.info("Articolo " + a.getTitolo() + " rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static void eliminaPrestito(long id) {
		try {
		em.getTransaction().begin();
		Prestito a = em.find(Prestito.class, id);
		em.remove(a);
		em.getTransaction().commit();
		log.info("Prestito rimosso dal database.");
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Articolo getArticoloByISBN(long id) {
		try {
		em.getTransaction().begin();
		Articolo a = em.find(Articolo.class, id);
		em.getTransaction().commit();
		return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
		
	}
	
	public static Utente getUtenteById(Integer id) {
		try {
		em.getTransaction().begin();
		Utente a = em.find(Utente.class, id);
		em.getTransaction().commit();
		return a;
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static List<Articolo> getArticoliByAnno(Integer anno) {
		try { 
		Query q = em.createNamedQuery("ricercaPerAnno");
		q.setParameter("annoPubblicazione", anno);
		return q.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static List<Articolo> getArticoliByAutore(String autore) {
		try {
		Query q = em.createNamedQuery("ricercaPerAutore");
		q.setParameter("autore", autore);
		return q.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static List<Articolo> getArticoliByTitolo(String titolo) {
		try {
		Query q = em.createNamedQuery("ricercaPerTitolo");
		q.setParameter("titolo", titolo);
		return q.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static List<Articolo> getArticoliInPrestitoByNumeroTessera(Integer nTessera) {
		try {
		Query q = em.createNamedQuery("ricercaPerNumeroTessera");
		q.setParameter("numerotessera", nTessera);
		return q.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	
	public static List<Prestito> getPrestitiScaduti() {
		try {
		Query q = em.createNamedQuery("ricercaPrestitiScaduti");
		return q.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Qualcosa è andato storto: " + e.getMessage());
		} return null;
	}
	

}
