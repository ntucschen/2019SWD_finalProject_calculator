import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends JButton{
	
	protected GUIstate GUIstate;
	protected OperatorButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label);
		super.setBounds(x, y, w, h);
		this.GUIstate = GUIstate;
		super.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// for CLR
				if (label == "CLR") {
					GUIstate.setdisplayA("");
			        GUIstate.setisInputB(false);
			        GUIstate.setisAdding(false);
			        GUIstate.setisSubtracting(false);
			        GUIstate.setisDividing(false);
			        GUIstate.setisMultiplying(false);
			        GUIstate.setdotExists(false);
			        return;
				}

				// for Enter
				if (label == "Enter") {
					String str = GUIstate.getdisplayA();
					Double result = null;
		            if (GUIstate.getisInputB()) {
		            	GUIstate.setinputA(Double.parseDouble(str.substring(0, str.indexOf(" "))));
		            	GUIstate.setinputB(Double.parseDouble(str.substring(str.lastIndexOf(" ")+1)));
		            }
		            if (GUIstate.getisAdding()) {
		            	result = GUIstate.getinputA() + GUIstate.getinputB();
		            }
		            if (GUIstate.getisSubtracting()) {
		            	result = GUIstate.getinputA() - GUIstate.getinputB();
		            }
		            if (GUIstate.getisMultiplying()) {
		            	result = GUIstate.getinputA() * GUIstate.getinputB();
		            }
		            if (GUIstate.getisDividing()) {
		            	result = GUIstate.getinputA() / GUIstate.getinputB();
		          	}

		          	if (result != null) {
		          		GUIstate.setoutput(str + " = " + Double.toString(result));	
		          	}
					return;
				}

				// for +, -, x, /
				if (label == "+" || label == "-" || label == "x" || label == "/")
		        if (!GUIstate.getisInputB()) {
		        	GUIstate.adddisplayA(" " + label + " ");
	        		switch(label) 
	                { 
	                    case "+": 
	                    	GUIstate.setisAdding(true);
	                        break; 
	                    case "-": 
	                    	GUIstate.setisSubtracting(true);
	                        break; 
	                    case "*": 
	                    	GUIstate.setisMultiplying(true);
	                        break; 
	                    case "/": 
	                    	GUIstate.setisDividing(true);
	                        break; 
	                    default: 
	                        System.out.println("no match"); 
	                } 
		        	GUIstate.setisInputB(true);
		        	GUIstate.setdotExists(false);
		          }
		      }
		    });
	}
	
}
