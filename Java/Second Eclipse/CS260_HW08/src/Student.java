
public class Student {
	
	private String name;
	private ID id;
	
	// Constructor initializes name based on parameter and calls ID constructor to initialize id field.
	public Student(String name)
	{
		this.name=name;
		id=new ID();
	}
	// equals method for class, compares both fields of caller object to the fields of the "other" object
	public boolean equals(Student other)
	{
		if(name.equals(other.name) && id.equals(other.id))
		{
			return true;
		}
		return false;
	}
	
	public ID getID()
	{
		return id;
	}
	
	public String toString()
	{
		return(name);
	}

}
