import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class dexReader {
	public static void readTxtPrint () {
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader("Pokedex.txt")); //assumes text file by default
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		String line = null;
		try {
			while ((line = r.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BufferedReader readFile () {
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader("Pokedex.txt")); //assumes text file by default
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	public static String readLine (int pokeIndex) throws IOException{
		BufferedReader r = readFile(); //create new BufferedReader object 
		String line = "";
		for (int i = 0; i < pokeIndex; i++) {
			line = r.readLine(); //reads line
		}
		if (line == null) {
			return "ERROR: LINE DOES NOT EXIST!";
		} else {
			return line;
		}
	}
	
	public static String readValue (int pokeIndex, int valueIndex) throws IOException {
		String dexEntry = readLine(pokeIndex);
		String[] splitEntry = dexEntry.split("\t");
		if (valueIndex >= splitEntry.length) {
			return null;
		}
		return splitEntry[valueIndex];
	}
}
