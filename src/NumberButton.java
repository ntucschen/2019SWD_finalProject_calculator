import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton{
	
	protected GUIstate GUIstate;
	protected NumberButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label);
		super.setBounds(x, y, w, h);
		this.GUIstate = GUIstate;
		super.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        GUIstate.adddisplayA(label);
		        System.out.printf(GUIstate.getdisplayA());
		      }
		    });
	}
	
}
