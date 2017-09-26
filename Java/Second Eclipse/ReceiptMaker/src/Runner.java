import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Runner 
{
  public static void main(String[] args)
  {
	MainMenu mainMenu = new MainMenu();
	mainMenu.setVisible(true);
	    
  }
  
}



class MainMenu extends JFrame
{
	public MainMenu()
	{
		setTitle("Events and Proposals");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(3,1,5,5));
		
		JButton load = new JButton("Load Event");
		JButton newEvent = new JButton("New Event");
		JButton exit = new JButton("Exit");

		panel.add(load);
		panel.add(newEvent);
		panel.add(exit);
		add(panel);
		
		newEvent.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click)
			{
				NewEventDialog eventScreen = new NewEventDialog(MainMenu.this);
				eventScreen.setVisible(true);
				
			}
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click)
			{
				dispose();
			}
		});
		pack();
	}


	
	
}

class NewEventDialog extends JDialog
{
	public NewEventDialog(JFrame owner)
	{
		super(owner,"Event/Customer Info",false);
		JPanel panel = new JPanel(new GridLayout(7,2,5,5));
		
		JLabel name = new JLabel("Event Name:");          JTextField nameF = new JTextField(20);
		JLabel num = new JLabel("Phone Number:");           JTextField numF = new JTextField(20);
		JLabel email = new JLabel("Email:");		 JTextField emailF = new JTextField(20);
		JLabel address = new JLabel("Address:");		 JTextField addressF = new JTextField(20);
		JLabel deadline = new JLabel("Deadline:");      JTextField deadlineF = new JTextField(20);
		JLabel comments = new JLabel("Extra Comments:");      JTextArea commentsF = new JTextArea(20,3);
				
		panel.add(name);
		panel.add(nameF);
		panel.add(num);
		panel.add(numF);
		panel.add(email);
		panel.add(emailF);
		panel.add(address);
		panel.add(addressF);
		panel.add(deadline);
		panel.add(deadlineF);
		panel.add(comments);
		panel.add(commentsF);
		add(panel);
		JButton OK = new JButton("OK");			panel.add(OK);
		JButton EXIT = new JButton("EXIT");		panel.add(EXIT);
		
		OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click)
			{
				try
				{
					Event currentEvent = new Event(nameF.getText().trim(),emailF.getText().trim(),numF.getText().trim()
												  ,deadlineF.getText().trim(),addressF.getText().trim());
					dispose();
					ReceiptMakerScreen receiptMaker = new ReceiptMakerScreen(currentEvent); 
				}
				catch(Exception e)
				{
					//display error message
					// erase field entries but stay on new event screen until exit is pressed or X
				}
			}
		});
		pack();
	}
}