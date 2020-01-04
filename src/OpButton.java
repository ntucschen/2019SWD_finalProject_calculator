
public class OpButton extends GUIButton{
	
	protected OpButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label, GUIstate, x, y, w, h);
	}
	
	protected void operator(String label, GUIstate GUIstate) {
        if (!GUIstate.getisInputB()) {
        	GUIstate.adddisplayA(" " + label + " ");
        	GUIstate.setop(label);
        	GUIstate.setisInputB(true);
        }
	}

}


