import java.util.ArrayList;
/**
 * Inventory class which holds the static list of all items in the store.
 * @author Gabriel
 *
 */

public  class Inventory 
{
	private static ArrayList<LineItem> inventory = new ArrayList<LineItem>();
	
	public static void addItem(LineItem prod)
	{
		inventory.add(prod);
	}
	
	public static ArrayList<LineItem> getInventory()
	{
		return inventory;
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
}
