import java.io.Serializable;


public class Student extends Person implements Serializable 
{
	
	private Advisor advisor;
	
	public Student(String name, int number, String address, Advisor advisor, int SSN)
	{
		super(name,number,address,SSN);
		this.advisor=advisor;
		this.advisor.addStudent(this);
		allPeople.add(this);
	}
	
	public String listAdvisor() //returns the name of the student's advisor
	{
		return advisor.getName();
	}
	
	public String toString() //returns the student name and the advisor name
	{
		return(this.getName()+"\t"+advisor.getName()+"\n");
	}

	// lab 6 addition
	public boolean equals(Student other)
	{
		return(super.equals(other) && this.listAdvisor().equalsIgnoreCase(other.listAdvisor()));
	}
}
