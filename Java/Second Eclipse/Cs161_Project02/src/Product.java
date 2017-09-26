/**
 * What is sold at the store.
 * @author Gabriel
 *
 */
public class Product 
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
	
	public String toString()
	{
		return ("Product name:\n"+name+"\nProduct Description:\n"+description+"\nProduct Price:\n"+"$"+price);
	}
}
