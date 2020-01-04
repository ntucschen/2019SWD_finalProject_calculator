public class CLROpButton extends GUIButton{
	
	protected CLROpButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label, GUIstate, x, y, w, h);
	}
	
	protected void operator(String label, GUIstate GUIstate) {
		GUIstate.setdisplayA("");
        GUIstate.setisInputB(false);
        GUIstate.setisAdding(false);
        GUIstate.setisSubtracting(false);
        GUIstate.setisDividing(false);
        GUIstate.setisMultiplying(false);
        return;
	}

}


