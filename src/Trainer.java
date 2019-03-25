import java.io.IOException;

public class Trainer {
	private Party trainerParty; 
	private String name;
	public Trainer (String name) throws IOException{
		this.name = name;
		trainerParty = new Party();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String trainerPartyToString () {
		return trainerParty.toString();
	}
	public Party getTrainerParty() {
		return trainerParty;
	}
	public void setTrainerParty(Party trainerParty) {
		this.trainerParty = trainerParty;
	}
}
