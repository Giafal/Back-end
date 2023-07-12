package com.epicode.eserciziojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "jdbctest";
	String user = "postgres";
	String pass = "root";
	Statement st;
	
	public DbConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url+dbName, user, pass); 
		st = conn.createStatement(); 
		createTableStudenti();
		System.out.println("DB Connect!!!");
	}
	
	public void createTableStudenti() throws SQLException {
		String sql =  " CREATE TABLE IF NOT EXISTS studenti ("
					+ "		id SERIAL PRIMARY KEY,"
					+ " 	name VARCHAR NOT NULL,"
					+ "		lastname VARCHAR NOT NULL,"
					+ "		gender VARCHAR NOT NULL,"
					+ "		birthdate DATE NOT NULL,"
					+ "		avg DECIMAL NOT NULL,"
					+ "		min_vote DECIMAL NOT NULL,"
					+ "		max_vote DECIMAL NOT NULL"
					+ " );" ;
		st.executeUpdate(sql);
		System.out.println("Table studenti created!!!");
	}
	
	public void inserisciStudente(Studente s) throws SQLException {
		String sql = " INSERT INTO studenti (name, lastname, gender, birthdate, avg, min_vote, max_vote) "
				   + "VALUES ('"+s.getName()+"', '"+s.getLastname()+"', '"
				   + s.getGender()+"', '"+ s.getBirthdate() + "', " 
				   + s.getAvg() + ", "+ s.getMin_vote()+", "+ s.getMax_vote()+");";
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastname() + " created!!!");
	}
	
	public void modificaUtente(Studente s) throws SQLException {
		String sql = "UPDATE studenti SET "
				   + " name = '" + s.getName() + "', "
				   + " lastname = '" + s.getLastname() + "', "
//				   + " gender = " + s.getGender() + ", "
//				   + " birthdate = " + s.getBirthdate() + ", "
				   + " avg = " + s.getAvg() + ", "
				   + " min_vote = " + s.getMin_vote() + ", "
				   + " max_vote = '" + s.getMax_vote() + "' "
				   + " WHERE id = " + s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getName() + " " + s.getLastname() + " udpate!!!");
	}
	
	public void cancellaStudente(Long id) throws SQLException {
		String sql = "DELETE FROM studenti WHERE id = " + id;
		st.executeUpdate(sql);
		System.out.println("Student deleted!!!");
	}
	
	

}
