package quingg01_lab10;
/*
 * <Gabriel Quiñones>
 * CS160-01 Fall 2014
 * Lab 10
 */

// blueprint of POBox Class
public class POBox {

	
	private int boxNumber;
	private Letter[] letters;
	
	// Accessor method, return boxNumber data field
	public int getBoxNumber()
	{
		return boxNumber;
	}
	
	//Accessor method, returns a copy of letters data field
	public Letter[] getLetters()
	{
		Letter [] temp = new Letter[letters.length];
		for(int i =0;i<letters.length;i++)
		{
			temp[i]=letters[i];
		}
		return temp;
	}
	
	//Creates and returns a String message containing the field values
	public String toString()
	{
		String message;
		message =("Box Number: "+getBoxNumber()+"\nsender\tprintedMatter\n\n");
		for(int i =0;i<letters.length;i++)
		{
			message= (message+letters[i].toString()+"\n"); 
		}
		return message;
	}
	
	// Compares two POBox objects for equality
	public boolean equals(POBox other)
	{
		Letter [] temp=other.getLetters();
		if(boxNumber==other.boxNumber)
		{
			for(int i=0;i<letters.length;i++)
			{
				if(letters[i].equals(temp[i]))
				{
					return true;
				}
			}
		}
		
		return false;
		
		
	}
	
	// Default POBox constructor
	public POBox()
	{
		
	}
	
	// Initializer constructor
	public POBox(Letter[]lt ,int bn )
	{
		letters=lt;
		boxNumber= bn;
	}
	
	// copy constructor
	public POBox(POBox box)
	{
		letters=box.letters;
		boxNumber=box.boxNumber;
	}
	
	
	
	
	
	
	
	
	
	
}
