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
		
		Libro l1 = new Libro("Il Signore degli anelli", 1970, 900, "Tolkien", "fantasy");
		Libro l2 = new Libro("Il nome della rosa", 1970, 250, "Umberto Eco", "romanzo");
		
		//aggiungiArticolo(l1);
		
		//eliminaArticoloByISBN(6);
		
		//Articolo a = getArticoloByISBN(1);
		//System.out.println(a);
		
		//Utente u = getUtenteById(1);
		//System.out.println(u);
		
		//List<Articolo> listaPerAnno = getArticoliByAnno(1970);
		//listaPerAnno.forEach(a -> System.out.println(a));
		
		//List<Articolo> listaPerAutore = getArticoliByAutore("Tolkien");
		//listaPerAutore.forEach(a -> System.out.println(a));
		
		//List<Articolo> listaPerTitolo = getArticoliByTitolo("Il Signore degli anelli");
		//listaPerTitolo.forEach(a -> System.out.println(a));
		
		Utente u1 = new Utente("Gianluca", "Falcone", LocalDate.of(1987,6,1));
		//aggiungiUtente(u1);
		
		//Prestito p1 = new Prestito(u, a, LocalDate.of(2023, 2, 2), LocalDate.of(2023, 2, 2).plusDays(30) , LocalDate.of(2023, 3, 3));
	    //aggiungiPrestito(p1);
		//eliminaPrestito(8);
		
		List<Articolo> listaPerNumeroTessera = getArticoliInPrestitoByNumeroTessera(1);
		listaPerNumeroTessera.forEach(b -> System.out.println(b));
		

	}
	
	public static void aggiungiArticolo(Articolo a) {
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		log.info("Articolo " + a.getTitolo() + " aggiunto al database.");
		
	}
	
	public static void aggiungiUtente(Utente u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		log.info("Utente " + u.getNome() + " " + u.getCognome() + " aggiunto al database.");
		
	}
	
	public static void aggiungiPrestito(Prestito p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		log.info("Prestito " + p.getIdPrestito() + " aggiunto al database.");
		
	}
	
	public static void eliminaArticoloByISBN(long id) {
		em.getTransaction().begin();
		Articolo a = em.find(Articolo.class, id);
		em.remove(a);
		em.getTransaction().commit();
		log.info("Articolo " + a.getTitolo() + " rimosso dal database.");
	}
	
	public static void eliminaPrestito(long id) {
		em.getTransaction().begin();
		Prestito a = em.find(Prestito.class, id);
		em.remove(a);
		em.getTransaction().commit();
		log.info("Prestito rimosso dal database.");
	}
	
	public static Articolo getArticoloByISBN(long id) {
		em.getTransaction().begin();
		Articolo a = em.find(Articolo.class, id);
		em.getTransaction().commit();
		return a;
	}
	
	public static Utente getUtenteById(Integer id) {
		em.getTransaction().begin();
		Utente a = em.find(Utente.class, id);
		em.getTransaction().commit();
		return a;
	}
	
	public static List<Articolo> getArticoliByAnno(Integer anno) {
		Query q = em.createNamedQuery("ricercaPerAnno");
		q.setParameter("annoPubblicazione", anno);
		return q.getResultList();
	}
	
	public static List<Articolo> getArticoliByAutore(String autore) {
		Query q = em.createNamedQuery("ricercaPerAutore");
		q.setParameter("autore", autore);
		return q.getResultList();
	}
	
	public static List<Articolo> getArticoliByTitolo(String titolo) {
		Query q = em.createNamedQuery("ricercaPerTitolo");
		q.setParameter("titolo", titolo);
		return q.getResultList();
	}
	
	public static List<Articolo> getArticoliInPrestitoByNumeroTessera(Integer nTessera) {
		Query q = em.createNamedQuery("ricercaPerNumeroTessera");
		q.setParameter("numerotessera", nTessera);
		return (List<Articolo>) q.getResultList();
	}
	

}
