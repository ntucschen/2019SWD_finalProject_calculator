
public class NegButton extends GUIButton{
	
	protected NegButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label, GUIstate, x, y, w, h);
	}
	
	protected void operator(String label, GUIstate GUIstate) {
		String str = GUIstate.getdisplayA();
		String prev = "";
		String inputB;
		if (GUIstate.getisInputB()) {
			prev = str.substring(0, str.lastIndexOf(" ")+1);
			inputB = str.substring(str.lastIndexOf(" ")+1);
		} else {
			inputB = str;
		}
		
		int index = inputB.indexOf("-");
		if (index == -1) {
			inputB = "-" + inputB;
		} else if (index == 0) {
			inputB = inputB.substring(index+1);
		}
		
		GUIstate.setdisplayA(prev + inputB);
	}

}


