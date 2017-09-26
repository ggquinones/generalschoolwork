import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Person implements Comparable<Person> ,Serializable  
{
	
	private String name;
	private int number;
	private int SSN;
	private String address;
	public static ArrayList<Person> allPeople = new ArrayList<>();
	
	public Person(String name, int number, String address, int SSN)
	{
		this.name=name;
		this.number=number;
		this.address=address;
		this.SSN=SSN;
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
		ArrayList<Student>students = new ArrayList<>();
		
		for(Person el: allPeople)
		{
			
			if(el instanceof Student)
			{
				students.add((Student)el);
			}
		}
		Collections.sort(students);
		String list = "";
		for(Student el: students)
		{		
				list+=el.toString();			
		}
		return list;
		
	}
	
	public static String getAdvList()
	{
		ArrayList<Advisor>advisors = new ArrayList<>();
		
		for(Person el: allPeople)
		{
			
			if(el instanceof Advisor)
			{
				advisors.add((Advisor)el);
			}
		}
		
		Collections.sort(advisors);
		
		String list = "";
		for(Advisor el: advisors)
		{
			list+=el.toString();		
		}
		return list;
		
	}
	
	//lab 6 addition
	public boolean equals(Person other)
	{
		return(this.getName().equalsIgnoreCase(other.getName()));
	}

}
