package it.epicode.be;

public class Helloworld {

	static String[] array = {"ciao", "mi", "chiamo", "gianluca", "falcone"};

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		System.out.println(moltiplica(3,2));
		System.out.println(concatena("Club", 64));
		String[] resInserisciInArray = inserisciInArray(array, "solo");
		for (int i = 0; i < resInserisciInArray.length; i++) {
			System.out.println(resInserisciInArray[i]);
		}
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
	String[] newArray = new String[6];
	newArray[0] = array[0];
	newArray[1] = array[1];
	newArray[2] = array[2];
	newArray[3] = x;
	newArray[4] = array[3];
	newArray[5] = array[4];
	return newArray;

}


}



