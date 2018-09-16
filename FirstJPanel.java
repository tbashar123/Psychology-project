package Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstJPanel extends JPanel implements ActionListener {
	
	//we will put our components here
	private JLabel lblOut;
	private JTextField jtf1;
	private JTextField jtf2;
	
	private JButton btnAdd;      
	private JButton btnSub;
	private JButton btnDiv;
	private JButton btnMult;
	private JButton btnExp;
	
	
	public FirstJPanel(){
		setLayout(new GridLayout(6,1));
		lblOut = new JLabel("Hi Everyone can you see me?");
		jtf1 = new JTextField("num1", 10);
		jtf2 = new JTextField("num2 please", 10);
		
		add(lblOut);//stick it to the JPanel by adding it
		JPanel tfPanel = new JPanel();
		tfPanel.setLayout(new GridLayout(1,2));
		tfPanel.add(jtf1);
		tfPanel.add(jtf2);
		add(tfPanel);//add the inner panel with its textfields to the FirstJPanel
		
		btnAdd= new JButton(" + ");
		btnSub= new JButton(" - ");
		btnDiv= new JButton(" / ");
		btnMult= new JButton(" * ");
		btnExp= new JButton(" ^ ");
		
		btnAdd.addActionListener(this);//made the component listen for actions
		btnSub.addActionListener(this);//made the component listen for actions
		btnDiv.addActionListener(this);//made the component listen for actions
		btnMult.addActionListener(this);
		btnExp.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1, 4));
		btnPanel.add(btnAdd);
		btnPanel.add(btnSub);
		btnPanel.add(btnDiv);
		btnPanel.add(btnMult);
		btnPanel.add(btnExp);
		add(btnPanel);
	}

    public int getIntFromTextField(JTextField jtf) throws Exception{
    	int num = -99999999;
        try{
        	num = Integer.parseInt(jtf1.getText());
    }
    catch(Exception e){
    	throw new Exception("Invalid input"+ e.getMessage());
    	
    }
    return num;
    }
    
//write a method ...public double getDoubleFromTextField(JTextField jtf) throws Exception{//}
    //rewrite to overload all the add,sub,div,mult methods as double
    
	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		int num1 = Integer.parseInt(jtf1.getText());
		int num2 = Integer.parseInt(jtf2.getText());
		int solution = -99999999;
		lblOut.setText("the button clicked was" + actCmd);
		switch(actCmd){
		case " + ":
			solution = num1 + num2;
			//add was clicked perform add
			break;
		case " - ":
			solution = num1 - num2;
			//sub was clicked perform sub
			break;
		case " / ":
			solution = num1 / num2; //what about num2 zero????
			//div was clicked perform dib
			break;
		case " * ":
			solution = num1 * num2;
			//add was clicked perform add
			break;
		case " ^ ":
			solution = num1^num2;
		default:
			System.out.println("we built a nutty gui");
		}
		lblOut.setText(num1 +" "+actCmd+" "+ num2 + " = "+ solution);//display result
		
		// TODO Auto-generated method stub
		
	}

}
