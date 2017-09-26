import java.util.Date;

/**
 * Class which allows customers to buy things from the store.
 * @author Gabriel
 *
 */
public class Sale extends Transaction 
{
	private double total;
	public Sale( Customer cus, Employee emp)
	{
		super(cus,emp);
		
	}
	
	public void addToCart(LineItem purchase)
	{
		getCart().add(purchase);
	}
	
	public LineItem getFromCart(String name)
	{
		
		
			int index=0;
			
			for(int i =0;i<getCart().size();i++)
			{
				if(getCart().get(i).getProd().getName().equalsIgnoreCase(name))
				{
					index=i;
				}
			}
			
			return getCart().get(index);
		
	}
	
	public void takeFromCart(LineItem purchase)
	{
		getCart().remove(purchase);
	}
	
	
	public String toString()
	{
		return("Employee:"+getEmp().getName()+"\n"
				+ "Customer:"+getCus().getName()+"\n"
				+cartToString());
		
	}
	
	public double getCartTotal()
	{
		
		for(int i =0;i<getCart().size();i++)
		{
			total+=(getCart().get(i).getQuantity())*(getCart().get(i).getProd().getPrice());
		}
		return total;
	}
}
