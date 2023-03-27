package mon_calculatrice;
import java.awt.*;
import java.awt.event.*;
public class MyCalculator extends Frame implements ActionListener {
	TextField tf;
	 Panel panel;
	 String btnString[]={"7", "8","9","+",
	                    "4","5","6","-",
	                    "1","2","3","*",
	                    "C","0","=","/"};
	Button btn[]=new Button[16];
	int num1 =0,num2=0,result=0;
	char op;
	public MyCalculator() {
		// TODO Auto-generated constructor stub
		tf=new TextField(10);
		 panel=new Panel();
		add (tf,"North");
		add(panel, "Center");
		panel.setLayout(new GridLayout(4,4));
		for(int i=0; i<16; i++) {
		btn[i] =new Button (btnString[i]);
		btn[i].addActionListener(this);
		panel.add(btn[i]) ;
		}
		
		//--------------------Closing-------------------------------------//
		addWindowListener(new WindowAdapter (){ 
			public void windowClosing(WindowEvent e ) {
				System.exit(0);
			}
			});
		}
	 //---------------------------------------------------------------------//
	public void actionPerformed(ActionEvent ae) { 
		String str= ae.getActionCommand();
		if(str.equals("+")) {
			op='+';
			num1=Integer.parseInt(tf.getText()); 
			tf.setText("");
		}
		else if (str.equals("-")) {
			op='-';
			num1=Integer.parseInt(tf.getText()); 
			tf.setText("");
		}
		else if (str.equals("*")) {
			op='*';
			num1=Integer.parseInt(tf.getText()); 
			tf.setText("");
		}
		else if (str.equals("/")) {
			op='/';
			num1=Integer.parseInt(tf.getText()); 
			tf.setText("");
		}
		else if (str.equals("=")) {
			num2=Integer.parseInt(tf.getText()); 
			switch(op) { 
				case '+': result=num1+num2;
				break ; 
				case '-': result=num1-num2;
				break ; 
				case '*': result=num1*num2;
				break ; 
				case '/': result=num1/num2;
				break ; 
		
				
			}
			tf.setText(result+""); 
			result=0; 
		}
		
		else if ( str.equals("C")) { 
			tf.setText(""); 
			num1=num2=result=0; 
		}
		else { 
			tf.setText(tf.getText()+str); 
		}
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalculator mc=new MyCalculator();
		mc.setTitle("Calculatrice"); 
		mc.setSize(250,300);
		mc.setVisible(true);

	}

}
