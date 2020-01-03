import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class NumberButton extends JButton{
	
	protected String displayA;
	protected NumberButton(String label) {
		super(label);
		super.addActionListener(new ActionListener() { //增加exception來提醒是哪裡錯 少什麼？
		      public void actionPerformed(ActionEvent e) {
		        displayA = label;
		        System.out.printf(displayA);
//		        numDisplay.setText(displayA);
		      }
		    });
		displayA = "" ;
	}
	
	protected void setBtnPosition(int x, int y ,int w, int h) {
		super.setBounds(x, y, w, h);
	}
	protected String getDisplayA() {
		return displayA;
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
