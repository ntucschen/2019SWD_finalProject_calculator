import javax.swing.JTextField;

public class GUIstate {
	protected String displayA;
	protected JTextField numDisplay;
	
	protected GUIstate(JTextField numDisplay){
		displayA = "";
		this.numDisplay = numDisplay;
		
	}
	
	public void display() {
		numDisplay.setText(displayA);
	}
	
	public void addDisplayA(String addstr) {
		displayA = displayA + addstr;
		display();
	}
	
	public String getDisplayA() {
		return displayA;
	}
}
