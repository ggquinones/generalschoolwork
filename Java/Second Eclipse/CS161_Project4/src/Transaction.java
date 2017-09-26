import java.util.ArrayList;
import java.util.Date;
/**
 * The Transaction class is abstract and handles all transactions between a customer and an employee. One can either make a sale or return a sale
 * @author Gabriel
 *
 */
public abstract class Transaction 
{	
	private static ArrayList<Transaction> allTransactions = new ArrayList<>();
	private Date date;
	private Customer cus;
	private Employee emp;
	private static int idBase=0;
	private int idNum;
	
	public Transaction( Customer cus, Employee emp)
	{
		this.date=new Date();
		this.cus=cus;
		this.emp=emp;
		idBase++;
		idNum=idBase;
		System.out.println("Your transaction ID is "+idNum);
		allTransactions.add(this);
	}
	
	public Date getDate()
	{
		return date;
	}
		
	public int getTranID()
	{
		return idNum;
	}
	
	public static Sale findSale(int ID)
	{
	int index=0;	
		for(int i =0;i<allTransactions.size();i++)
		{
			if(allTransactions.get(i).getTranID()==ID)
			{
				index=i;
			}
		}
		return (Sale)allTransactions.get(index);
	}
	
	public Employee getEmp()
	{
		return this.emp;
	}
		
	public Customer getCus()
	{
		return this.cus;
	}	
}
/**
 * The Sales class extends from Transaction and it allows customers to take from the store inventory.
 * @author Gabriel
 *
 */
class Sale extends Transaction 
{
	
	private LineItem purchase;
	public Sale( Customer cus, Employee emp, LineItem purchase)
	{
		super(cus,emp);
		this.purchase=purchase;
		
	}
		
	
	public String toString()
	{
		return("Employee:"+getEmp().getName()+"  "
				+ "Customer:"+getCus().getName()+"  "
				+getLineItem().toString());
		
	}
	
	public LineItem getLineItem()
	{
		return purchase;
	}
}
/**
 * The Return class inherits from the transaction class and allows customers to go back on their purchases
 * and return them
 * @author Gabriel
 *
 */
class Return extends Transaction 
{
	private Sale ret;
	public Return( Customer cus, Employee emp,Sale ret)
	{
		super(cus,emp);
		this.ret=ret;
		
	}
	
	
	
	public Sale getSale()
	{
		return ret;
	}
}