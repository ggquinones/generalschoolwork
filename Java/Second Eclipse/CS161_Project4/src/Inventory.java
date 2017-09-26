import java.util.ArrayList;
/**
 * Inventory class which holds the static list of all items in the store.
 * @author Gabriel
 *
 */
public  class Inventory 
{
	public static ArrayList<LineItem> inventory = new ArrayList<LineItem>();
	
	public static void addItem(LineItem prod)
	{
		inventory.add(prod);
	}
	
	public static Product prodRequest(String name)
	{
		int index=0;
		
		for(int i =0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProd().getName().equalsIgnoreCase(name))
			{
				index=i;
			}
		}
		
		return inventory.get(index).getProd();
	}
	
	public static LineItem itemRequest(String name)
	{
		int index=0;
		
		for(int i =0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProd().getName().equalsIgnoreCase(name))
			{
				index=i;
			}
		}
		
		return inventory.get(index);
	}
	
	public static void decProdAmt(String prod, int amt)
	{
		for(int i =0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProd().getName().equalsIgnoreCase(prod))
			{
				inventory.get(i).decQuantity(amt);
			}
		}
	}
	
	public static void incProdAmt(String prod, int amt)
	{
		for(int i =0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProd().getName().equalsIgnoreCase(prod))
			{
				inventory.get(i).incQuantity(amt);
			}
		}
	}
	
	public static boolean inInventory(String name)
	{
		for(int i =0;i<inventory.size();i++)
		{
			if(inventory.get(i).getProd().getName().equalsIgnoreCase(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public static String inStock()
	{
		String holder="";
		for(int i =0;i<inventory.size();i++)
		{
			holder+=inventory.get(i).invToString();
		}
		return holder;
	}
}
 
/**
 * LineItem class gives puts a product and an amount together
 * @author Gabriel
 *
 */
class LineItem 
{
	private Product prod;
	private int quantity;
	
	public LineItem(Product prod,int quantity)
	{
		this.prod=prod;
		this.quantity=quantity;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void incQuantity(int amt)
	{
		this.quantity+=amt;
	}
	
	public void decQuantity(int amt)
	{
		this.quantity-=amt;
	}
	
	public Product getProd()
	{
		return prod;
	}
	
	public String toString()
	{
		return (prod.toString()+" Amount:"+getQuantity()+"\n");
	}
	public String invToString()
	{
		return (prod.toStringInvCheck()+" Amount:"+getQuantity()+"\n\n");
	}
}

/**
 * Product class refers to the things one can buy in the store
 * @author Gabriel
 *
 */
class Product 
{
	private String name;
	private String description;
	private double price;
	
	public Product(String name, String description, double price)
	{
		this.name=name;
		this.description=description;
		this.price=price;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toStringInvCheck()
	{
		return ("Name: "+name+" Description: "+description + " Price: $"+price);
	}
	
	public String toString()
	{
		return ("Name: "+name+" Description: "+description);
	}
}
