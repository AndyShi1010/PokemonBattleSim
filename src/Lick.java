

public class Lick extends Move{

	public Lick() {
		super("Lick", "Ghost", 1, 30, 30, 100);
	}

	@Override
	public double calculateDamage() {
		int attack = super.getMovePlayer().getTrainerParty().getPokemon(0).getAttack();
		int defence = super.getMovePlayer().getTrainerParty().getPokemon(0).getDefence();
		int random = (int)(Math.random() * 255 + 217)/255;
		double stab = 1;
		if (super.getMoveEnemy().getTrainerParty().getPokemon(0).getType1().equals(super.getMovePlayer().getTrainerParty().getPokemon(0).getType1())) {
			stab = 1.5;
		}
		double damage = ((((2*100)/5 * this.getPower() * (attack/defence)/50) + 2) * random * stab);
		return damage;
	}

}
