import java.io.IOException;
import java.util.ArrayList;


public class Party {
	private ArrayList<Pokemon> party = new ArrayList<Pokemon>();
	
	public Party () throws IOException{
		for (int i = 0; i < 6; i++) {
			party.add(new Pokemon(chooseRandomPokemon()));
		}
	}
	
	public int chooseRandomPokemon () {
		int rand = (int)(Math.random() * 151 + 1);
		return rand;
	}
	
	public void removePokemon (int i) {
		party.remove(i);
	}
	
	public Pokemon getPokemon (int i) {
		if (party.size() > 0) {
			return party.get(i);
		} else {
			return null;
		}
	}

	public ArrayList<Pokemon> getParty() {
		return party;
	}

	public void setParty(ArrayList<Pokemon> party) {
		this.party = party;
	}
	
	public int getLength() {
		return party.size();
	}
	
}
