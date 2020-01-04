import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class GUIButton extends JButton{
	protected String label;
	protected GUIstate GUIstate;
	protected GUIButton(String label, GUIstate GUIstate, 
					 int x, int y, int w, int h) {
		super(label);
		super.setBounds(x, y, w, h);
		this.label = label;
		this.GUIstate = GUIstate;
		super.addActionListener(new opActionListener());
	}
	
	public class opActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			operator(label, GUIstate);
	    }
	}
	
	protected abstract void operator(String label, GUIstate GUIstate);
}
