import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton{
	
	protected String displayA;
	protected GUIstate GUIstate;
	protected NumberButton(String label, GUIstate GUIstate, 
						   int x, int y, int w, int h) {
		super(label);
		super.setBounds(x, y, w, h);
		this.GUIstate = GUIstate;
		super.addActionListener(new ActionListener() { //增加exception來提醒是哪裡錯 少什麼？
			public void actionPerformed(ActionEvent e) {
		        displayA = label;
		        GUIstate.addDisplayA(label);
		        System.out.printf(GUIstate.getDisplayA());
		      }
		    });
	}
	
//	protected void setDisplayA(String displayA) {
//		displayA = displayA;
//	}


	/*
	     zero.addActionListener(new ActionListener() { //增加exception來提醒是哪裡錯 少什麼？
      public void actionPerformed(ActionEvent e) {
        displayA = displayA + "0";
        numDisplay.setText(displayA);
      }
    });

	 */
	
//	public NumberButton(String label, int x, int y, int w, int h) {
//        super(label);
//        super.setBounds(x, y, w, h);
//    }
	
}
