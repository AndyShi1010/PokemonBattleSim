
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Move {
	private String moveName;
	private String moveType;
	private int moveCatergory; //1 = Physical, 2 = Status, 3 = Special
	private int ppValue;
	private final int maxPP;
	private int power;
	private int accuracy;
	private Trainer enemy;
	private Trainer player;
	
	public Move (String moveName, String moveType, int moveCat, int pp, int power, int accuracy) {
		this.moveName = moveName;
		this.moveType = moveType;
		this.moveCatergory = moveCat;
		this.maxPP = pp;
		this.ppValue = pp;
		this.power = power;
		this.accuracy = accuracy;
	}
	
	public void setEnemy (Trainer enemy) {
		this.enemy = enemy;
	}
	
	public void setPlayer (Trainer player) {
		this.player = player;
	}
	
	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	public String getMoveType() {
		return moveType;
	}

	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}

	public int getMoveCatergory() {
		return moveCatergory;
	}

	public void setMoveCatergory(int moveCatergory) {
		this.moveCatergory = moveCatergory;
	}

	public int getPpValue() {
		return ppValue;
	}

	public void setPpValue(int ppValue) {
		this.ppValue = ppValue;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String toString () {
		return (this.getMoveName() + " (" + this.getPpValue() + "/" + this.getMaxPP() + ")");
	}

	public int getMaxPP() {
		return maxPP;
	}
	
	public void decreasePP() {
		this.ppValue--;
	}
	
	public void setMoveEnemy(Trainer enemy) {
		this.enemy = enemy;
	}
	
	public void setMovePlayer(Trainer player) {
		this.player = player;
	}
	
	public Trainer getMoveEnemy() {
		return this.enemy;
	}
	
	public Trainer getMovePlayer() {
		return this.player;
	}
	
	public abstract double calculateDamage();

	
}
