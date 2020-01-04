public class NumberButton extends GUIButton{
	
	protected NumberButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label, GUIstate, x, y, w, h);
	}
	
	protected void operator(String label, GUIstate GUIstate) {
		GUIstate.adddisplayA(label);
	}

}


