import java.awt.event.ActionEvent;

public class OperationInputActionListener extends GUIActionListener{
	
	private Class<Operation> op;
	
	public OperationInputActionListener(GUI g, Class<Operation> op){
		super(g);
		this.op=op;
	}
	
	public void actionPerformed(ActionEvent e){
		getGUI().pushOperation(op);
	}
}
