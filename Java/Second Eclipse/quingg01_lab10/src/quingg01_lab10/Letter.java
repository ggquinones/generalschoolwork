package quingg01_lab10;
/*
 * <Gabriel Quiñones>
 * CS160-01 Fall 2014
 * Lab 10
 */
// blueprint of Letter class
public class Letter {

	
	private String sender;
	private boolean printedMatter;
	
	// Initializer constructor
	public Letter(String send,boolean print)
	{
		sender=send;
		printedMatter=print;
	}
	
	// Copy constructor
	public Letter(Letter other)
	{
		sender=other.sender;
		printedMatter=other.printedMatter;
	}
	
	// Returns a String message containing the field values of a Letter object
	public String toString()
	{
		String message= (sender+"\t"+printedMatter);
		return message;
	}
	
	// Compares two Letter objects for equality
	public boolean equals(Letter other)
	{
		if(other.sender==sender && other.printedMatter==printedMatter)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
