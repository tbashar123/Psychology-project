package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProjectJFrame extends JFrame{
	
	public ProjectJFrame(){
		
		Project1 jp = new Project1();
		add(jp);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(720,560);
		setVisible(true);
		
	}
	

}
