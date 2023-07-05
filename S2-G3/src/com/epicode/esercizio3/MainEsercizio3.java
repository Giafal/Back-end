package com.epicode.esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class MainEsercizio3 {
	
	static Set<Presenza> registro = new HashSet<Presenza>();
	private static File file = new File("doc/test.txt");

	public static void main(String[] args) {
		
		Presenza uno = new Presenza("Gianluca@", 5);
		Presenza due = new Presenza("Andrea@", 4);
		Presenza tre = new Presenza("Luca@", 3);
		
		registro.add(uno);
		registro.add(due);
		registro.add(tre);
		
		try {
			scriviSuFile(uno);
			scriviSuFile(due);
			scriviSuFile(tre);
			System.out.println(leggidaFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void scriviSuFile(Presenza presenza) throws IOException {
		FileUtils.writeStringToFile(file, presenza.nome + presenza.presenza + "#", "UTF-8", true);
	}
	
	public static String leggidaFile() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
	}

}
