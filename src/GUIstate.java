import javax.swing.JTextField;

public class GUIstate {
	protected JTextField numDisplay;
	  
	protected boolean isAdding;
	protected boolean isSubtracting;
	protected boolean isMultiplying;
	protected boolean isDividing;
	
	protected boolean isInputB;
	protected double inputA;
	protected double inputB;
	protected String displayA;
	protected String output;
	
	protected GUIstate(JTextField numDisplay){
		this.numDisplay = numDisplay;
	  
		isAdding = false;
		isSubtracting = false;
		isMultiplying = false;
		isDividing = false;

		isInputB = false;
		inputA = 0.0;
		inputB = 0.0;
		displayA = "";
		output = "";
	}
	
	public void display() {
		numDisplay.setText(displayA);
	}

	public void displayoutput() {
		numDisplay.setText(output);
	}
	
	public void adddisplayA(String addstr) {
		displayA = displayA + addstr;
		display();
	}
	
	public String getdisplayA() {
		return displayA;
	}

	public void setdisplayA(String str) {
		displayA = str;
		display();
	}

	public String getoutput(){
		return output;
	}

	public void setoutput(String str) {
		output = str;
		displayoutput();
	}

	public Boolean getisInputB(){
		return isInputB;
	}

	public void setisInputB(Boolean val){
		isInputB = val;
	}

	public double getinputA(){
		return inputA;
	}

	public void setinputA(double val){
		inputA = val;
	}

	public double getinputB(){
		return inputB;
	}

	public void setinputB(double val){
		inputB = val;
	}	

	public Boolean getisAdding() {
		return isAdding;
	}
	
	public void setisAdding(Boolean val) {
		isAdding = val;
	}
	
	public Boolean getisSubtracting() {
		return isSubtracting;
	}
	
	public void setisSubtracting(Boolean val) {
		isSubtracting = val;
	}
	
	public Boolean getisMultiplying() {
		return isMultiplying;
	}
	
	public void setisMultiplying(Boolean val) {
		isMultiplying = val;
	}
	
	public Boolean getisDividing() {
		return isDividing;
	}
	
	public void setisDividing(Boolean val) {
		isDividing = val;
	}
}
