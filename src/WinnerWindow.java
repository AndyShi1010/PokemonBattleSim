import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinnerWindow extends JFrame{
	private JLabel winnerText;
	private JPanel window = new JPanel();
	public WinnerWindow() {
		super("Winner");
		super.setSize(300, 100);
		super.setResizable(false);
		super.setContentPane(window);
		super.setVisible(true);
		super.setAlwaysOnTop(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void drawWinner(String winner) {
		winnerText = new JLabel(winner);
		window.add(winnerText);
	}
	
	

}
