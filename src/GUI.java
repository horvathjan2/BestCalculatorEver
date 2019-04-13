import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GUI {
	private JFrame window;
	
	public GUI(){
		window = new JFrame("Hello Swing");
		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(20, 20, 20, 20);
		window.add(b1,c);
		c.gridx = 1;
		window.add(b2,c);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(640, 480);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
