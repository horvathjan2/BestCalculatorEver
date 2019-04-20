import java.awt.event.ActionEvent;

public class NumberInputActionListener extends GUIActionListener{
	
	private char c;
	
	public NumberInputActionListener(GUI g, char c){
		super(g);
		this.c=c;
	}
	
	public void actionPerformed(ActionEvent e){
		getGUI().pushChar(c);
	}
	
}
