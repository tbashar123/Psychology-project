package Gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Project1 extends JPanel implements ActionListener {
	private JLabel ques;
	private JLabel longestWord;
	private JTextField response;
	private JButton submitButton;
	private JButton logrequest;
	private JLabel loglocation;
	private JButton read;
	private JTextArea jt;
	
	
	public Project1(){
		
		ques = new JLabel("Hello, What is on your mind today fellow user?");
		longestWord = new JLabel();
		response = new JTextField("Type here",10);
		submitButton = new JButton("Submit");
		logrequest = new JButton("Request log");
		loglocation = new JLabel();
		read = new JButton("Read Text File");
		jt = new JTextArea(10,40);
		
		add(ques);
		add(longestWord);
		add(response);
		add(submitButton);
		add(logrequest);
		add(jt);
		add(read);
		add(loglocation);
		
		
		submitButton.addActionListener(this);
		logrequest.addActionListener(this);
		response.addActionListener(this);
		read.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e){
	String actCmd = e.getActionCommand();
	
	switch(actCmd){
		case "Submit":
			
			String str = response.getText();
			String[]words = str.split(" ");
			String shortest = words[0];
			String longest = "";
		
			
			for(String words1 : words){
				if(words1.length()<shortest.length()){
					shortest = words1;
				}
				else if(words1.length()>longest.length()){
					longest = words1;
					}
			
			}
			
			if(longest.length() < 3){
				longestWord.setText("Is there anything else you would like to discuss?");
			}
			else if(longest.length() == 3){
				longestWord.setText("Why do you feel "+"'"+longest +"'"+ " is important?");
			}
			else if(longest.length() == 4){
				longestWord.setText("OK tell me more about "+"'" +longest+"'");
			}
			else if(longest.length() == 5){
				longestWord.setText("How does "+"'"+longest+"'"+" affect you?");

			}
			else if(longest.length() > 5){
				longestWord.setText("We seem to be making great progress with: "+"'"+longest+"'");

			}
			//System.out.println("Shortest words is: "+shortest+"\nLongest words is "+longest);
			break;
			
		case "Request log":
			 String fileName = "RequestedLog.txt"; //The name could be read from keyboard
			   PrintWriter outputStream = null;        
			   try{
				   outputStream = new PrintWriter(fileName);
				   outputStream.println(longestWord.getText());
				   outputStream.println(response.getText());
				   outputStream.close();
				   loglocation.setText("The name of your file is: "+fileName);
			   }catch(FileNotFoundException exc){
					   System.out.println("Error opening the file" + fileName);
					   System.exit(0);        
					  } 
			break;
		case "Read Text File":
			
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			File f = chooser.getSelectedFile();
			String filename = f.getAbsolutePath();
		
		try{
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			jt.read(br,null);
			br.close();
			jt.requestFocus();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null,ex);
		}
			
			break;
		default:
			longestWord.setText("What the hell happened?");
			break;
	
	
		}
	
	}
}
		
	
	
		
		
			
			
		
	
			
	
	
	
	
	
	


