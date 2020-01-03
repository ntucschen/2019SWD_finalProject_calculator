// package calculatorGUI;

//GCI19 - Task: Java Calculator GUI - Carlo Dino
//warning: spaghetti code alert - my first time running with JFrame for anything, honestly

//TODO: 加exception
// 分class
// de coupling 拔掉任何一個案件 -> 會壞掉
// 加減乘除順序問題 -> 先忽略？

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.BorderLayout;

@SuppressWarnings("serial") // TODO: 這是什麼？ 或許可以用exception ??
public class CalculatorGUI extends JFrame { // constructor -> TODO: 把constractor補齊

  private JFrame GUI; // TODO 變數都沒有設private/public
  
  private JButton Enter;
  private JButton CLR;
  private JButton one;
  private JButton two;
  private JButton three;
  private JButton four;
  private JButton five;
  private JButton six;
  private JButton seven;
  private JButton eight;
  private JButton nine;
  //private JButton zero;
  private JButton pi;

  //operations

  private JButton dot;
  private boolean dotExists = false;
  private JButton neg;
  private boolean negExists = false;
  private JButton square;
  private boolean isSquared = false;
  private JButton squareRoot;
  private boolean isRooted = false;
  
  private JButton add;
  private boolean isAdding = false;
  private JButton subtract;
  private boolean isSubtracting = false;
  private JButton multiply;
  private boolean isMultiplying = false;
  private JButton divide;
  private boolean isDividing = false;
  
  private JButton toFrac;
  private boolean isFrac = false;
  private JButton toLog10;
  private JButton toLogE;
  private boolean isLog = false;
  
  private JButton sin;
  private JButton cos;
  private JButton tan;
  private JButton sec;
  private JButton csc;
  private JButton cot;
  private boolean trigExists = false;
  
  private JTextField numDisplay;

  private boolean isInputB = false;
  private double inputA;
  private double inputB;
  private String displayA = "";
  private String output;

  public CalculatorGUI() { //TODO: 沒有設權限
	  
    GUI = new JFrame("CalculatorGUI"); 
    JPanel panel = new JPanel(new FlowLayout()); 
    numDisplay = new JTextField();
    numDisplay.setBounds(40, 25, 300, 75);
    numDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
    numDisplay.setEditable(false);
    GUI.add(numDisplay);
    
    Enter = new JButton("Enter");
    Enter.setBounds(275,410,100, 40); //x axis, y axis, width, height  
    Enter.addActionListener(new ActionListener() {  //監聽
        public void actionPerformed(ActionEvent e) {
          if (isInputB) {
            inputA = Double.parseDouble(displayA.substring(0,displayA.indexOf(" ")));
            inputB = Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")+1));
            if (isAdding) {
              output = displayA + " = " + Double.toString(inputA + inputB);
              numDisplay.setText(output);
            }
            if (isSubtracting) {
              output = displayA + " = " + Double.toString(inputA - inputB);
              numDisplay.setText(output);
            }
            if (isMultiplying) {
              output = displayA + " = " + Double.toString(inputA * inputB);
              numDisplay.setText(output);
            }
            if (isDividing) {
              output = displayA + " = " + Double.toString(inputA / inputB);
              numDisplay.setText(output);
            }
            System.out.println(output); //remove later
          } 
        }
      }); 
    GUI.add(Enter);
  
    add = new JButton("+");
    add.setBounds(275,365,100,40);
    add.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        if (!isInputB) {
          displayA = displayA + " + ";
    		  isAdding = true;
          isInputB = true;
          dotExists = false;
          numDisplay.setText(displayA);
        }
    	}
    });
    GUI.add(add); //TODO: 做許多次同樣的事， 有沒有辦法包成class
    
    subtract = new JButton("-");
    subtract.setBounds(275,320,100,40);
    subtract.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        if (!isInputB) {
          displayA = displayA + " - ";
    		  isSubtracting = true;
          isInputB = true;
          dotExists = false;
          numDisplay.setText(displayA);
        }
    	}
    });
    GUI.add(subtract);
    
    multiply = new JButton("x");
    multiply.setBounds(275,275,100,40);
    multiply.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        if (!isInputB) {
          displayA = displayA + " * ";
    		  isMultiplying = true;
          isInputB = true;
          dotExists = false;
          numDisplay.setText(displayA);
        }
    	}
    });
    GUI.add(multiply);
    
    divide = new JButton("/");
    divide.setBounds(275,230,100,40);
    divide.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
        if (!isInputB) {
          displayA = displayA + " / ";
    		  isDividing = true;
          isInputB = true;
          dotExists = false;
          numDisplay.setText(displayA);
        }
    	}
    });
    GUI.add(divide);

    CLR = new JButton("CLR");
    CLR.setBounds(275,185,100,40);
    CLR.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        displayA = "";
        isInputB = false;
        isAdding = false;
        isSubtracting = false;
        isDividing = false;
        isMultiplying = false;
        dotExists = false;
        numDisplay.setText(displayA);
      }
    });
    GUI.add(CLR);
    
    // == numbers == //
    // 0 - 3 //
    
    /*
    TODO 要使用 abstractor/interface/constractor ?
    增加interface ?
    */
    
    Zero zero = new Zero();
//    zero.addActionListener(new ActionListener() { //增加exception來提醒是哪裡錯 少什麼？
//      public void actionPerformed(ActionEvent e) {
//        displayA = displayA + "0";
//        numDisplay.setText(displayA);
//      }
//    });
    

    displayA = displayA + zero.getDisplayA(); //bug: 沒有listen 且變成直接run -> 所以無法將值傳出來
    numDisplay.setText(displayA);
    GUI.add(zero);    
    
    one = new JButton("1");
    one.setBounds(100, 365, 45, 40);
    one.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "1";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(one);
    
    two = new JButton("2");
    two.setBounds(150, 365, 45, 40);
    two.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "2";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(two);
    
    three = new JButton("3");
    three.setBounds(200, 365, 45, 40);
    three.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "3";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(three);
    
    // 4 - 6 //
    
    four = new JButton("4");
    four.setBounds(100, 320, 45, 40);
    four.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "4";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(four);
    
    five = new JButton("5");
    five.setBounds(150, 320, 45, 40);
    five.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "5";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(five);
    
    six = new JButton("6");
    six.setBounds(200, 320, 45, 40);
    six.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "6";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(six);
    
    // 7 - 9 //
    
    seven = new JButton("7");
    seven.setBounds(100, 275, 45, 40);
    seven.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "7";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(seven);
    
    eight = new JButton("8");
    eight.setBounds(150, 275, 45, 40);
    eight.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "8";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(eight);
    
    nine = new JButton("9");
    nine.setBounds(200, 275, 45, 40);
    nine.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		displayA = displayA + "9";
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(nine);
    
    pi = new JButton("pi");
    pi.setBounds(25, 320, 55, 40);
    pi.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if (!isInputB) {
    			displayA = Double.toString(Math.PI);
    		} else if (isInputB) {
    			displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.PI);
    		}
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(pi);

    // operations //

    dot = new JButton(".");
    dot.setBounds(150, 410, 45, 40);
    dot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!dotExists) {
          displayA = displayA + ".";
          numDisplay.setText(displayA);
        }
      }
    });
    GUI.add(dot);

    neg = new JButton("N");
    neg.setBounds(200, 410, 45, 40);
    neg.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (!negExists) {
          if (!isInputB) {
            displayA = "-" + displayA;
          } else if (isInputB) {
            displayA = displayA.substring(0, displayA.lastIndexOf(" ")) + " -" + displayA.substring(displayA.lastIndexOf(" ")+1);
          }
        }
        numDisplay.setText(displayA);
      }
    });
    GUI.add(neg);

    square = new JButton("^2");
    square.setBounds(25, 410, 55, 40);
    square.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        double squareThis;
        if (!isSquared) {
          if (!isInputB) {
            squareThis = Double.parseDouble(displayA);
            squareThis = Math.pow(squareThis, 2);
            displayA =  Double.toString(squareThis);
          } else if (isInputB) {
            squareThis = Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")));
            squareThis = Math.pow(squareThis, 2);
            displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(squareThis);
          }
        }
        numDisplay.setText(displayA);
      }
    });
    GUI.add(square);
    
    squareRoot = new JButton("sqt");
    squareRoot.setBounds(25, 365, 55, 40);
    squareRoot.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		double squareRootThis;
    		if (!isRooted) {
    			if (!isInputB) {
    				squareRootThis = Double.parseDouble(displayA);
    				squareRootThis = Math.sqrt(squareRootThis);
    				displayA = Double.toString(squareRootThis);
    			} else if (isInputB) {
    				squareRootThis = Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")));
    				squareRootThis = Math.sqrt(squareRootThis);
    				displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(squareRootThis);
    			}
    		}
    		numDisplay.setText(displayA);
    	}
    });
    GUI.add(squareRoot);
    
   toFrac = new JButton("1/x");
   toFrac.setBounds(25, 275, 55, 40);
   toFrac.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   double fracThis;
		   if (!isFrac) {
			   if (!isInputB) {
				  fracThis = Double.parseDouble(displayA);
				  fracThis = (1/fracThis);
				  displayA = Double.toString(fracThis);
			   } else if (isInputB) {
				   fracThis = Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")+1));
				   fracThis = (1/fracThis);
				   displayA = displayA.substring(0, displayA.lastIndexOf(" ")) + Double.toString(fracThis);
			   }
		   }
		   numDisplay.setText(displayA);
	   } 
   });
   GUI.add(toFrac);
   
   toLogE = new JButton("ln");
   toLogE.setBounds(25, 230, 55, 40);
   toLogE.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isLog) {
			   if (!isInputB) {
				   displayA = Double.toString(Math.log(Double.parseDouble(displayA)));
			   } else if (isInputB) {
				   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.log(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
			   }
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(toLogE); 
   
   toLog10 = new JButton("log");
   toLog10.setBounds(25, 185, 55, 40);
   toLog10.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(Math.log10(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.log10(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(toLog10);
   
   sin = new JButton("sin");
   sin.setBounds(85, 185, 55, 40);
   sin.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(Math.sin(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.sin(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(sin);
   
   cos = new JButton("cos");
   cos.setBounds(150, 185, 55, 40);
   cos.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(Math.cos(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.cos(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(cos);
   
   tan = new JButton("tan");
   tan.setBounds(215, 185, 55, 40);
   tan.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(Math.tan(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(Math.tan(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(tan);
   
   sec = new JButton("sec");
   sec.setBounds(85, 230, 55, 40);
   sec.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(1/Math.cos(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(1/Math.cos(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(sec);
   
   csc = new JButton("csc");
   csc.setBounds(150, 230, 55, 40);
   csc.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(1/Math.sin(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(1/Math.sin(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(csc);
   
   cot = new JButton("cot");
   cot.setBounds(215, 230, 55, 40);
   cot.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
		   if (!isInputB) {
			   displayA = Double.toString(1/Math.tan(Double.parseDouble(displayA)));
		   } else if (isInputB) {
			   displayA = displayA.substring(0, displayA.lastIndexOf(" ")+1) + Double.toString(1/Math.tan(Double.parseDouble(displayA.substring(displayA.lastIndexOf(" ")))));
		   }
		   numDisplay.setText(displayA);
	   }
   });
   GUI.add(cot);
    
    JTextField name = new JTextField();
    name.setBounds(40, 110, 300, 25);
    name.setHorizontalAlignment(SwingConstants.LEFT);
    name.setEditable(false);
    name.setText("GCI-19: Java Calculator GUI || Carlo Dino");
    GUI.add(name);
    
    this.getContentPane().add(panel);
    GUI.setSize(400,500); 
    GUI.setLayout(null); 
    GUI.setVisible(true);  
    GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
	
  public static void main(String[] args) {  
    CalculatorGUI cal = new CalculatorGUI();
  }  

}