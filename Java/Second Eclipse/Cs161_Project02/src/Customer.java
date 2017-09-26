import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * Customer class which extends the Person class. Has the ability to make purchases
 * and returns. Can also Check inventory as well change its age,address, and number.
 * @author Gabriel
 *
 */

public class Customer extends Person
{
	private int age;
	private double money;
	private ArrayList<Sale> purchases = new ArrayList<Sale>();
	
	public Customer(String name, int number, String address,int age)
	{
		super(name,number,address);
		this.age=age;
		
	}
	
	public void cusSubMenu()
	{
		String name;
		
		name = JOptionPane.showInputDialog(null,"Welcome:\n"
				+ "Please login by typing in your name:","Toy Store Customer Login",JOptionPane.QUESTION_MESSAGE);

		if(name==null || name.equals(""))
		{
			
		}
		if(checkForPerson(name)==false)
		{
			makeNewCus();
			cusOptions();
		}
		else
		{
			cusOptions();

		}
		
		
	}
	
	public void makeNewCus()
	{
		String input1;
		String input2;
		String name;
		int num;
		int age;
		String address;
		
		name = JOptionPane.showInputDialog(null,"Welcome new Customer, please create account:\nPlease enter your name:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
		address = JOptionPane.showInputDialog(null,"Please enter your address:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
		input1 =(JOptionPane.showInputDialog(null,"Please enter your phone number(no hyphens,spaces, area code, or parentheses):","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		input2 = (JOptionPane.showInputDialog(null,"Please enter your age:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		while(name==null || name.equals("") ||input1==null || input1.equals("")||input2==null || input2.equals("")||address==null || address.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Incorrect entry try again!","ERROR",JOptionPane.WARNING_MESSAGE);
			name = JOptionPane.showInputDialog(null,"Welcome new Customer, please create account:\nPlease enter your name:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
			address = JOptionPane.showInputDialog(null,"Please enter your address:","Toy Store Login",JOptionPane.QUESTION_MESSAGE);
			input1 =(JOptionPane.showInputDialog(null,"Please enter your phone number(no hyphens,spaces, area code, or parentheses):","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
			input2 = (JOptionPane.showInputDialog(null,"Please enter your age:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE));
		}
			
		
			num=Integer.parseInt(input1);
			age=Integer.parseInt(input2);
			new Customer(name,num,address,age);
		
		
		
	}
	
	
	public void cusOptions()
	{
		String option;
		int num;
		option =(JOptionPane.showInputDialog(null,"Enter a request:\n"
				+ "1) Buy Something\n"
				+ "2)Return Something\n"
				+ "3)Check Inventory\n"
				+ "4)Change Age\n"
				+ "5)Change Address\n"
				+ "6)Change Phone Number\n"
				+ "7) Return to Main Menu","Toy Store Employee Menu",JOptionPane.QUESTION_MESSAGE));
		if(option==null)
		{
			num=7;
		}
		else
		{
			num=Integer.parseInt(option);
		}
		
		
		if(num==1)
		{
			
			makePurchase();
			cusOptions();
		}
		else if(num==7 || option==null || option.equals(""))
		{
			
		}
		else if(num==2)
		{
			makeReturn();
			cusOptions();
		}
		else if(num==3)
		{
			buyOptions();
			cusOptions();
		}
		else if(num==4)
		{
			changeAge();
			cusOptions();
		}
		else if(num ==5)
		{
			changeAddress();
			cusOptions();
		}
		else if(num==6)
		{
			changePhone();
			cusOptions();
		}
	}
	
	public void buyOptions()
	{
		System.out.println("INVENTORY:");
		for(int i =0;i<Inventory.getInventory().size();i++)
		{
			System.out.println(Inventory.getInventory().get(i).toString());
		}
		
	}
	
	public void makePurchase()
	{
		buyOptions();
		String prodName = JOptionPane.showInputDialog(null,"Enter name of product you would like to purchase from console list:"
				,"Toy Store",JOptionPane.QUESTION_MESSAGE);
		String prodAmt = JOptionPane.showInputDialog(null,"Enter amount of product you would like to purchase:"
				,"Toy Store",JOptionPane.QUESTION_MESSAGE);
		
		allEmps();
		String empName = JOptionPane.showInputDialog(null,"Enter name of employee that helped you from console list:"
				,"Toy Store",JOptionPane.QUESTION_MESSAGE);
		if(prodName==null || prodName.equals("") ||prodAmt==null || prodAmt.equals("")||empName==null || empName.equals("")|| Inventory.inInventory(prodName)==false)
		{
			JOptionPane.showMessageDialog(null,"Error in product entry!","ERROR",JOptionPane.WARNING_MESSAGE);

		}
		else
		{
			int amt = Integer.parseInt(prodAmt);
			
			if(amt<= Inventory.itemRequest(prodName).getQuantity())
		{
			Sale sale=new Sale(this,getEmp(empName));		
			sale.addToCart(new LineItem(Inventory.prodRequest(prodName),amt));
			purchases.add(sale);
			getEmp(empName).addSale(sale);
			this.money+=Inventory.prodRequest(prodName).getPrice()*amt;
			System.out.println("RECEIPT\nThank you for shopping at the Toy Store!\n"+sale.toString()+"Sales Total:$"+sale.getCartTotal());
			Inventory.decProdAmt(prodName,amt);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Product not available in that amount!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
		}
	}
	
	public void makeReturn()
	{
		buyOptions();
		String prodName = JOptionPane.showInputDialog(null,"Enter name of product you would like to return:"
				,"Toy Store",JOptionPane.QUESTION_MESSAGE);
		String saleID = JOptionPane.showInputDialog(null,"Enter ID of sale you made:"
				,"Toy Store",JOptionPane.QUESTION_MESSAGE);
		if(prodName==null || prodName.equals("") ||saleID==null || saleID.equals("")|| Inventory.inInventory(prodName)==false)
		{
			JOptionPane.showMessageDialog(null,"Product or Transaction not found! Try again !","ERROR",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			int ID=Integer.parseInt(saleID);
			allEmps();
			String empName = JOptionPane.showInputDialog(null,"Enter name of employee that helped you from console list:"
					,"Toy Store",JOptionPane.QUESTION_MESSAGE);
			if(!(empName==null || empName.equals("")))
			{
				
				
				Return r=new Return(this,getEmp(empName),Transaction.findSale(ID));
				
				Inventory.incProdAmt(prodName,r.getSale().getFromCart(prodName).getQuantity());
				r.getSale().takeFromCart(r.getSale().getFromCart(prodName));
				
				buyOptions();
			}
				
		}
	}

	public double getMoney() {
		// TODO Auto-generated method stub
		return money;
	}
	
	
	public void changeAge()
	{
		allCus();
		String input = JOptionPane.showInputDialog(null,"Please enter the employee ID:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
		if(input==null || input.equals("") )
		{
			int ID=Integer.parseInt(input);
			if(getCus(ID)==null)
			{
				JOptionPane.showMessageDialog(null,"Incorrect entry or customer not found!","ERROR",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else
		{
			String input2 = JOptionPane.showInputDialog(null,"Please enter the new age:","Toy Store Inventory",JOptionPane.QUESTION_MESSAGE);
			int sal1=Integer.parseInt(input2);
			this.setAge(sal1);
		}

	}

	public void setAge(int sal1) {
		// TODO Auto-generated method stub
		this.age=sal1;
	}

	
	
	
}
