import java.util.ArrayList;
import java.util.Collections;


public class Advisor extends Person 
{
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public Advisor(String name,int number, String address)
	{
		super(name,number,address);
		allPeople.add(this);
	}
	
	public String listStudents() //returns the names of the advisor's students
	{
		Collections.sort(students);
		String list="";
		for(int i =0;i<students.size();i++)
		{
			list+=students.get(i).getName()+"\n";
		}
		
		return list;
	}
	
	public void addStudent(Student s)
	{
		students.add(s);
	}
	
	public String toString() // returns name of Advisor followed by the result of calling the listStudents() method
	{
		return(this.getName()+"\n"+listStudents()+"\n");
	}
	
	public ArrayList<Student> getStudents()
	{
		return students;
	}

	// lab 6 addition
	public boolean equals(Advisor other)
	{
		Collections.sort(this.students);
		Collections.sort(other.getStudents());
		boolean check=true;
		for(int i = 0;i<this.students.size();i++)
		{
			if(this.students.size()!=other.getStudents().size())
			{
				check=false;
				break;
			}
			else if(!(this.students.get(i).equals(other.getStudents().get(i))))
			{
				check=false;
				break;
			}
		}
		
		return(check && super.equals(other));
	}
}
