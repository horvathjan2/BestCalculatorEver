import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GUI {
	private JFrame window;
	
	public GUI(){
		window = new JFrame("Hello Swing");
		JButton b = new JButton("Button1");
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 5, 5);
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				b = new JButton(new Integer(j*3+i+1).toString());
				c.gridx=i;
				c.gridy=3-j;
				window.add(b, c);
			}
		}
		for(int i=0; i<2; i++){
			b = new JButton("0.".substring(i, i+1));
			c.gridy=4;
			c.gridx=i;
			window.add(b,c);
		}
		
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(640, 480);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
