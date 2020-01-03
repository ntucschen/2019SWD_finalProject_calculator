import javax.swing.JButton;

public abstract class NumberButton extends JButton{
	protected NumberButton(String label) {
		super(label);
	}
	
	protected void setBtnPosition(int x, int y ,int w, int h) {
		super.setBounds(x, y, w, h);
	}
//	public NumberButton(String label, int x, int y, int w, int h) {
//        super(label);
//        super.setBounds(x, y, w, h);
//    }
	
}
