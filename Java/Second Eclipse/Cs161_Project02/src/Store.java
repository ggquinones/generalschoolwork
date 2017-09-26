import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Main runner of the store.
 * @author Gabriel
 *
 */

public class Store {

	public static void main(String[] args) 
	{
		Employee owner = new Employee("g",8159411,"123 Store Ave.",100000);
		Customer person = new Customer("",1,"",1);
		int option=0;
		while(option!=3)
		{
			String input;
			input =(JOptionPane.showInputDialog(null,"Welcome to the Toy Store:\n"
					+ "1) Employee Login\n"
					+ "2) Customer Login\n"
					+ "3) Exit","Toy Store Main Menu",JOptionPane.QUESTION_MESSAGE));
			if(input==null || input.equals(""))
			{
				option=3;
			}
			else
			{
				option = Integer.parseInt(input);
			}
			
			if(option==1)
			{
				owner.empSubMenu();
			}
			else if(option==2)
			{
				person.cusSubMenu();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Have a nice day! Thank you for your business!","GOODBYE",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
		

	}

}

class MainMenuFrame extends JFrame
{
	
	public MainMenuFrame()
	{
		setTitle("Main Menu");
		setSize(300,300);
		setResizable(false);
		
		add(new JTextField("Welcome to the Toy Store: "));
		JButton Option1 = new JButton("1)Employee Login ");
	}
	
	
	
	
	
	
	
	
	
}



