import java.util.function.Function;

public class OtherOpButton extends GUIButton{
	protected Function<Double, Double> func;
	protected OtherOpButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h, Function<Double, Double> func) {
		super(label, GUIstate, x, y, w, h);
		this.func = func;
	}
	
	protected void operator(String label, GUIstate GUIstate) {
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
		result = func.apply(inputB);
		GUIstate.setdisplayA(prestr + Double.toString(result));
	}

}


