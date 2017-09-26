/*
 * Rectangle class
 * Has fields width and length
 * toString() method and equals() method
 */
public class Rectangle 
{
	protected int width,length;
	// Initializes private fields
	public Rectangle(int width,int length)
	{
		this.width=width;
		this.length=length;
	}
	
	// Rectangle toString() method which returns a String specifying the
	// instance fields
	public String toString()
	{
		return("Width: "+this.width+"\nLength: "+this.length);
	}
	
	// equals() method which returns true only if all the fields of both
	// Rectangle objects are equal
	public boolean equals(Rectangle other)
	{
		if(this.width==other.width && this.length==other.length)
		{
			return true;
		}
		return false;
	}
	
	
	
}
