import java.io.Serializable;
import java.util.ArrayList;


public class Event 
{
	ArrayList<Thing> stuff=new ArrayList<>();
	private double accTotal=0.0;
	String name,email,num,deadline,address;
	
	public Event (String name, String email, String num, String deadline,String address)
	{
		this.name=name;
		this.email=email;
		this.num=num;
		this.deadline=deadline;
		this.address=address;
	}
	public void addThing(Thing thingy)
	{
		stuff.add(thingy);
	}
	
	public ArrayList<Thing> getStuff()
	{
		return stuff;
	}

}


// THING CLASS
class Thing implements Serializable
{
	private String name;
	private String desc;
	private int amt;
	private double price;
	private double total;
	
	public Thing(String name,String desc,int amount, double price)
	{
		this.name=name;
		this.desc=desc;
		this.amt=amount;
		this.price=price;
		this.total=amount*price;
		
	}
	
	public String toString()
	{
		return "Name: "+getName()+"\t$"+getTotal()+"\nAmt:"+this.getAmt()+"\tPrice/Unit: $"+this.getPrice()+"\n"+this.desc+"\n";
	}
	
	public String getName()
	{
		return this.name;
	}
	public double getTotal()
	{
		return this.total;
	}
	public int getAmt()
	{
		return this.amt;
	}
	public double getPrice()
	{
		return this.price;
	}
}