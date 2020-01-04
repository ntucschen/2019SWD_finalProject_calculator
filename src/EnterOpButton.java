public class EnterOpButton extends GUIButton{
	
	protected EnterOpButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label, GUIstate, x, y, w, h);
	}
	
	protected void operator(String label, GUIstate GUIstate) {

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

}


