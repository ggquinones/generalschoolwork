import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This is the main runner in the store project. Contains all of the dialog boxes and a majority of the code.
 * Runs from a main menu, to either a employee or customer sub-menu. Then, either you can register or login. If you register
 * you must then login,if you login, it takes you to the respective options menu for either a customer or employee.
 * @author Gabriel Quiñones-Sanchez
 *
 */
public class Store 
{

	public static void main(String[] args)
	{
		MainMenuFrame f = new MainMenuFrame();
		f.setVisible(true);

	}

}

/**
 * Main menu frame. You can go into the customer or employee submenus, or exit the program.
 * @author Gabriel
 *
 */
class MainMenuFrame extends JFrame
{
	
	public MainMenuFrame()
	{
		setTitle("Main Menu");
		setSize(300,300);
		setResizable(false);
		
		add(new JLabel("                          Welcome to the Toy Store: "),BorderLayout.NORTH);
		JButton option1 = new JButton("Employee Login ");
		JButton option2 = new JButton("Customer Login ");
		JButton option3 = new JButton("Exit ");
		JPanel options = new JPanel(new GridLayout(3,1,5,5));
		options.add(option1);
		options.add(option2);
		options.add(option3);
		add(options);
		
		//Employee Button in Main Menu
		option1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				EmployeeDialog dialog = new EmployeeDialog(MainMenuFrame.this);
				dialog.setSize(200, 200);
				dialog.setVisible(true);

			}
			
			
		});
		
		option2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				CustomerDialog dialog = new CustomerDialog(MainMenuFrame.this);
				dialog.setSize(200, 200);
				dialog.setVisible(true);

			}
			
			
		});
		
		option3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}
	
}

/**
 * Employee submenu. From here you can register a new account or login to an existing one, or exit which
 * takes you back to the main menu.
 * @author Gabriel
 *
 */
class EmployeeDialog extends JDialog 
{
	  
	public EmployeeDialog(JFrame owner)
	{	
	    super(owner, "Employee Login", false);
	    JPanel options = new JPanel(new GridLayout(3,1,5,5));
	    JButton option1 = new JButton("Register ");
		JButton option2 = new JButton("Login ");
		JButton option3 = new JButton("Exit ");
		options.add(option1);
		options.add(option2);
		options.add(option3);
		add(options);
		
		option1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewEmpDialog dialog = new NewEmpDialog(EmployeeDialog.this);
				dialog.setSize(300, 200);
				dialog.setVisible(true);

			}
			
			
		});
		
		option2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				EmpLoginDialog dialog = new EmpLoginDialog(EmployeeDialog.this);
				dialog.setSize(200,150);
				dialog.setVisible(true);

			}
			
			
		});
		
		option3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
			
			
		});
		
	}
}
/**
 * Menu for new employees. Takes you information, amkes a new Employee object, and then
 * exits back to the employee submenu so that you can login or continue to the main menu.
 * @author Gabriel
 *
 */
class NewEmpDialog extends JDialog
{
	public NewEmpDialog(JDialog owner)
	{
		super(owner,"New Employee Sign Up",true);
		
		JPanel inputs = new JPanel(new GridLayout(5,2,5,5));
		
		JLabel name = new JLabel("Enter your name: ");
		inputs.add(name);
		JTextField nameField = new JTextField(20);
		inputs.add(nameField);
		
		JLabel address = new JLabel("Enter your address: ");
		inputs.add(address);
		JTextField addressField = new JTextField(20);
		inputs.add(addressField);
		
		JLabel number = new JLabel("Enter your number: ");
		inputs.add(number);
		JTextField numberField = new JTextField(7);
		inputs.add(numberField);
		
		JLabel salary = new JLabel("Enter your salary: ");
		inputs.add(salary);
		JTextField salaryField = new JTextField(20);
		inputs.add(salaryField);
		
		JLabel password = new JLabel("Enter your password: ");
		inputs.add(password);
		JTextField passwordField = new JTextField(20);
		inputs.add(passwordField);
		
		JPanel OK = new JPanel();
		JButton ok = new JButton("OK");
		OK.add(ok);
		
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				//get text from text fields make new employee
				// put password in for employee(add to fields of an employee)
				try
				{
					new Employee(nameField.getText().trim(),Integer.parseInt(numberField.getText().trim()),addressField.getText().trim(),Double.parseDouble(salaryField.getText().trim()), passwordField.getText().trim());
					dispose();
				}catch(Exception ex){
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
			
		});
		
		add(OK,BorderLayout.SOUTH);
		add(inputs, BorderLayout.CENTER);
	}

}
/**
 * Employee login menu. This will take in a username and password, and if it matches, will open the employee options menu.
 * If not reports error and returns you to employee submenu
 * @author Gabriel
 *
 */
 class EmpLoginDialog extends JDialog
 {
	  public EmpLoginDialog(JDialog owner)
	  {
		  
		  super(owner,"Employee Login",true);
		  JPanel login = new JPanel(new GridLayout(2,1,5,5));
		  JLabel label1 = new JLabel("name: ");
		  login.add(label1);
		  final JTextField loginField = new JTextField("", 10);
		  login.add(loginField);
	      JLabel label2 = new JLabel("password: ");
	      login.add(label2);
	      final JPasswordField passwordField = new JPasswordField("", 10);
	      login.add(passwordField);

	      JPanel OK = new JPanel();
		  JButton ok = new JButton("OK");
		  OK.add(ok);
		  
		  ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					try{
						
						if(new Employee().getPerson(loginField.getText().trim()).getPassword().equalsIgnoreCase(passwordField.getText().trim()))
						{
							dispose();
							EmpMenuDialog dialog = new EmpMenuDialog(owner);
							dialog.setSize(200,300);
							dialog.setVisible(true);
							
						}
					}catch(Exception ex){
						
						dispose();
						JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
			});
			
		  add(OK,BorderLayout.SOUTH);
	      add(login);
	  }
	 
	 
 }
/**
 * Employee options menu. From here an employee can add inventory, restock, print a sales report, check a customers spending, and
 * change his salary address or number.
 * @author Gabriel
 *
 */
 class EmpMenuDialog extends JDialog
 {
	 public EmpMenuDialog(JDialog owner)
	 {
		 super(owner,"Employee Menu", true);
		 JPanel options = new JPanel(new GridLayout(7,1,5,5));
		    JButton option1 = new JButton("Add to Inventory");
			JButton option2 = new JButton("Print Sales");
			JButton option3 = new JButton("Customer Spending");
			JButton option4 = new JButton("Change Salary");
			JButton option5 = new JButton("Change Address");
			JButton option6 = new JButton("Change Number");
			JButton option7 = new JButton("Exit");
			options.add(option1);
			options.add(option2);
			options.add(option3);
			options.add(option4);
			options.add(option5);
			options.add(option6);
			options.add(option7);
			add(options);
			
			option1.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					AddInventoryDialog dialog = new AddInventoryDialog(owner);
					dialog.setSize(200,150);
					dialog.setVisible(true);
				}
			});
			
			option2.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					SalesReportDialog dialog = new SalesReportDialog(owner);
					dialog.setSize(400,700);
					dialog.setVisible(true);
				}
			});
			
			option3.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					CustomerSpendingDialog dialog = new CustomerSpendingDialog(owner);
					dialog.setSize(400,700);
					dialog.setVisible(true);
				}
			});
			
			option4.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					NewSalaryDialog dialog = new NewSalaryDialog(owner);
					dialog.setSize(200,150);
					dialog.setVisible(true);
				}
			});
			
			option5.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					NewAddressDialog dialog = new NewAddressDialog(owner);
					dialog.setSize(200,150);
					dialog.setVisible(true);
				}
			});
			
			option6.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					NewNumberDialog dialog = new NewNumberDialog(owner);
					dialog.setSize(200,150);
					dialog.setVisible(true);
				}
			});
			
			option7.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
		 
	 }
 }
 /**
  * Customer submenu. From here you can register a new account or login to an existing one, or exit which
  * takes you back to the main menu.
  * @author Gabriel
  *
  */
class CustomerDialog extends JDialog
{
	public CustomerDialog(JFrame owner)
	{
		super(owner, "Customer Login", false);
	    JPanel options = new JPanel(new GridLayout(3,1,5,5));
	    JButton option1 = new JButton("Register ");
		JButton option2 = new JButton("Login ");
		JButton option3 = new JButton("Exit ");
		options.add(option1);
		options.add(option2);
		options.add(option3);
		option1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewCustomerDialog dialog = new NewCustomerDialog(CustomerDialog.this);
				dialog.setSize(300, 200);
				dialog.setVisible(true);

			}
			
			
			});
		
		option2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				CustomerLoginDialog dialog = new CustomerLoginDialog(CustomerDialog.this);
				dialog.setSize(200,150);
				dialog.setVisible(true);

			}
			
			
			});
		
		
		option3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		add(options);
	}
}
/**
 * Menu for new customer. Takes you information, amkes a new Customer object, and then
 * exits back to the customer submenu so that you can login or continue to the main menu.
 * @author Gabriel
 *
 */
class NewCustomerDialog extends JDialog
{
	public NewCustomerDialog(JDialog owner)
	{
		super(owner,"New Customer Sign Up",true);
		
		JPanel inputs = new JPanel(new GridLayout(5,2,5,5));
		
		JLabel name = new JLabel("Enter your name: ");
		inputs.add(name);
		JTextField nameField = new JTextField(20);
		inputs.add(nameField);
		
		JLabel address = new JLabel("Enter your address: ");
		inputs.add(address);
		JTextField addressField = new JTextField(20);
		inputs.add(addressField);
		
		JLabel number = new JLabel("Enter your number: ");
		inputs.add(number);
		JTextField numberField = new JTextField(7);
		inputs.add(numberField);
		
		JLabel age = new JLabel("Enter your age: ");
		inputs.add(age);
		JTextField ageField = new JTextField(20);
		inputs.add(ageField);
		
		JLabel password = new JLabel("Enter your password: ");
		inputs.add(password);
		JTextField passwordField = new JTextField(20);
		inputs.add(passwordField);
		
		JPanel OK = new JPanel();
		JButton ok = new JButton("OK");
		OK.add(ok);
		
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					new Customer(nameField.getText().trim(),Integer.parseInt(numberField.getText().trim()),addressField.getText().trim(),Integer.parseInt(ageField.getText().trim()), passwordField.getText().trim());
					dispose();
				}catch(Exception ex){
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}
			
			
		});
		
		add(OK,BorderLayout.SOUTH);
		add(inputs, BorderLayout.CENTER);
	}
}
/**
 * Customer login menu. This will take in a username and password, and if it matches, will open the Customer options menu.
 * If not reports error and returns you to Customer submenu
 * @author Gabriel
 *
 */
class CustomerLoginDialog extends JDialog
{
	  public CustomerLoginDialog(JDialog owner)
	  {
		  
		  super(owner,"Customer Login",true);
		  JPanel login = new JPanel(new GridLayout(2,1,5,5));
		  JLabel label1 = new JLabel("name: ");
		  login.add(label1);
		  final JTextField loginField = new JTextField("", 10);
		  login.add(loginField);
	      JLabel label2 = new JLabel("password: ");
	      login.add(label2);
	      final JPasswordField passwordField = new JPasswordField("", 10);
	      login.add(passwordField);

	      JPanel OK = new JPanel();
		  JButton ok = new JButton("OK");
		  OK.add(ok);
			
		  ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					try{
						
						if(new Customer().getPerson(loginField.getText().trim()).getPassword().equalsIgnoreCase(passwordField.getText().trim()))
						{
							dispose();
							
							CustomerMenuDialog dialog = new CustomerMenuDialog(owner,loginField.getText().trim() );
							dialog.setSize(200,300);
							dialog.setVisible(true);
							
						}
					}catch(Exception ex){
						
						dispose();
						JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
			});
			
		  add(OK,BorderLayout.SOUTH);
	      add(login);
	  }
}
/**
 * Customer options menu. From here an Customer can buy,return, browse inventory and
 * change his age address or numberand then checkout.
 * @author Gabriel
 *
 */
class CustomerMenuDialog extends JDialog
{
	
	public CustomerMenuDialog(JDialog owner, String customer)
	{
		super(owner,"Customer Menu");
		JPanel options = new JPanel(new GridLayout(8,1,5,5));
	    JButton option1 = new JButton("Buy");
		JButton option2 = new JButton("Return");
		JButton option3 = new JButton("Check Inventory");
		JButton option4 = new JButton("Change Age");
		JButton option5 = new JButton("Change Address");
		JButton option6 = new JButton("Change Number");
		JButton option7 = new JButton("Checkout");
		JButton option8 = new JButton("Exit");
		options.add(option1);
		options.add(option2);
		options.add(option3);
		options.add(option4);
		options.add(option5);
		options.add(option6);
		options.add(option7);
		options.add(option8);
		add(options);
		
		option1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				BuyDialog dialog = new BuyDialog(owner,customer);
				dialog.setSize(200,150);
				dialog.setVisible(true);
			}
		});
		
		option2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				ReturnDialog dialog = new ReturnDialog(owner, customer);
				dialog.setSize(200,150);
				dialog.setVisible(true);
			}
		});
		
		option3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				CheckInventoryDialog dialog = new CheckInventoryDialog(owner);
				dialog.setSize(400,700);
				dialog.setVisible(true);
			}
		});
		
		option4.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewAgeDialog dialog = new NewAgeDialog(owner,customer);
				dialog.setSize(200,150);
				dialog.setVisible(true);
			}
		});
		
		option5.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewCusAddressDialog dialog = new NewCusAddressDialog(owner,customer);
				dialog.setSize(200,150);
				dialog.setVisible(true);
			}
		});
		
		option6.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewCusNumberDialog dialog = new NewCusNumberDialog(owner,customer);
				dialog.setSize(200,150);
				dialog.setVisible(true);
			}
		});
		
		option7.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				ReceiptDialog dialog = new ReceiptDialog(owner, customer);
				dialog.setSize(400,700);
				dialog.setVisible(true);
				dispose();
			}
		});
	 
		option8.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}


}
/**
 * Person is an abstract class from which Customer and Employee inherit.
 * Every person has an adddress, number, name, password, and ID.
 * @author Gabriel
 *
 */
abstract class Person
{
		private String name;
		private int phoneNum;
		private String address;	
		private String password;
		public static ArrayList<Person> allPeople = new ArrayList<Person>();
		
		private static int idBase = 0;
		private int idNum;
		
		public Person(String name, int number, String address,String password )
		{
			this.name=name;
			this.phoneNum=number;
			this.address=address;	
			this.password=password;
			idBase++;
			this.idNum=idBase;
			allPeople.add(this);
			if(idNum>2)
			{
			System.out.println("Your ID number is "+this.idNum);
			}
		}
		
		public Person(){}
		// Returns number
		public void setNumber(int num)
		{
			this.phoneNum=num;
		}
		//sets address
		public void setAddress(String address)
		{
			this.address=address;
		}
		//returns ID
		public int getID()
		{
			return this.idNum;
		}
	// returns name
		public String getName()
		{
			return(this.name);
		}
		/**
		 * 
		 * @param name-string, name of person youre looking for
		 * @return Person returns the person youre looking for
		 */
		public Person getPerson(String name)
		{
			
			for(Person el: allPeople)
			{
				if(el.getName().equalsIgnoreCase(name))
				{
					return el;
				}
			}
			return null;
		}
		//returns password
		public String getPassword()
		{
			return this.password;
		}
		/**
		 * 
		 * @param name-string, name of employee youre looking for
		 * @return Person returns the employee youre looking for
		 */
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
		/**
		 * 
		 * @param name-string, name of Customer youre looking for
		 * @return Person returns the Customer youre looking for
		 */
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
}
 /**
  * Employee class extends from Person. Employee runs the business isde of the store, can change inventory at will get customer reports and change his personal data
  * @author Gabriel
  *
  */
class Employee extends Person
{
		private double salary;	
		private ArrayList<Sale> sales = new ArrayList<Sale>();
		
		public Employee(String name, int number, String address, double salary, String password)
		{
			super(name,number,address,password);
			this.salary=salary;		
			
		}
		
		public Employee(){}
		
		public String printSales()
		{
			
			if(sales.size()==0)
			{
				return("Employee has no sales.");
			}
			else
			{
			
				String holder="";
			
				for(int i =0;i<sales.size();i++)
			
				{
				
					holder+=sales.get(i).toString();
			
				}
				return holder;
			
			}
		}

		public void setSalary(double salary) 
		{
			this.salary=salary;
			
		}

		
		public void addSale(Sale sale) 
		{
			sales.add(sale);
			
		}

		public void eraseSale(int iD) 
		{
			for(int i =0;i<sales.size();i++)
			{
				if(sales.get(i).getTranID()==iD)
				{
					sales.remove(i);
				}
			}
			
		}
}

/**
 * Customer class extends from Person. Employeecan buy browse and make returns and change his personal data
 * @author Gabriel
 *
 */
class Customer extends Person
{
	private int age;
	private double money;
	private static ArrayList<Sale> purchases = new ArrayList<Sale>();
	
	public Customer(String name, int number, String address,int age,String password )
	{
		super(name,number,address,password );
		this.age=age;
		
	}
	
	public Customer(){}
	
	public String printReceipt()
	{
		
		if(purchases.size()==0)
		{
			return("Customer has no purchases.");
		}
		else
		{
		
			String holder="";
		
			for(int i =0;i<purchases.size();i++)
		
			{
			
				holder+=purchases.get(i).toString();
		
			}
			holder+="Total:"+getCartTotal();
			return holder;
		
		}
	}
	
	public static void addToCart(Sale purchase)
	{
		purchases.add(purchase);
	}
	
	public void takeFromCart(int ID)
	{
		for(int i=0;i<purchases.size();i++)
		{
			if(purchases.get(i).getTranID() == ID )
			{
				purchases.remove(i);
			}
		}
	}
	
	public static Sale getPurchase(int ID)
	{
		Sale purchase = purchases.get(0);
		for(int i=0;i<purchases.size();i++)
		{
			if(purchases.get(i).getTranID() == ID )
			{
				purchase=(purchases.get(i));
			}
		}
		return purchase;
	}
	
	public double getCartTotal()
	{
		int total=0;
		for(int i =0;i<purchases.size();i++)
		{
			total+=(purchases.get(i).getLineItem().getQuantity())*(purchases.get(i).getLineItem().getProd().getPrice());
		}
		return total;
	}

	public void setAge(int age)
	{
		this.age=age;	
	}

	public void clearCart() 
	{
		purchases.clear();
		
	}
}

/**
 * AddInventory dialog box allows an employee to either restock or add a new item or exit and return to employee options menu
 * @author Gabriel
 *
 */
class AddInventoryDialog extends JDialog
{
	public AddInventoryDialog(JDialog owner)
	{
		super(owner,"Adding to Inventory:",true);
		JPanel options = new JPanel(new GridLayout(3,1,5,5));
		JButton option1 = new JButton("Restock:");
		JButton option2 = new JButton("Add New Product:");
		JButton option3 = new JButton("Exit");
		options.add(option1);
		options.add(option2);
		options.add(option3);
		add(options);
		
		option1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				RestockDialog dialog = new RestockDialog(owner);
				dialog.setSize(200,150);
				dialog.setVisible(true);
				
			}
			
		});
		
		option2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				NewItemDialog dialog = new NewItemDialog(owner);
				dialog.setSize(250,150);
				dialog.setVisible(true);
			}
			
		});
	
		option3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
	}

}
/**
 * Restock dialog box allows an employee to restock items already in inventory
 * @author Gabriel
 *
 */
class RestockDialog extends JDialog
{
	public RestockDialog(JDialog owner)
	{
		super(owner,"Restock",true);
		JPanel inputs = new JPanel(new GridLayout(5,2,5,5));
		
		JLabel name = new JLabel("Select product Name:");
		inputs.add(name);
		JComboBox products = new JComboBox();
		fillComboBoxProds(products);
		products.setEditable(false);
		inputs.add(products);
		
		JLabel amount = new JLabel("Amount to add:");
		inputs.add( amount);
		JTextField  amountField = new JTextField(20);
		inputs.add(amountField);
		
		JButton ok = new JButton("OK");
		inputs.add(ok);
		add(inputs);
		
		ok.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e)
			{
				//do action
				try{
					Inventory.incProdAmt((String)products.getSelectedItem(),Integer.parseInt(amountField.getText().trim()));
					dispose();
				}catch(Exception ex){					
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}			
		});
	}
	
	public void fillComboBoxProds(JComboBox box)
	{
		for(int i =0;i<Inventory.inventory.size();i++)
		{
			box.addItem(Inventory.inventory.get(i).getProd().getName());	
		}
			
	}
}
 /**
  * NewItem dialog box allows an employee to add new items to the inventory
  * @author Gabriel
  *
  */
class NewItemDialog extends JDialog
{
	public NewItemDialog(JDialog owner)
	{
		super(owner,"New Item",true);
		JPanel inputs = new JPanel(new GridLayout(5,2,5,5));
		
		JLabel name = new JLabel("Product name: ");
		inputs.add(name);
		JTextField nameField = new JTextField(20);
		inputs.add(nameField);
		
		JLabel description = new JLabel("Product description: ");
		inputs.add(description);
		JTextField descriptionField = new JTextField(20);
		inputs.add(descriptionField);
		
		JLabel price = new JLabel("Product price: ");
		inputs.add(price);
		JTextField priceField = new JTextField(7);
		inputs.add(priceField);
		
		JLabel amount = new JLabel("Product amount: ");
		inputs.add(amount);
		JTextField amountField = new JTextField(20);
		inputs.add(amountField);

		JButton ok = new JButton("OK");
		inputs.add(ok);
		
		add(inputs);
		
		ok.addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent e)
			{
				
				try
				{
					Inventory.addItem(new LineItem(new Product(nameField.getText().trim(),descriptionField.getText().trim(),
							Double.parseDouble(priceField.getText().trim())),Integer.parseInt(amountField.getText().trim())));
					dispose();
				}catch(Exception ex){
					
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
				
			}			
		});
	}
}
/**
 * Sales report dialog prints out the sales report for an employee
 * @author Gabriel
 *
 */
class SalesReportDialog extends JDialog
{
	public SalesReportDialog(JDialog owner)
	{
		super(owner,"Sales Report",true);
		try{
			JPanel area = new JPanel();
			JPanel inputs = new JPanel();
			JPanel button = new JPanel();
			JLabel label = new JLabel("Select employee:");
			inputs.add(label);
			
			JComboBox emps = new JComboBox();
			fillComboBox(emps);
			emps.setEditable(false);
			inputs.add(emps);
					
			JTextArea report = new JTextArea(20,30);
			area.add(report);
			
			String empChosen = (String)emps.getSelectedItem();
			report.setText((new Employee().getEmp(empChosen)).printSales());
			
			JButton exit = new JButton("Exit");
			button.add(exit);
			exit.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
			
			//area.add(new JScrollPane(report));

			add(inputs,BorderLayout.NORTH);
			add(area,BorderLayout.CENTER);
			add(button,BorderLayout.SOUTH);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);			
		}
	}
	
	public void fillComboBox(JComboBox box)
		{
			for(int i =0;i<new Employee().allPeople.size();i++)
			{
				if(new Employee().allPeople.get(i) instanceof Employee)
				{
					box.addItem(new Employee().allPeople.get(i).getName());
				}
				
			}
				
		}
}

/**
 * CustomerSpending dialog box allows an employee to see the spending of a customer
 * @author Gabriel
 *
 */
class CustomerSpendingDialog extends JDialog
{
	public CustomerSpendingDialog(JDialog owner)
	{
		super(owner,"Customer Receipt",true);
		try{
			JPanel area = new JPanel();
			JPanel inputs = new JPanel();
			JPanel button = new JPanel();
			
			JLabel label = new JLabel("Select customer:");
			inputs.add(label);
			JComboBox customers = new JComboBox();
			customers.setEditable(false);
			inputs.add(customers);
						
			fillComboBox(customers);			
			JTextArea report = new JTextArea(20,30);
			area.add(report);
			
			String cusChosen = (String)customers.getSelectedItem();
			report.setText((new Employee().getCus(cusChosen)).printReceipt());
			
			JButton exit = new JButton("Exit");
			button.add(exit);
			exit.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					dispose();
				}
			});
			add(inputs,BorderLayout.NORTH);
			add(area,BorderLayout.CENTER);
			add(button,BorderLayout.SOUTH);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"No customers!","ERROR",JOptionPane.WARNING_MESSAGE);
			
		}
		

		
	}

	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<new Customer().allPeople.size();i++)
		{
			if(new Customer().allPeople.get(i) instanceof Customer)
			{
				box.addItem(new Customer().allPeople.get(i).getName());
			}
			
		}
	}
}
 /**
  * NewSalary dialog box allows an employee to change his salary
  * @author Gabriel
  *
  */
class NewSalaryDialog extends JDialog
{
	public NewSalaryDialog(JDialog owner)
	{
		super(owner,"Change Salary",true);
		try{
			JPanel inputs = new JPanel();
			JLabel label1 = new JLabel("Select employee:");
			inputs.add(label1);
			
			JComboBox emps = new JComboBox();
			fillComboBox(emps);
			emps.setEditable(false);
			inputs.add(emps);
			
			JLabel label2 = new JLabel("New salary:");
			inputs.add(label2);
			
			JTextField salaryField = new JTextField(15);
			inputs.add(salaryField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					String empChosen= (String)emps.getSelectedItem();
					(new Employee().getEmp(empChosen)).setSalary(Double.parseDouble(salaryField.getText().trim()));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<new Employee().allPeople.size();i++)
		{
			if(new Employee().allPeople.get(i) instanceof Employee)
			{
				box.addItem(new Employee().allPeople.get(i).getName());
			}
			
		}
			
	}
}
/**
 * NewAddress dialog box allows an employee to change his address
 * @author Gabriel
 *
 */
class NewAddressDialog extends JDialog
{
	public NewAddressDialog(JDialog owner)
	{
		super(owner,"New Address:",true);
		try{
			JPanel inputs = new JPanel();
			JLabel label1 = new JLabel("Select employee:");
			inputs.add(label1);
			
			JComboBox emps = new JComboBox();
			fillComboBox(emps);
			emps.setEditable(false);
			inputs.add(emps);
			
			JLabel label2 = new JLabel("New address:");
			inputs.add(label2);
			
			JTextField addressField = new JTextField(15);
			inputs.add(addressField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					String empChosen= (String)emps.getSelectedItem();
					(new Employee().getEmp(empChosen)).setAddress((addressField.getText().trim()));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<new Employee().allPeople.size();i++)
		{
			if(new Employee().allPeople.get(i) instanceof Employee)
			{
				box.addItem(new Employee().allPeople.get(i).getName());
			}
			
		}
			
	}
}
/**
 * NewNumber dialog box allows an employee to change his phone number
 * @author Gabriel
 *
 */
class NewNumberDialog extends JDialog
{
	public NewNumberDialog(JDialog owner)
	{
		super(owner,"New Number:",true);
		try{
			JPanel inputs = new JPanel();
			JLabel label1 = new JLabel("Select employee:");
			inputs.add(label1);
			
			JComboBox emps = new JComboBox();
			fillComboBox(emps);
			emps.setEditable(false);
			inputs.add(emps);
			
			JLabel label2 = new JLabel("New number:");
			inputs.add(label2);
			
			JTextField numberField = new JTextField(15);
			inputs.add(numberField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					String empChosen= (String)emps.getSelectedItem();
					(new Employee().getEmp(empChosen)).setNumber(Integer.parseInt((numberField.getText().trim())));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}

	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<new Employee().allPeople.size();i++)
		{
			if(new Employee().allPeople.get(i) instanceof Employee)
			{
				box.addItem(new Employee().allPeople.get(i).getName());
			}
			
		}
			
	}
}
/**
 * Buy dialog box allows a customer to buy things at the store
 * @author Gabriel
 *
 */
class BuyDialog extends JDialog
{
	public BuyDialog(JDialog owner, String customer)
	{
		super(owner,"Buy",true); 
		Customer helper= new Customer();
		Employee manager = new Employee();
		JPanel inputs = new JPanel(new GridLayout(4,2,5,5));
		
		JLabel name = new JLabel("Select product Name:");
		inputs.add(name);
		JComboBox products = new JComboBox();
		fillComboBoxProds(products);
		products.setEditable(false);
		inputs.add(products);
		
		JLabel amount = new JLabel("Amount to buy:");
		inputs.add( amount);
		JTextField  amountField = new JTextField(20);
		inputs.add(amountField);
		
		JLabel emp = new JLabel("Select employee that helped you:");
		inputs.add(emp);
		JComboBox emps = new JComboBox();
		fillComboBox(emps);
		emps.setEditable(false);
		inputs.add(emps);
		
		JButton ok = new JButton("OK");
		inputs.add(ok);
		add(inputs);
		
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				try{
					Customer user=helper.getCus(customer);
					String prodChosen= (String)products.getSelectedItem();
					if(Integer.parseInt(amountField.getText().trim())<= Inventory.itemRequest(prodChosen).getQuantity())
					{
						String empChosen= (String)emps.getSelectedItem();
						Inventory.decProdAmt(prodChosen,Integer.parseInt(amountField.getText().trim()));
						Sale sale = new Sale(user,manager.getEmp(empChosen),new LineItem(Inventory.prodRequest(prodChosen),
								Integer.parseInt(amountField.getText().trim())));
						Customer.addToCart(sale);
						manager.getEmp(empChosen).addSale(sale);
						
						dispose();
					}
				}catch(Exception ex){
					dispose();
					JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	public void fillComboBox(JComboBox box)
	{
		for(int i =0;i<new Employee().allPeople.size();i++)
		{
			if(new Employee().allPeople.get(i) instanceof Employee)
			{
				box.addItem(new Employee().allPeople.get(i).getName());
			}
			
		}
			
	}

	public void fillComboBoxProds(JComboBox box)
	{
		for(int i =0;i<Inventory.inventory.size();i++)
		{
			box.addItem(Inventory.inventory.get(i).getProd().getName());	
		}
			
	}
}
/**
 * Return dialog box allows a customer to return objects to store
 * @author Gabriel
 *
 */
class ReturnDialog extends JDialog
{
	public ReturnDialog(JDialog owner, String customer)
	{
		super(owner,"Return",true);
		Customer helper= new Customer();
		JPanel inputs = new JPanel(new GridLayout(3,1,5,5));
			
		
		JLabel transactionID = new JLabel("Enter transaction ID:");
		inputs.add( transactionID);
		JTextField  transactionIDField = new JTextField(20);
		inputs.add(transactionIDField);
		
		JButton ok = new JButton("OK");
		inputs.add(ok);
		
		ok.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				try{
					
					Customer user=helper.getCus(customer);
					
					int ID=Integer.parseInt(transactionIDField.getText().trim());
					String product =Customer.getPurchase(ID).getLineItem().getProd().getName(); 								
					
					Inventory.incProdAmt(product,Customer.getPurchase(ID).getLineItem().getQuantity() ); // increases amt of prod in inventory					
					new Return(user,user.getPurchase(ID).getEmp(),user.getPurchase(ID));
					
					Customer.getPurchase(ID).getEmp().eraseSale(ID);
					user.takeFromCart(ID);
					
					dispose();
				}catch(IndexOutOfBoundsException ex){ 
					dispose();
				JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);}
			}
		});
		
		add(inputs);
	}	
}
/**
 * Receipt dialog box is used when a customer wants to check out of the store
 * @author Gabriel
 *
 */
class ReceiptDialog extends JDialog
{
	public ReceiptDialog(JDialog owner, String customer)
	{
		super(owner,"Receipt",true);
		
		JPanel area = new JPanel();
		JPanel button = new JPanel();
						
		JTextArea report = new JTextArea(30,30);
		area.add(report);
		
		report.setText(new Customer().getCus(customer).printReceipt());
		
		
		JButton exit = new JButton("Exit");
		button.add(exit);
		exit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				new Customer().getCus(customer).clearCart();
				dispose();
			}
		});
		


		
		add(area,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
	}

}
/**
 * NewAge dialog box allows a customer to change his age
 * @author Gabriel
 *
 */
class NewAgeDialog extends JDialog
{
	public NewAgeDialog(JDialog owner, String customer)
	{
		super(owner,"New Age:",true);
		try{
			JPanel inputs = new JPanel();
			
			JLabel label2 = new JLabel("New age:");
			inputs.add(label2);
			
			JTextField numberField = new JTextField(15);
			inputs.add(numberField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					
					(new Customer().getCus(customer)).setAge(Integer.parseInt((numberField.getText().trim())));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}

}
/**
 * NewCusNumber dialog box allows a customer to change his phone number
 * @author Gabriel
 *
 */
class NewCusNumberDialog extends JDialog
{
	public NewCusNumberDialog(JDialog owner, String customer)
	{
		super(owner,"New Number:",true);
		try{
			JPanel inputs = new JPanel();
			
			JLabel label2 = new JLabel("New number:");
			inputs.add(label2);
			
			JTextField numberField = new JTextField(15);
			inputs.add(numberField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					
					(new Customer().getCus(customer)).setNumber(Integer.parseInt((numberField.getText().trim())));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}

}
/**
 * NewCusAddress dialog box allows a customer to change his address
 * @author Gabriel
 *
 */
class NewCusAddressDialog extends JDialog
{
	public NewCusAddressDialog(JDialog owner, String customer)
	{
		super(owner,"New Address:",true);
		try{
			JPanel inputs = new JPanel();
			
			JLabel label2 = new JLabel("New address:");
			inputs.add(label2);
			
			JTextField addressField = new JTextField(15);
			inputs.add(addressField);
			
			JButton ok = new JButton("OK");
			inputs.add(ok);
			
			ok.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e)
				{
					
					(new Customer().getCus(customer)).setAddress((addressField.getText().trim()));
					dispose();
				}
				
				
			});
			
			add(inputs);
		}catch(Exception e){
			dispose();
			JOptionPane.showMessageDialog(null,"Incorrect entry!","ERROR",JOptionPane.WARNING_MESSAGE);
		}
	}
}
 /**
  * CheckInventory dialog box allows a customer to browse through the store inventory
  * @author Gabriel
  *
  */
class CheckInventoryDialog extends JDialog
{
	public CheckInventoryDialog(JDialog owner)
	{
		super(owner,"Inventory",true);
		
		JPanel area = new JPanel();
		JPanel button = new JPanel();
						
		JTextArea report = new JTextArea(20,30);
		area.add(report);
		
		report.setText(Inventory.inStock());
		
		
		JButton exit = new JButton("Exit");
		button.add(exit);
		exit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		


		
		add(area,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
	}
}