import java.util.ArrayList;
import java.util.Date;
/**
 * Sale and Returns super class. Has the ability to carry out customer purchases and returns.
 * @author Gabriel
 *
 */

public abstract class Transaction 
{
	
	private ArrayList<LineItem> cart = new ArrayList<LineItem>();
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
	
	
	
	public ArrayList<LineItem> getCart()
	{
		return cart;
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
	
	public void printCart()
	{
		for(int i =0;i<cart.size();i++)
		{
			System.out.println(cart.get(i).toString());
		}
	}
	
	public String cartToString()
	{
		String holder="Sold Items:\n";
		for(int i =0;i<cart.size();i++)
		{
			holder+=cart.get(i).toString();
		}
		return holder;
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
