import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame implements MouseListener{
	Battlefield gameField;
	private boolean movesIsShown = false;
	public MainWindow() {
		super("Pokemon Battle Sim [Alpha]"); //Sets title of the window
		super.setSize(1080, 720); //sets size of window
		super.setVisible(true); //makes window visible
		super.setResizable(false); //makes window non-resizable
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);//Makes sure program stops when close button is clicked
		addMouseListener(this);
	}
	
	//Overrides the paint method in JFrame superclass
	@Override
	public void paint(Graphics g) {  	//Draws everything
		if ((!gameField.getPlayerTrainer().getTrainerParty().getParty().isEmpty()) || (!gameField.getEnemyTrainer().getTrainerParty().getParty().isEmpty())) {	
			//System.out.println(gameField.isShowMoves());
			BufferedImage background = null;//Makes a new buffered image
			try {
				background = ImageIO.read(getClass().getResource("Bkg.bmp")); //returns a buffered image of the image file
				
			} catch (IOException e) {
				System.out.println("Error reading image file");
			}
			g.drawImage(background, 0, 30, null);
			//(BufferedImage, xPos, yPos, imageObserver(not needed)) Draws the image
			// yPos includes title bar space so always put more than actual pos. Depends on dpi. 30px default
			if (gameField.isShowMoves() && !movesIsShown) {
				MoveWindow moves = new MoveWindow();
				moves.setMove1(gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMove1());
				moves.setMove2(gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMove2());
				moves.setField(gameField);
				movesIsShown = true;
			} else {
				g.setFont(new Font("MONOSPACED", Font.PLAIN, 26)); //Sets font text is drawn in 
				g.drawString(gameField.caption, 50 , 650); //Bottom Text
			}
			if (!(gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getHealth() <= 0)){
				g.setFont(new Font("SANS_SERIF", Font.PLAIN, 26));
				g.setColor(Color.BLACK);
				String playerURL = ("/pokeSprites/" + Integer.toString(gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getIndex()) + ".png");
				try {
					Image playerPokemonSprite = ImageIO.read(getClass().getResource(playerURL));
					Image playerSprite = playerPokemonSprite.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
					g.drawImage(playerSprite, 100, 625-playerSprite.getHeight(null), null);
				} catch (IOException e) {
					System.out.println("Error reading image file");
				}
				String nameString = (gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getName() 
						+ " (" + (int)gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getHealth() 
						+ "/" + gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMaxHealth()
						+ ")" + "[" + gameField.getPlayerTrainer().getTrainerParty().getLength() + "]");
				g.drawString(nameString, 700 , 450);
				g.fillRect(700,475,202,27);
				g.setColor(Color.GREEN);
				double currentPlayerHP = gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getHealth();
				double totalPlayerHP = gameField.getPlayerTrainer().getTrainerParty().getPokemon(0).getMaxHealth();
				if ((currentPlayerHP / totalPlayerHP) > 0.5) {
					g.setColor(Color.GREEN);
				} else if ((currentPlayerHP / totalPlayerHP) > 0.25) {
					g.setColor(Color.YELLOW);
				} else {
					g.setColor(Color.RED);
				}
				g.fillRect(701,476,(int)(200 * (currentPlayerHP / totalPlayerHP)),25);
			} else {
				gameField.getPlayerTrainer().getTrainerParty().getParty().remove(0);
			}
			if (!(gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getHealth() <= 0)) {
				g.setFont(new Font("SANS_SERIF", Font.PLAIN, 26));
				g.setColor(Color.BLACK);
				String enemyURL = ("/pokeThumb/" + Integer.toString(gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getIndex()) + ".png");
				try {
					Image enemyPokemonSprite = ImageIO.read(getClass().getResource(enemyURL));
					Image enemySprite = enemyPokemonSprite.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
					g.drawImage(enemySprite, 675, 350-enemySprite.getHeight(null), null);
				} catch (IOException e) {
					System.out.println("Error reading image file");
				}
				String nameString = (gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getName()
						+ " (" + (int)gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getHealth()
						+ "/" + gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getMaxHealth()
						+ ")" + "[" + gameField.getEnemyTrainer().getTrainerParty().getLength() + "]");
				g.drawString(nameString, 100 , 100);
				g.fillRect(100,125,202,27);
				double currentEnemyHP = gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getHealth();
				double totalEnemyHP = gameField.getEnemyTrainer().getTrainerParty().getPokemon(0).getMaxHealth();
				if ((currentEnemyHP / totalEnemyHP) > 0.5) {
					g.setColor(Color.GREEN);
				} else if((currentEnemyHP / totalEnemyHP) > 0.25) {
					g.setColor(Color.YELLOW);
				} else {
					g.setColor(Color.RED);
				}
				g.fillRect(101,126,(int)(200 * (currentEnemyHP / totalEnemyHP)),25);
			} else {
				gameField.getEnemyTrainer().getTrainerParty().getParty().remove(0);
			}
		}
			
	}
	
	public boolean isMovesIsShown() {
		return movesIsShown;
	}

	public void setMovesIsShown(boolean movesIsShown) {
		this.movesIsShown = movesIsShown;
	}

	public void setField (Battlefield gameField) {
		this.gameField = gameField;
	}
	@Override
	public void mouseClicked(MouseEvent click) {
		if (click.getButton() == MouseEvent.BUTTON1) {
			if ((gameField.getPlayerTrainer().getTrainerParty().getLength() > 0) && (gameField.getEnemyTrainer().getTrainerParty().getLength() > 0)) {	
				gameField.caption = gameField.nextLine;
				if (gameField.nextLine.equals("")) {
					gameField.setShowMoves(true);
				} else {
					gameField.nextLine = "";
				}
				gameField.nextLine = "";
				this.repaint();
			} else {
				if (gameField.getPlayerTrainer().getTrainerParty().getLength() > 0) {
					WinnerWindow winDisplay = new WinnerWindow();
					winDisplay.drawWinner(gameField.getPlayerTrainer().getName() + " WINS!");
				} else {
					WinnerWindow winDisplay = new WinnerWindow();
					winDisplay.drawWinner(gameField.getEnemyTrainer().getName() + " WINS!");
				}
				this.dispose();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
