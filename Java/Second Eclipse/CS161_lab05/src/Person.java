import java.util.ArrayList;


/**
 * This is the abstract class Person from which the classes Student 
 * and Advisor inherit from. The class has one instance field, a String name,
 * a constructor, a toString method which prints the name of the Person, and a getName
 * method which returns the name of the Person.
 * @author Gabriel Quiñones-Sanchez CS161 Lab 5
 *
 */
public abstract class Person implements Comparable<Person>  
{
	
	private String name;
	private int number;
	private String address;
	public static ArrayList<Person> allPeople = new ArrayList<>();
	
	public Person(String name, int number, String address)
	{
		this.name=name;
		this.number=number;
		this.address=address;
	}
	
	public String toString()
	{
		return getName();
	}
	
	public String getName()
	{
		return name;
	}

	public static Advisor getAdvisor(String name)
	{
		
		for(Person el: allPeople)
		{
			if(el instanceof Advisor && el.getName().equals(name))
			{
				return (Advisor)el;
			}
		}
		return null;
	}
	
	public static int getNumberofStu()
	{
		int count =0;
		for(Person el: allPeople)
		{
			
			if(el instanceof Student)
			{
				count++;
			}
		}
		return count;
	}
	
	public static int getNumberofAdv()
	{
		int count =0;
		for(Person el: allPeople)
		{
			
			if(el instanceof Advisor)
			{
				count++;
			}
		}
		return count;
	}
	
	// lab 6 addition
	public int compareTo(Person other)
	{
		if(this.getName().compareTo(other.getName())>0)
		{
			return 1;
		}
		else if(this.getName().compareTo(other.getName())<0)
		{
			return -1;
		}
		return 0;
	}
	
	public static String getStuList()
	{
		String list = "";
		for(Person el: allPeople)
		{
			
			if(el instanceof Student)
			{
				list+=el.toString();
			}
		}
		return list;
		
	}
	
	public static String getAdvList()
	{
		String list = "";
		for(Person el: allPeople)
		{
			
			if(el instanceof Advisor)
			{
				list+=el.toString();
			}
		}
		return list;
		
	}
	
	//lab 6 addition
	public boolean equals(Person other)
	{
		return(this.getName().equalsIgnoreCase(other.getName()));
	}

}
