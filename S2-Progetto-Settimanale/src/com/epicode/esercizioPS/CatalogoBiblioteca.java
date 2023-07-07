package com.epicode.esercizioPS;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogoBiblioteca {
	
	private static Logger log = LoggerFactory.getLogger(CatalogoBiblioteca.class);
	
	private static String filePath = "doc/archivio.txt";
	
	private Map<String, Articolo> archivio;
	
	public CatalogoBiblioteca() {
		this.archivio = new HashMap<String, Articolo>();
	}
	
	public void aggiungiArticolo(Articolo nuovoElemento) {
		archivio.put(nuovoElemento.getIsbn(), nuovoElemento);
		log.info("Articolo aggiunto all'archivio. Titolo: " + nuovoElemento.getTitolo());
	}
	
	public void rimuoviArticolo(String isbn) {
		Articolo elementoRimosso = archivio.remove(isbn);
		log.info("Articolo rimosso dall'archivio. Titolo: " + elementoRimosso.getTitolo());
	}
	
	public Articolo ricercaPerIsbn(String isbn) {
		return archivio.get(isbn);
	}
	
	public List<Articolo> ricercaPerAnno(Integer annoPubblicazione) {
		return archivio.values().stream()
				.filter(e -> annoPubblicazione.equals(e.getAnnoPubblicazione()))
				.collect(Collectors.toList());
	}
	
	public List<Articolo> ricercaPerAutore(String autore) {
		return archivio.values().stream()
				.filter(e -> e instanceof Libro)
				.map(e -> (Libro) e)
				.filter(e -> autore.equals(e.getAutore()))
				.collect(Collectors.toList());
	}
	
	public void salvaSuFile() throws IOException {
		String txt = "";
		for(Articolo articolo : archivio.values()) {
			if(txt.length() != 0) {
				txt += "#";
			}
			if(articolo instanceof Libro) {
				txt += Libro.toStringFile((Libro)articolo);
			} else if(articolo instanceof Rivista) {
				txt += Rivista.toStringFile((Rivista) articolo);
			}
		}
		
		File file = new File(filePath);
		
		FileUtils.writeStringToFile(file, txt, "UTF-8", true);
		log.info("Dati salvati correttamente sul file: " + file);
		
	}
	
	public void caricaDaFile() throws IOException {
		this.archivio.clear();
		
		File file = new File(filePath);

		String fileString = FileUtils.readFileToString(file, "UTF-8");

		List<String> arraySplittato = Arrays.asList(fileString.split("#"));

		for (String curString : arraySplittato) {
			Articolo elemento = null;
			if ( curString.startsWith(Libro.class.getSimpleName()) ) {
				elemento = Libro.fromStringFile(curString);
			} else if ( curString.startsWith(Rivista.class.getSimpleName()) ) {
				elemento= Rivista.fromStringFile(curString);
			}
			this.archivio.put(elemento.getIsbn(), elemento);
			
		}
		
		
		log.info("Dati caricati correttamente dal file: " + file);

	}
	
	

	public static void main(String[] args) {
		
		CatalogoBiblioteca catalogo = new CatalogoBiblioteca();
		
		Libro l1 = new Libro("001", "Guida galattica per autostoppisti", 1979, 224, "Douglas Adams", "Fantascienza");
		Libro l2 = new Libro("002", "American Gods", 2001, 523, "Neil Gaiman", "Romanzo");
		Rivista r1 = new Rivista("003", "Focus", 2023, 80, Periodicita.MENSILE);
		Rivista r2 = new Rivista("004", "Internazionale", 2023, 80, Periodicita.SETTIMANALE);
		Libro l3 = new Libro("005", "Stardust", 1997, 250, "Neil Gaiman", "Romanzo");
		
		catalogo.aggiungiArticolo(l1);
		catalogo.aggiungiArticolo(l2);
		catalogo.aggiungiArticolo(r1);
		catalogo.aggiungiArticolo(r2);
		catalogo.aggiungiArticolo(l3);
		
		try {
			catalogo.salvaSuFile();
			catalogo.caricaDaFile();
			
			List<Articolo> cercaAutore = catalogo.ricercaPerAutore("Neil Gaiman");
			cercaAutore.forEach(e -> log.info("Un libro di Neil Gaiman è: " + e.getTitolo()));
			
			Articolo cercaIsbn = catalogo.ricercaPerIsbn("001");
			log.info("L'articolo con codice Isbn 001 è:" + cercaIsbn);
			
			List<Articolo> cercaAnno = catalogo.ricercaPerAnno(1979);
			cercaAnno.forEach(e -> log.info("Questo articolo è stato pubblicato nel 1979: " + e.getTitolo()));
			
		} catch(IOException e) {
			log.error("Errore nel salvataggio o nel caricamento dei dati!!!");
		} 
		

	}

}
