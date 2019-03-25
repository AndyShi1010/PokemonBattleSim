
import java.io.IOException;

public class Pokemon {
	private int index;
	private String name;
	private double health;
	private final int maxHealth;
	private String type1;
	private String type2;
	private int attack;
	private int defence;
	private int specialAttack;
	private int specialDefence;
	private int speed;
	private Move[] moveSet;
	private boolean fainted;
	
	public Pokemon(int pokemonIndex) throws IOException {
		this.index = Integer.parseInt(dexReader.readValue(pokemonIndex, 0));
		this.name = dexReader.readValue(pokemonIndex, 1);
		this.maxHealth = Integer.parseInt(dexReader.readValue(pokemonIndex, 2));
		this.health = Double.parseDouble(dexReader.readValue(pokemonIndex, 2));
		this.attack = Integer.parseInt(dexReader.readValue(pokemonIndex, 3));
		this.defence = Integer.parseInt(dexReader.readValue(pokemonIndex, 4));
		this.specialAttack = Integer.parseInt(dexReader.readValue(pokemonIndex, 5));
		this.specialDefence = Integer.parseInt(dexReader.readValue(pokemonIndex, 6));
		this.speed = Integer.parseInt(dexReader.readValue(pokemonIndex, 7));
		this.type1 = dexReader.readValue(pokemonIndex, 8);
		this.type2 = dexReader.readValue(pokemonIndex, 9);
		this.moveSet = new Move[2];
		move1Setter(this.getType1());
		moveSet[1] = new Tackle();
		fainted = false;
	}
	
	public void setMoveEnemyAndPlayer(Trainer player, Trainer enemy) {
		moveSet[0].setMoveEnemy(enemy);
		moveSet[1].setMoveEnemy(enemy);
		moveSet[0].setMovePlayer(player);
		moveSet[1].setMovePlayer(player);
	}
	
	public boolean isFainted() {
		return fainted;
	}

	public void setFainted(boolean fainted) {
		this.fainted = fainted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHealth() {
		return health;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	
	public void takeDamage(double damage) {
		this.setHealth(this.getHealth() - damage);
		//System.out.println(this.getHealth());
	}
	
	public void increaseHealth(double amount) {
		this.setHealth(this.getHealth() + amount);
	}
	
	public int getIndex() {
		return index;
	}
	
	public void move1Setter(String pokeType) {
		switch (pokeType) {
			case "Normal":
				moveSet[0] = new DoubleSlap();
				break;
			case "Bug":
				moveSet[0] = new LeechLife();
				break;
			case "Ice":
				moveSet[0] = new IceBeam();
				break;
			case "Fighting":
				moveSet[0] = new KarateChop();
				break;
			case "Fire":
				moveSet[0] = new Ember();
				break;
			case "Flying":
				moveSet[0] = new Peck();
				break;
			case "Grass":
				moveSet[0] = new RazorLeaf();
				break;
			case "Ghost":
				moveSet[0] = new Lick();
				break;
			case "Ground":
				moveSet[0] = new Earthquake();
				break;
			case "Electric":
				moveSet[0] = new ThunderShock();
				break;
			case "Poison":
				moveSet[0] = new PoisonSting();
				break;
			case "Psychic":
				moveSet[0] = new Psychic();
				break;
			case "Rock":
				moveSet[0] = new RockThrow();
				break;
			case "Water":
				moveSet[0] = new WaterGun();
				break;
			case "Dragon":
				moveSet[0] = new DragonRage();
				break;
			default:
				moveSet[0] = new Tackle();
				break;
		}
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}
	
	public Move getMove1() {
		return this.moveSet[0];
	}
	
	public Move getMove2() {
		return this.moveSet[1];
	}
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public void decreaseAtk(int amount) {
		this.setAttack(this.getAttack() - amount);
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	public void decreaseDefence(int amount) {
		this.setDefence(this.getDefence() - amount);
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public void decreaseSpAtk(int amount) {
		this.setSpecialAttack(this.getSpecialAttack() - amount);
	}
	
	public int getSpecialDefence() {
		return specialDefence;
	}

	public void setSpecialDefence(int specialDefence) {
		this.specialDefence = specialDefence;
	}
	
	public void decreaseSpDef(int amount) {
		this.setSpecialDefence(this.getSpecialDefence() - amount);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void decreaseSpeed(int amount) {
		this.setSpeed(this.getSpeed() - amount);
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}
	
	public void doAttack(int i, Trainer opponent) {
		opponent.getTrainerParty().getPokemon(0).takeDamage(moveSet[i].calculateDamage());
	}
	
	public int getRandomMove() {
		int random = (int)Math.round(Math.random());
		return random;
	}
}
