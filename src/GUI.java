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
	private Calculator calc;
	
	public GUI(ArrayList<Class<Operation>> operations){
		s = new StringBuilder();
		window = new JFrame("Calculator");
		calc = new Calculator();
		JButton b = new JButton("Button1");
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.BOTH;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				Integer label = new Integer(j*3+i+1);
				b = new JButton(label.toString());
				b.addActionListener(new NumberInputActionListener(this, label.toString().charAt(0)));
				c.gridx=i;
				c.gridy=3-j;
				window.add(b, c);
			}
		}
		for(int i=0; i<2; i++){
			b = new JButton("0.".substring(i, i+1));
			b.addActionListener(new NumberInputActionListener(this, "0.".charAt(i)));
			c.gridy=4;
			c.gridx=i;
			window.add(b,c);
		}
		
		for(int i=0; i<operations.size(); i++){
			try{
				b = new JButton(((Operation)(operations.get(i).newInstance())).getSymbol());
				b.addActionListener(new OperationInputActionListener(this, operations.get(i)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			c.gridy = 1 + i%4;
			c.gridx = 4 + i/4;
			window.add(b,c);
		}
		
		numberInput = new JLabel();
		pushChar('0');
		c.gridy=0;
		c.gridx=0;
		c.gridwidth=5 + operations.size()/4;
		window.add(numberInput, c);
		
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setSize(window.getWidth()+50, window.getHeight()+50);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void pushChar(char c){
		if(s.toString().length()<38){
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
	
	public void pushOperation(Class<Operation> op){
		try {
			System.out.println(op.newInstance().getSymbol());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
