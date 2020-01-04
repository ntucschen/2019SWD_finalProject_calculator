

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Button extends JButton{
	protected String label;
	protected GUIstate GUIstate;
	protected Button(String label, GUIstate GUIstate, 
					 int x, int y, int w, int h) {
		super(label);
		super.setBounds(x, y, w, h);
		this.GUIstate = GUIstate;
		super.addActionListener(new opActionListener());
	}
	

	public class opActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
	    }
	}
}
