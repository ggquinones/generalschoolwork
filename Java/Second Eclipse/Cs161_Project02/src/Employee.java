import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * Employee class which extends the Person class. Has the ability to add to inventory, print an employee's sales
 * .Can also change its instance variables.
 * @author Gabriel
 *
 */

public class Employee extends Person
{
	private double salary;	
	private ArrayList<Sale> sales = new ArrayList<Sale>();
	
	public Employee(String name, int number, String address, double salary)
	{
		super(name,number,address);
		this.salary=salary;		
		
	}
	
	public void empSubMenu()
	{
		String name;
		
		name = JOptionPane.showInputDialog(null,"Welcome:\n"
				+ "Please login by typing in your name:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);

		if(name==null || name.equals(""))
		{
			
		}
		if(checkForPerson(name)==false)
		{
			makeNewEmp();
			empOptions();
		}
		else
		{
			empOptions();

		}
		
		
	}
	
	public void makeNewEmp()
	{
		String input1;
		String input2;
		String name;
		int num;
		double sal;
		String address;
		
		name = JOptionPane.showInputDialog(null,"Welcome new Employee, please create account:\nPlease enter your name:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
		address = JOptionPane.showInputDialog(null,"Please enter your address:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
		input1 =(JOptionPane.showInputDialog(null,"Please enter your phone number(no hyphens,spaces, area code, or parentheses):","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		input2 = (JOptionPane.showInputDialog(null,"Please enter your salary:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		while(name==null || name.equals("") ||input1==null || input1.equals("")||input2==null || input2.equals("")||address==null || address.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Incorrect entry try again!","ERROR",JOptionPane.WARNING_MESSAGE);
			name = JOptionPane.showInputDialog(null,"Welcome new Employee, please create account:\nPlease enter your name:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
			address = JOptionPane.showInputDialog(null,"Please enter your address:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
			input1 =(JOptionPane.showInputDialog(null,"Please enter your phone number(no hyphens,spaces, area code, or parentheses):","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
			input2 = (JOptionPane.showInputDialog(null,"Please enter your salary:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		}
			
		
			num=Integer.parseInt(input1);
			sal=Double.parseDouble(input2);
			new Employee(name,num,address,sal);
		
		
		
	}
	
	public void empOptions()
	{
		String option;
		int num;
		option =(JOptionPane.showInputDialog(null,"Enter a request:\n"
				+ "1) Add to Inventory\n"
				+ "2)Print Sales\n"
				+"3)Customer Spending\n"
				+ "4)Change Salary\n"
				+ "5)Change Address\n"
				+ "6)Change Phone Number\n"
				+ "7)Return to main menu","Toy Store Employee Menu",JOptionPane.QUESTION_MESSAGE));
		if(option==null || option.equals(""))
		{
			num=7;
		}
		else
		{
			num=Integer.parseInt(option);
		}
		
		
		if(num==1)
		{
			addInventory();
			empOptions();
		}
		else if(num==7)
		{
			
		}
		else if(num==2)
		{
			printSales();
			empOptions();
		}
		else if(num==3)
		{
			getCustomerTotal();
			empOptions();
		}
		else if(num==4)
		{
			changeSalary();
			empOptions();
		}
		else if(num==5)
		{
			changeAddress();
			empOptions();
		}
		else
		{
			changePhone();
			empOptions();
		}
	}
	
	
	public void addInventory()
	{
		String name;
		String description;
		double price;
		int amt;		
		String input1;
		String input2;
		name = JOptionPane.showInputDialog(null,"Please enter the product name:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
		if(checkForDbls(name)==true)
		{
			name=null;
		}
		description = JOptionPane.showInputDialog(null,"Please enter the product description:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
		input1 = (JOptionPane.showInputDialog(null,"Please enter the product price:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		input2 =(JOptionPane.showInputDialog(null,"Please enter the amount of the product to be added to the inventory:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		while(name==null || name.equals("") ||description==null || description.equals("")||input2==null || input2.equals("")||input1==null || input2.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Incorrect entry or last product already in inventory, try again!","ERROR",JOptionPane.WARNING_MESSAGE);
			name = JOptionPane.showInputDialog(null,"Please enter the product name:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
			description = JOptionPane.showInputDialog(null,"Please enter the product description:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
			input1 = (JOptionPane.showInputDialog(null,"Please enter the product price:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
			input2 =(JOptionPane.showInputDialog(null,"Please enter the amount of the product to be added to the inventory:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		}
		price=Double.parseDouble(input1);
		amt=Integer.parseInt(input2);
		Inventory.addItem(new LineItem(new Product(name,description,price),amt));
	}
	
	public boolean checkForDbls(String name)
	{
		for(int i=0;i<Inventory.getInventory().size();i++)
		{
			if(Inventory.getInventory().get(i).getProd().getName().equalsIgnoreCase(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public void addSale(Sale sale)
	{
		sales.add(sale);
	}
	
	
	public void printSales()
	{
		if(sales.size()==0)
		{
			System.out.println("Employee,"+this.getName()+" has no sales.");
		}
		else
		{
		
			String holder="SALES REPORT:\n";
		
			for(int i =0;i<sales.size();i++)
		
			{
			
				holder+=sales.get(i).toString();
		
			}
			System.out.println( holder);
		
		}
	}
	
	public void getCustomerTotal()
	{
		String name;
		name = JOptionPane.showInputDialog(null,"Please enter the customer name from console list:","Toy Store",JOptionPane.QUESTION_MESSAGE);
		if(name==null || name.equals("") || checkForPerson(name)==false)
		{
			JOptionPane.showMessageDialog(null,"Incorrect entry or customer not found!","ERROR",JOptionPane.WARNING_MESSAGE);

		}
		else
		{
			System.out.println("Money Spent by "+name+"\n$"+getCus(name).getMoney());
		}

	}
	
	public void changeSalary()
	{
		allEmps();
		String input = JOptionPane.showInputDialog(null,"Please enter the employee ID:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
		if(input==null || input.equals("") )
		{
			int ID=Integer.parseInt(input);
			if(getEmp(ID)==null)
			{
				JOptionPane.showMessageDialog(null,"Incorrect entry or emp not found!","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else
		{
			String input2 = JOptionPane.showInputDialog(null,"Please enter the new salary:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
			double sal1=Double.parseDouble(input2);
			this.setSal(sal1);
		}

	}

	public void setSal(double sal)
	{
		this.salary=sal;
	}
}
