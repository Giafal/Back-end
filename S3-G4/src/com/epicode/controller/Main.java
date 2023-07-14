package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;

import com.epicode.enumerations.Type;
import com.epicode.model.Evento;
import com.epicode.model.Location;


public class Main {
	
	

	public static void main(String[] args) {
	
	Evento e1 = new Evento();
	
	
	try {
		//EventoDAO.salvaEvento(e1);
		Evento e = EventoDAO.getEventoById(1);
		//System.out.println(e);
		//e.setTipoEvento(Type.PRIVATO);
		//EventoDAO.modificaEvento(e);
		//EventoDAO.refreshEvento(e);
		//EventoDAO.cancellaEvento(e);
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
}

}
