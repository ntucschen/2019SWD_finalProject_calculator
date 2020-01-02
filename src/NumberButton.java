import javax.swing.JButton;

public class NumberButton extends JButton{
	public NumberButton(String label, int x, int y, int w, int h) {
        super(label);
        super.setBounds(x, y, w, h);
    }
}
