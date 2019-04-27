import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;

public class GUI {
	private JFrame window;
	private JLabel numberInput;
	private StringBuilder s;
	
	public GUI(ArrayList<Class<?>> operations){
		s = new StringBuilder();
		window = new JFrame("C");
		JButton b = new JButton("Button1");
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				Integer label = new Integer(j*3+i+1);
				b = new JButton(label.toString());
				b.addActionListener(new NumberInputActionListener(this, label.toString().charAt(0)));
				c.gridx=i;
				c.gridy=4-j;
				window.add(b, c);
			}
		}
		for(int i=0; i<2; i++){
			b = new JButton("0.".substring(i, i+1));
			b.addActionListener(new NumberInputActionListener(this, "0.".charAt(i)));
			c.gridy=5;
			c.gridx=i;
			window.add(b,c);
		}
		
		numberInput = new JLabel();
		pushChar('0');
		c.gridy=0;
		c.gridx=0;
		c.gridwidth=4;
		window.add(numberInput, c);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(200, 250);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void pushChar(char c){
		if(s.toString().length()<18){
			if(s.toString().equals("0")){
				if(c == '.'){
					s.append(c);
				} else if(c != '0'){
					s.setCharAt(0, c);
				}
			} else if(!(c=='.' && s.toString().contains("."))){
				s.append(c);
			}
			numberInput.setText(s.toString());
		}
	}
}
