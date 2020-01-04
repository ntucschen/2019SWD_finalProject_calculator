
public class PIButton extends GUIButton{
	
	protected PIButton(String label, GUIstate GUIstate, 
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
		
		inputB = Double.toString(Math.PI);

		GUIstate.setdisplayA(prev + inputB);
	}

}


