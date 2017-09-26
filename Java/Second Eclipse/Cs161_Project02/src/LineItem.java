/**
 * LineItem class which is a product and an amount of that product. Is held in store inventory and in carts.
 * @author Gabriel
 *
 */
public class LineItem 
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
		return (prod.toString()+"\nAmount:"+getQuantity()+"\n");
	}
	public String forReceipt()
	{
		return (prod.toString()+"\n");
	}
}
