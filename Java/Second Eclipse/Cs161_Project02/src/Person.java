import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Person class is the super class of employee and customer.
 * @author Gabriel
 *
 */
public abstract class Person
{
	private String name;
	private int phoneNum;
	private String address;	
	private static ArrayList<Person> allPeople = new ArrayList<Person>();
	private static int idBase = 0;
	private int idNum;
	
	public Person(String name, int number, String address )
	{
		this.name=name;
		this.phoneNum=number;
		this.address=address;		
		idBase++;
		this.idNum=idBase;
		allPeople.add(this);
		if(idNum>2)
		{
		System.out.println("Your ID number is "+this.idNum);
		}
	}
	
	public void setNumber(int num)
	{
		this.phoneNum=num;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	public int getID()
	{
		return this.idNum;
	}
	
	public void changeAddress()
	{
		allEmps();
		allCus();
		String input = JOptionPane.showInputDialog(null,"Please enter the employee ID:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
		if(input==null || input.equals("") )
		{
			int ID=Integer.parseInt(input);
			if(getEmp(ID)==null || getCus(ID)==null)
			{
				JOptionPane.showMessageDialog(null,"Incorrect entry or employee or customer not found!","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else
		{
			String input2 = JOptionPane.showInputDialog(null,"Please enter the new address:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
			
			this.setAddress(input2);
		}
	}
	
	public void changePhone()
	{
		allEmps();
		allCus();
		String input = JOptionPane.showInputDialog(null,"Please enter the employee ID:","Toy Store ",JOptionPane.QUESTION_MESSAGE);
		if(input==null || input.equals("") )
		{
			int ID=Integer.parseInt(input);
			if(getEmp(ID)==null || getCus(ID)==null)
			{
				JOptionPane.showMessageDialog(null,"Incorrect entry or employee or customer not found!","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else
		{
			String input2 = JOptionPane.showInputDialog(null,"Please enter the number:","Toy Store ",JOptionPane.QUESTION_MESSAGE);
			int sal1=Integer.parseInt(input2);
			this.setNumber(sal1);
		}

	}
	
	public boolean checkForPerson(String name)
	{
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i).getName().equalsIgnoreCase(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Employee getEmp(String name)
	{
		int index=0;
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i).getName().equalsIgnoreCase(name))
			{
				index=i;
			}
		}
		
		return (Employee) allPeople.get(index) ;
	}
	
	public Employee getEmp(int ID)
	{
		int index=0;
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i).getID()==ID)
			{
				index=i;
			}
		}
		
		return (Employee) allPeople.get(index) ;
	}
	
	public Customer getCus(int ID)
	{
		int index=0;
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i).getID()==ID)
			{
				index=i;
			}
		}
		
		return (Customer) allPeople.get(index) ;
	}
	
	
	
	public Customer getCus(String name)
	{
		int index=0;
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i).getName().equalsIgnoreCase(name))
			{
				index=i;
			}
		}
		
		return (Customer)allPeople.get(index) ;
	}

	public static ArrayList<Person> getPersons()
	{
		return allPeople;
	}
	
	public void allEmps()
	{
		System.out.println("Employee List:");
		for(int i =0;i<allPeople.size();i++)
		{
			if(allPeople.get(i) instanceof Employee)
			{
				System.out.print(allPeople.get(i).getName()+"\t"+allPeople.get(i).getID()+"\n");
			}
		}
		System.out.println();
	}
	
	public void allCus()
	{
		
			System.out.println("Customer List:");
			for(int i =0;i<allPeople.size();i++)
			{
				if(allPeople.get(i) instanceof Customer)
				{
					System.out.print(allPeople.get(i).getName()+"\t"+allPeople.get(i).getID()+"\n");
				}
			}
			System.out.println();
		
	}
}
