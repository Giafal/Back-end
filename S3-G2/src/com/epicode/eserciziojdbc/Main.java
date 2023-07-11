package com.epicode.eserciziojdbc;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		try {
			DbConnection db = new DbConnection();
			
			Studente s = new Studente("Gianluca", "Falcone", Gender.MALE, LocalDate.of(1987, 6, 1), 8.2, 7.5, 10.0);
			Studente s1 = new Studente("Andrea", "Bardi", Gender.MALE, LocalDate.of(1999, 5, 5), 9.0, 8.0, 10.0);
			Studente s2 = new Studente("Federico", "Morgante", Gender.MALE, LocalDate.of(1987, 3, 3), 7.8, 6.0, 9.0);
			//db.inserisciStudente(s2);
			
//			s.setAvg(8.5);
//			db.modificaUtente(s);
			
//			db.cancellaStudente(3l);
//			db.cancellaStudente(2l);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
