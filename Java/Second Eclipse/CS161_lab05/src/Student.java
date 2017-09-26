
public class Student extends Person 
{
	
	private Advisor advisor;
	
	public Student(String name, int number, String address, Advisor advisor)
	{
		super(name,number,address);
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
