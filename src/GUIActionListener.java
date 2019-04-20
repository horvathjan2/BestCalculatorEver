import java.awt.event.ActionListener;

public abstract class GUIActionListener implements ActionListener{
	
	private GUI gui;
	
	public GUIActionListener(GUI g){
		gui = g;
	}
	
	protected GUI getGUI(){
		return gui;
	}
}
