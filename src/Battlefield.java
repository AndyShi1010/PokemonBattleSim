import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Battlefield {
	private Trainer playerTrainer = null;
	private Trainer enemyTrainer = null;
	public String caption = "";
	public String nextLine = "";
	private BufferedImage playerPokemonSprite = null;
	private BufferedImage enemyPokemonSprite = null;
	private boolean showMoves = false;
	MainWindow gameWindow;
	
	public Battlefield (String playerName) {
		gameWindow = new MainWindow();
		try {
			if (playerName.equals("")) {
				playerTrainer = new Trainer("RED");
			} else {
				playerTrainer = new Trainer(playerName.trim());
			}
			 enemyTrainer = new Trainer("Opponent");
		} catch (IOException e) {
			e.printStackTrace();
		}
		gameWindow.setField(this);
		if (playerTrainer.getName().equals("boston")) {
			caption = "Wellcome to the Boston wrold!!";//Easter Egg
		} else {
			caption = (playerTrainer.getName().toUpperCase() + " joins the battle! Go! " + playerTrainer.getTrainerParty().getPokemon(0).getName().toUpperCase());
		}
		gameWindow.repaint();
		for (int i = 0; i < 6; i++) {
			playerTrainer.getTrainerParty().getPokemon(i).setMoveEnemyAndPlayer(playerTrainer, enemyTrainer);
			enemyTrainer.getTrainerParty().getPokemon(i).setMoveEnemyAndPlayer(enemyTrainer, playerTrainer);
		}
		nextLine = ((enemyTrainer.getName().toUpperCase() + " uses " + enemyTrainer.getTrainerParty().getPokemon(0).getName().toUpperCase()));
	}
	
	public boolean isShowMoves() {
		return showMoves;
	}

	public void setShowMoves(boolean showMoves) {
		this.showMoves = showMoves;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public Trainer getPlayerTrainer() {
		return playerTrainer;
	}

	public void setPlayerTrainer(Trainer playerTrainer) {
		this.playerTrainer = playerTrainer;
	}

	public Trainer getEnemyTrainer() {
		return enemyTrainer;
	}

	public void setEnemyTrainer(Trainer enemyTrainer) {
		this.enemyTrainer = enemyTrainer;
	}

	public void frameRefresh() {
		gameWindow.repaint();
	}
	
	public BufferedImage getPlayerPokemonSprite() {
		return playerPokemonSprite;
	}

	public void setPlayerPokemonSprite(BufferedImage playerPokemonSprite) {
		this.playerPokemonSprite = playerPokemonSprite;
	}

	public BufferedImage getEnemyPokemonSprite() {
		return enemyPokemonSprite;
	}

	public void setEnemyPokemonSprite(BufferedImage enemyPokemonSprite) {
		this.enemyPokemonSprite = enemyPokemonSprite;
	}

}
