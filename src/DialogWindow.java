import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogWindow extends JFrame implements ActionListener, KeyListener{ 
	private JTextField nameInput = new JTextField();
	private Trainer playerTrainer = null;
	private Trainer enemyTrainer = null;
	
	public DialogWindow() {
		super("Enter Name"); //Sets title of the window
		super.setSize(300, 160); //sets size of window
		super.setResizable(false); //makes window non-resizable
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);//Makes sure program stops when close button is clicked
		JPanel window = new JPanel();
		JButton start = new JButton("Start Battle"); // Makes new button
		//few cosmetic changes
		start.setContentAreaFilled(false); //removes ugly default gradient style
		start.setBorderPainted(false); // removes windows-95 esque button border
		//start.setFocusPainted(false);
		try {
			Image icon = ImageIO.read(getClass().getResource("/UIElements/play.png")).getScaledInstance(24, 24, Image.SCALE_DEFAULT); //returns a buffered image of the image file
			start.setIcon(new ImageIcon(icon));
		} catch (IOException e) {
			System.out.println("Error reading image file");
		}
		nameInput.setPreferredSize(new Dimension(200,20)); // Sets size of the text field
		start.addActionListener(this); //When button is pressed, it will call actionPerformed
		nameInput.addKeyListener(this);//Creates new keylistener inside of textfield
		window.add(new JLabel("Please enter your name?")); // Draws the text on the window
		window.add(nameInput); // Draws text field;
		window.add(start);
		setContentPane(window); //Sets what is drawn
		setVisible(true); //makes window visible
		
	}
	

	@Override
	public void actionPerformed(ActionEvent button) { //Performs actions when button is pressed
		Battlefield gameField = new Battlefield(nameInput.getText());
		dispose();// Closes the JFrame
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyReleased(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_ENTER) {
			actionPerformed(null);
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
