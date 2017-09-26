import java.util.Random;


public class ID 
{
	private int part1,part2;
	Random rd = new Random();
	
	// constructor which initializes both parts of the id numbers to numbers between o and two billion
	// using random generator
	public ID()
	{
		part1=rd.nextInt(2000000000);
		part2=rd.nextInt(2000000000);
	}
	
	// equals method for class, compares both fields of caller object to the fields of the "other" object
	public boolean equals(ID other)
	{
		if(part1==other.part1 && part2==other.part2)
		{
			return true;
		}
		return false;
	}
}
