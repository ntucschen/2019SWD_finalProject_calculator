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
  private GUIstate GUIstate;
  
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
  private JButton zero;
  private JButton pi;

  //operations

  private JButton dot;
  private JButton neg;
  private JButton square;
  private JButton squareRoot;
  
  private JButton add;
  private JButton subtract;
  private JButton multiply;
  private JButton divide;
  
  private JButton toFrac;
  private JButton toLog10;
  private JButton toLogE;
  
  private JButton sin;
  private JButton cos;
  private JButton tan;
  private JButton sec;
  private JButton csc;
  private JButton cot;
  
  private JTextField numDisplay;

  public CalculatorGUI() { //TODO: 沒有設權限
	  
    GUI = new JFrame("CalculatorGUI"); 
    JPanel panel = new JPanel(new FlowLayout()); 
    numDisplay = new JTextField();
    numDisplay.setBounds(40, 25, 300, 75);
    numDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
    numDisplay.setEditable(false);
    
    GUIstate = new GUIstate(numDisplay);
    GUI.add(numDisplay);
    
    Enter = new EnterOpButton("Enter", GUIstate, 275, 410, 100, 40);
    GUI.add(Enter);
  
    add = new OpButton("+", GUIstate, 275, 365, 100, 40);
    GUI.add(add);
    
    subtract = new OpButton("-", GUIstate, 275, 320, 100, 40);
    GUI.add(subtract);

    multiply = new OpButton("x", GUIstate, 275, 275, 100, 40);
    GUI.add(multiply);

    divide = new OpButton("/", GUIstate, 275, 230, 100, 40);
    GUI.add(divide);

    CLR = new CLROpButton("CLR", GUIstate, 275, 185, 100, 40);
    GUI.add(CLR);
    
    // == numbers == //
    // 0 - 3 //
    
    zero = new NumberButton("0", GUIstate, 100, 410, 45, 40);
    GUI.add(zero);    
    
    one = new NumberButton("1", GUIstate, 100, 365, 45, 40);
    GUI.add(one);
    
    two = new NumberButton("2", GUIstate, 150, 365, 45, 40);
    GUI.add(two);

    three = new NumberButton("3", GUIstate, 200, 365, 45, 40);
    GUI.add(three);
    
    // 4 - 6 //

    four = new NumberButton("4", GUIstate, 100, 320, 45, 40);
    GUI.add(four);

    five = new NumberButton("5", GUIstate, 150, 320, 45, 40);
    GUI.add(five);
    
    six = new NumberButton("6", GUIstate, 200, 320, 45, 40);
    GUI.add(six);
    
    // 7 - 9 //

    seven = new NumberButton("7", GUIstate, 100, 275, 45, 40);
    GUI.add(seven);
    
    eight = new NumberButton("8", GUIstate, 150, 275, 45, 40);
    GUI.add(eight);
    
    nine = new NumberButton("9", GUIstate, 200, 275, 45, 40);
    GUI.add(nine);
    

    // operations //

    pi = new PIButton("pi", GUIstate, 25, 320, 55, 40);
    GUI.add(pi);

    dot = new DotButton(".", GUIstate, 150, 410, 45, 40);
    GUI.add(dot);

    neg = new NegButton("N", GUIstate, 200, 410, 45, 40);
    GUI.add(neg);

    square = new OtherOpButton("^2", GUIstate, 25, 410, 55, 40, x -> x * x);
    GUI.add(square);
    
    squareRoot = new OtherOpButton("sqt", GUIstate, 25, 365, 55, 40, x -> Math.sqrt(x));
    GUI.add(squareRoot);
    
    toFrac = new OtherOpButton("1/x", GUIstate, 25, 275, 55, 40, x -> 1 / x);
    GUI.add(toFrac);

    toLogE = new OtherOpButton("ln", GUIstate, 25, 230, 55, 40, x -> Math.log(x));
    GUI.add(toLogE); 

    toLog10 = new OtherOpButton("log", GUIstate, 25, 185, 55, 40, x -> Math.log10(x));
    GUI.add(toLog10);

    sin = new OtherOpButton("sin", GUIstate, 85, 185, 55, 40, x -> Math.sin(x));
    GUI.add(sin);

    cos = new OtherOpButton("cos", GUIstate, 150, 185, 55, 40, x -> Math.cos(x));
    GUI.add(cos);

    tan = new OtherOpButton("tan", GUIstate, 215, 185, 55, 40, x -> Math.tan(x));
    GUI.add(tan);

    sec = new OtherOpButton("sec", GUIstate, 85, 230, 55, 40, x -> 1/Math.cos(x));
    GUI.add(sec);

    csc = new OtherOpButton("csc", GUIstate, 150, 230, 55, 40, x -> 1/Math.sin(x));
    GUI.add(csc);

    cot = new OtherOpButton("cot", GUIstate, 215, 230, 55, 40, x -> 1/Math.tan(x));
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