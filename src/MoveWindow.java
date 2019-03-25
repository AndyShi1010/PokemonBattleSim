

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveWindow extends JFrame implements ActionListener{
	private Battlefield gameField;
	private Move move1;
	private Move move2;
	String move2text = "";
	private JPanel window = new JPanel();
	private JButton switchButton;
	private JButton move1button;
	private JButton move2button;
	public MoveWindow() {
		super(("What will you do?")); //Sets title of the window
		super.setSize(350, 75); //sets size of window
		super.setResizable(false); //makes window non-resizable
		super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//Makes sure program stops when close button is clicked
		setContentPane(window); 
		setVisible(true);
		super.setAlwaysOnTop(true);
	}
	
	public void setMove1(Move move1) {
		this.move1 = move1;
		move1button = new JButton(move1.toString());
		move1button.setContentAreaFilled(false); 
		move1button.addActionListener(this);
		move1button.setFocusPainted(false);
		window.add(move1button);
		if (move1.getPpValue() <= 0) {
			move1button.setEnabled(false);
		}
	}
	
	public void setMove2(Move move2) {
		this.move2 = move2;
		move2button = new JButton(move2.toString());
		move2button.setContentAreaFilled(false); 
		move2button.addActionListener(this);
		move2button.setFocusPainted(false);
		window.add(move2button);
		if (move2.getPpValue() <= 0) {
			move2button.setEnabled(false);
		}
	}
	
	public void setField (Battlefield field) {
		gameField = field;
	}
	
	@Override
	public void actionPerformed(ActionEvent button) {
		if (button.getSource().equals(move1button)) {
			gameField.caption = ((gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getName().toUpperCase()) + " used " + move1.getMoveName() + "!");
			gameField.setShowMoves(false);
			gameField.gameWindow.setMovesIsShown(false);
			gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).doAttack(0, gameField.getEnemyTrainer());
			gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMove1().decreasePP();
			dispose();
			gameField.nextLine = "Opponent Attacked";
			gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).doAttack(gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getRandomMove(), gameField.getPlayerTrainer());
			gameField.frameRefresh();
		}
		if (button.getSource().equals(move2button)) {
			gameField.caption = ((gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getName().toUpperCase()) + " used " + move2.getMoveName() + "!");
			gameField.setShowMoves(false);
			gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).doAttack(1, gameField.getEnemyTrainer());
			gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMove2().decreasePP();
			dispose();
			gameField.nextLine = "Opponent Attacked";
			gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).doAttack(gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getRandomMove(), gameField.getPlayerTrainer());
			gameField.gameWindow.setMovesIsShown(false);
			gameField.frameRefresh();
		}
	}

}
