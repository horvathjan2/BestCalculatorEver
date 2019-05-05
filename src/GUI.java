import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Stack;
 /**
  * 
  * @author Horváth János
  *
  *GUI of the application. Forwards user input to a Calculator object. Displays results
  */
public class GUI {
	/**
	 * frame containing buttons, and JLabel to show results 
	 */
	private JFrame window;
	/**
	 * displays either the number entered by the user, or the result of the calculation
	 */
	private JLabel numberInput;
	/**
	 * stores digits entered by the user
	 */
	private StringBuilder s;
	/**
	 * calculator object handling most of the operations
	 */
	private Calculator calc;
	/**
	 * keeps track of whether the user is able to enter a new number or not
	 */
	private boolean expectNumber;
	
	/**
	 * Holds information from outside of the current bracket
	 */
	private Stack<Calculator> bracketStack;
	
	/**
	 * Creates a JFrame and fills it with the necessary components. Prepares Calculator object.
	 * 
	 * @param operations all operations available
	 */
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
		bracketStack = new Stack<>();
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				Integer label = new Integer(j*3+i+1);
				b = new JButton(label.toString());
				b.addActionListener(e -> pushChar(label.toString().charAt(0)));
				c.gridx=i;
				c.gridy=4-j;
				window.add(b, c);
			}
		}
		
		
		b = new JButton("0");
		b.addActionListener(e -> pushChar('0'));
		c.gridy=5;
		c.gridx=0;
		window.add(b, c);
		
		b = new JButton(".");
		b.addActionListener(e -> pushChar('.'));
		c.gridy=5;
		c.gridx=1;
		window.add(b, c);
		
		
		b=new JButton("=");
		b.addActionListener(e -> equalsButton());
		c.gridx=2;
		window.add(b, c);
		
		b = new JButton("C");
		b.addActionListener(e -> clear());
		c.gridx=0;
		c.gridy=1;
		window.add(b, c);
		
		b = new JButton("(");
		b.addActionListener(e -> bracketPush());
		c.gridx=1;
		window.add(b,c);
		
		b = new JButton(")");
		b.addActionListener(e -> bracketPop());
		c.gridx=2;
		window.add(b,c);
		
		for(int i=0; i<operations.size(); i++){
			try{
				int li = i;
				b = new JButton(((Operation_0)(operations.get(i).newInstance())).getSymbol());
				b.addActionListener(e -> pushOperation(operations.get(li)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			c.gridy = 1 + i%5;
			c.gridx = 4 + i/5;
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
	
	/**
	 * Appends a new character to the end of the number input. Drops digits entered when no number input is expected.
	 * @param c character to append
	 */
	private void pushChar(char c){
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
			}
		} else {
			clear();
			if(c == '.'){
				s.append(c);
			} else if(c != '0'){
				s.setCharAt(0, c);
			}
		}
		numberInput.setText(s.toString());
	}
	
	/**
	 * Processes operations entered by the user. Sorts them by number of operands expected.
	 * Supplies double operand operations are to the main calculator object.
	 * Applies single operand operations either to the current number input, or the result of previous calculations.
	 * Handles constants as number input.
	 * @param op operation to process
	 */
	private void pushOperation(Class<Operation_0> op){
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
	
	/**
	 * Ends current number input and supplies it to the calculator object
	 */
	private void equalsButton(){
		if(s.toString().length()>0){
			calc.pushNumber(new Double(s.toString()));
			s = new StringBuilder();
			numberInput.setText(new Double(calc.getResult()).toString());
			expectNumber = false;
		}
	}
	
	/**
	 * Clears the calculator
	 */
	private void clear(){
		calc.clear();
		numberInput.setText("0");
		s = new StringBuilder("0");
		expectNumber = true;
		bracketStack = new Stack<>();
	}
	
	/**
	 * Opens a new bracket
	 */
	private void bracketPush(){
		if(expectNumber){
			bracketStack.push(calc);
			calc = new Calculator();
			numberInput.setText("0");
			s = new StringBuilder("0");
			expectNumber = true;
		}
	}
	
	/**
	 * Closes the most recently closed bracket
	 */
	private void bracketPop(){
		if(bracketStack.size()>0){
			equalsButton();
			String num = new Double(calc.getResult()).toString();
			calc = bracketStack.pop();
			expectNumber = true;
			s = new StringBuilder(num);
			numberInput.setText(num);
			expectNumber = true;
		}
		
	}
}
