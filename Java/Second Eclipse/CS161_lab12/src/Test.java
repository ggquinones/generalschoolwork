import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Test {

	public static void main(String[] args)
	{	
		MainMenu f = new MainMenu();
		f.setVisible(true);
	 
	}

}

class MainMenu extends JFrame
{
	public MainMenu()
	{
		
		JPanel inputs = new JPanel(new BorderLayout());
		JMenuBar bar = new JMenuBar();	
		setJMenuBar(bar);
		JMenu menu = new JMenu("Options");
		bar.add(menu);
		JMenuItem student = new JMenuItem("New Student");
		JMenuItem advisor = new JMenuItem("New Advisor");
		JMenuItem save = new JMenuItem("Save Data");
		JMenuItem load = new JMenuItem("Load Data");
		JMenuItem stuSearch = new JMenuItem("Student List");
		JMenuItem advSearch = new JMenuItem("Advisor List");
		
		JTextArea list = new JTextArea(Person.getNumberofAdv(),20);	
		inputs.add(list,BorderLayout.CENTER);
		list.setEditable(false);
		
		JButton exit = new JButton("EXIT");
		inputs.add(exit,BorderLayout.SOUTH);
		
		menu.add(student);
		menu.add(advisor);		
		menu.add(stuSearch);
		menu.add(advSearch);
		menu.add(save);
		menu.add(load);
		
		add(inputs);
		pack();
		
		
		student.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewStudentDialog newStu = new NewStudentDialog(MainMenu.this);
				pack();
				newStu.setVisible(true);
			}
		});
		
		advisor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				NewAdvisorDialog newAdv = new NewAdvisorDialog(MainMenu.this);
				pack();
				newAdv.setVisible(true);
			}
			
			
		});
		
		stuSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				list.setText("");
				list.setText(Person.getStuList());
				pack();
			}			
		});
		
		advSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
							
				
				list.setText("");
				list.setText(Person.getAdvList());
				pack();
			}			
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					JFileChooser choose = new JFileChooser(); 
					if (choose.showDialog(MainMenu.this, "Save") == JFileChooser.APPROVE_OPTION) 
					{
						  File newFile = choose.getSelectedFile();
						  FileOutputStream fos = new FileOutputStream(newFile);
						  ObjectOutputStream oos = new ObjectOutputStream(fos);
						  oos.writeObject(Person.allPeople);
					}
				}catch(Exception ex){
					dispose();
					JOptionPane.showMessageDialog(null,"EROOR!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
		});
		
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try{
					JFileChooser choose = new JFileChooser(); 
					if (choose.showDialog(MainMenu.this, "Open") == JFileChooser.APPROVE_OPTION) 
					{
						  File newFile = choose.getSelectedFile();
						  FileInputStream fis = new FileInputStream(newFile);
						  ObjectInputStream ois = new ObjectInputStream(fis);
						  Person.allPeople=(ArrayList)(ois.readObject());
					}
				}catch(Exception ex){
					dispose();
					JOptionPane.showMessageDialog(null,"EROOR!","ERROR",JOptionPane.WARNING_MESSAGE);
				} 
				
			}			
		});
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	
}

class NewStudentDialog extends JDialog
{
	public NewStudentDialog(JFrame owner)
	{
		super(owner,"New Student Sign Up",true);
		
		JPanel inputs = new JPanel(new GridLayout(7,2,5,5));
		
		JLabel name = new JLabel("Enter the name: ");
		inputs.add(name);
		JTextField nameField = new JTextField(20);
		inputs.add(nameField);
		
		JLabel address = new JLabel("Enter the address: ");
		inputs.add(address);
		JTextField addressField = new JTextField(20);
		inputs.add(addressField);
		
		JLabel number = new JLabel("Enter the number: ");
		inputs.add(number);
		JTextField numberField = new JTextField(7);
		inputs.add(numberField);
		
		JLabel SSN = new JLabel("Enter the SSN: ");
		inputs.add(SSN);
		JTextField SSNField = new JTextField(9);
		inputs.add(SSNField);
		
		JLabel advisor = new JLabel("Select the advisor's name:");
		inputs.add(advisor);
		JComboBox advisors = new JComboBox();
		fillComboBox(advisors);
		advisors.setEditable(false);
		inputs.add(advisors);
		
		JButton ok = new JButton("OK");
		inputs.add(ok);
		
		
		JButton cancel = new JButton("CANCEL");
		inputs.add(cancel);
		
		
		add(inputs);
		
		ok.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e)
			{
				try{
					Integer.parseInt(SSNField.getText().trim());
				}catch(NumberFormatException ex){
					return;
				}
				
				try{
					new Student(nameField.getText().trim(),Integer.parseInt(numberField.getText().trim()),
							addressField.getText().trim(),Person.getAdvisor((String)advisors.getSelectedItem()),Integer.parseInt(SSNField.getText().trim()));
					dispose();
				}catch(Exception ex){					
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}			
		});
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
			
		});
		pack();
	}
	
	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<Person.allPeople.size();i++)
		{
			if(Person.allPeople.get(i) instanceof Advisor)
			{
				box.addItem(Person.allPeople.get(i).getName());
			}
		}
	}
}

class NewAdvisorDialog extends JDialog
{
	public NewAdvisorDialog(JFrame owner)
	{
		super(owner,"New Advisor Sign Up",true);
		
		JPanel inputs = new JPanel(new GridLayout(7,2,5,5));
		
		JLabel name = new JLabel("Enter the name: ");
		inputs.add(name);
		JTextField nameField = new JTextField(20);
		inputs.add(nameField);
		
		JLabel address = new JLabel("Enter the address: ");
		inputs.add(address);
		JTextField addressField = new JTextField(20);
		inputs.add(addressField);
		
		JLabel number = new JLabel("Enter the phone number: ");
		inputs.add(number);
		JTextField numberField = new JTextField(7);
		inputs.add(numberField);
		
		JLabel SSN = new JLabel("Enter the SSN: ");
		inputs.add(SSN);
		JTextField SSNField = new JTextField(9);
		inputs.add(SSNField);
		
		JButton ok = new JButton("OK");
		inputs.add(ok);
		
		
		JButton cancel = new JButton("CANCEL");
		inputs.add(cancel);
		
		
		add(inputs);
		
		ok.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e)
			{
				try{
					Integer.parseInt(SSNField.getText().trim());
				}catch(InputMismatchException ex){
					JOptionPane.showMessageDialog(null,"SSN not input as an integer!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				try{
					new Advisor(nameField.getText().trim(),Integer.parseInt(numberField.getText().trim()),addressField.getText().trim(),Integer.parseInt(SSNField.getText().trim()));
					dispose();
				}catch(Exception ex){					
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}			
		});
		
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
			
		});
		pack();
		
		
	}


}