package it.epicode.be;

public class Helloworld {

	static String[] array = {"ciao", "mi", "chiamo", "gianluca", "falcone"};

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		System.out.println(moltiplica(3,2));
		System.out.println(concatena("Club", 64));
		}

public static int moltiplica (int x, int y) {
	int result = x * y;
	return result;
}

public static String concatena (String x, int y) {
    String result1 = x + y;
    return result1;
}

public static String[] inserisciInArray (String[] array , String x) {
	array[3] = x;
	return array;

}


}



