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
	private boolean expectNumber;
	
	public GUI(ArrayList<Class<Operation_0>> operations){
		s = new StringBuilder();
		window = new JFrame("Calculator");
		calc = new Calculator();
		expectNumber = true;
		JButton b = new JButton("Button1");
		window.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(3, 3, 3, 3);
		c.fill = GridBagConstraints.BOTH;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				Integer label = new Integer(j*3+i+1);
				b = new JButton(label.toString());
				b.addActionListener(e -> pushChar(label.toString().charAt(0)));
				c.gridx=i;
				c.gridy=3-j;
				window.add(b, c);
			}
		}
		
		
		b = new JButton("0");
		b.addActionListener(e -> pushChar('0'));
		c.gridy=4;
		c.gridx=0;
		window.add(b, c);
		
		b = new JButton(".");
		b.addActionListener(e -> pushChar('.'));
		c.gridy=4;
		c.gridx=1;
		window.add(b, c);
		
		
		b=new JButton("=");
		b.addActionListener(e -> equalsButton());
		c.gridx=2;
		window.add(b, c);
		
		for(int i=0; i<operations.size(); i++){
			try{
				int li = i;
				b = new JButton(((Operation_0)(operations.get(i).newInstance())).getSymbol());
				b.addActionListener(e -> pushOperation(operations.get(li)));
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
		if(expectNumber){
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
	}
	
	public void pushOperation(Class<Operation_0> op){
		try{
			if(Operation_2.class.isAssignableFrom(op)){
				if(expectNumber && s.toString().length()>0){
					calc.pushNumber(new Double(s.toString()));
				}
				calc.pushOperation((Operation_1)(op.newInstance()));
				expectNumber = true;
				s = new StringBuilder();
				numberInput.setText(new Double(calc.getResult()).toString());
			} else if (Operation_1.class.isAssignableFrom(op)){
				if(expectNumber && s.toString().length()>0){
					
					Calculator tempc = new Calculator();
					tempc.pushNumber(new Double(s.toString()));
					tempc.pushOperation((Operation_1)(op.newInstance()));
					numberInput.setText(new Double(tempc.getResult()).toString());
					s = new StringBuilder(numberInput.getText());
				} else {
					calc.pushOperation((Operation_1)(op.newInstance()));
					s = new StringBuilder();
					numberInput.setText(new Double(calc.getResult()).toString());
				}
			} else if(expectNumber){
				s = new StringBuilder(op.newInstance().calc().toString());
				numberInput.setText(s.toString());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void equalsButton(){
		if(expectNumber){
			calc.pushNumber(new Double(s.toString()));
			s = new StringBuilder();
			numberInput.setText(new Double(calc.getResult()).toString());
			expectNumber = false;
		}
	}
}
