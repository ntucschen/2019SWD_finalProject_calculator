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
				System.out.printf("label = " + label + "\n");
				// for CLR
				if (label == "CLR") {
					GUIstate.setdisplayA("");
			        GUIstate.setisInputB(false);
			        GUIstate.setisAdding(false);
			        GUIstate.setisSubtracting(false);
			        GUIstate.setisDividing(false);
			        GUIstate.setisMultiplying(false);
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

				// ., N, pi
				if (label == "." || label == "N" || label == "pi") {
					String str = GUIstate.getdisplayA();
					String prev = "";
					String inputB;
					if (GUIstate.getisInputB()) {
						prev = str.substring(0, str.lastIndexOf(" ")+1);
						inputB = str.substring(str.lastIndexOf(" ")+1);
					} else {
						inputB = str;
					}
					switch(label)
					{
						case ".":
							if (inputB.indexOf(".") == -1) {
								inputB = inputB + ".";
							}
							break;
						case "N":
							int index = inputB.indexOf("-");
							if (index == -1) {
								inputB = "-" + inputB;
							} else if (index == 0) {
								inputB = inputB.substring(index+1);
							}
							break;
						case "pi":
							inputB = Double.toString(Math.PI);

						default:
							// do nothing
					}
					
					GUIstate.setdisplayA(prev + inputB);
				}

				// for +, -, x, /
				if (label == "+" || label == "-" || label == "x" || label == "/"){
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
		                    case "x": 
		                    	GUIstate.setisMultiplying(true);
		                        break; 
		                    case "/": 
		                    	GUIstate.setisDividing(true);
		                        break; 
		                    default: 
		                        System.out.println("no match"); 
		                } 
			        	GUIstate.setisInputB(true);
			        }
			    }

			    // for sin, cos, tan, sec, csc, cot
			    // for log, ln, sqt, 1/x, ^2
			    if (label == "sin" || label == "cos" || label == "tan" ||
			    	label == "sec" || label == "csc" || label == "cot" ||
			    	label == "log" || label == "ln"  || label == "sqt" ||
			    	label == "1/x" || label == "^2" ){
			    	String str = GUIstate.getdisplayA();
			    	String prestr = "";
			    	String value = "";
					if (!GUIstate.getisInputB()) {
						value = str;
					} else {
						prestr = str.substring(0, str.lastIndexOf(" ")+1);
						value = str.substring(str.lastIndexOf(" "));
					}
					Double inputB = Double.parseDouble(value);
					Double result = inputB;
					switch (label) {
	                    case "sin":
	                    	result = Math.sin(inputB);
	                        break;
	                    case "cos":
	                    	result = Math.cos(inputB);
	                        break;
	                    case "tan":
	                    	result = Math.tan(inputB);
	                        break;
	                    case "sec":
	                    	result = 1/Math.cos(inputB);
	                        break;
	                    case "csc":
	                    	result = 1/Math.sin(inputB);
	                    	break;
	                    case "cot":
	                    	result = 1/Math.tan(inputB);
	                    	break;
	                    case "log":
	                    	result = Math.log10(inputB);
	                    	break;
	                    case "ln":
	                    	result = Math.log(inputB);
	                    	break;
	                    case "sqt":
	                    	result = Math.sqrt(inputB);
	                    	break;
	                    case "1/x":
	                    	result = 1/inputB;
	                    	break;
	                    case "^2":
	                    	result = Math.pow(inputB, 2);
	                    	break;
	                    default:
	                        System.out.println("no match\n"); 
						
					}
					GUIstate.setdisplayA(prestr + Double.toString(result));
			    }

		      }


		    });
	}
	
}
