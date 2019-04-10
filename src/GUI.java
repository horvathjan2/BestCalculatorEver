import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GUI {
	private JFrame window;
	
	public GUI(){
		window = new JFrame("Hello Swing");
		JButton b = new JButton("Button");
		
		window.setLayout(new GridBagLayout());
		
		window.add(b);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(640, 480);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
