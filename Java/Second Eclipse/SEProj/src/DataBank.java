import java.io.Serializable;
import java.util.ArrayList;
/**
 * This class is where all our data is stored. It holds all the serializable datum which the user will need 
 * from use to use. Things such as Semesters, Teaching Assistants, Professors, courses, etc are saved
 * for future use by the user. The class is a Singleton so only one will ever exist.
 *  Fields:
 *   DataBank dataSingleton ~ Singleton of class used to reference the class
	 ArrayList<Semester> semesters ~ ArrayList of all Semesters in system
	 Administrator admin ~ system Administrator
	 Professor profs ~ all Professors
	 SingletonofCourses courses ~ Singleton of courses used to reference them
 * @author Gabriel
 *
 */
//a singleton designed for easy serialization of all data classes
public class DataBank implements Serializable {
	private static DataBank dataSingleton = null;
	private ArrayList<Semester> semesters = new ArrayList<Semester>();
	private Administrator admin;
	private Professor profs;
	private SingletonofCourses courses;
	
	//singleton accessor method
	public static DataBank getData(){
		if(dataSingleton == null){
			dataSingleton = new DataBank();
		}
		return dataSingleton;
	}

	//private constructor to control the number of instances of the DataBank class
	private DataBank(){
		admin = Administrator.singletonAdmin();
		profs = Professor.profSingleton();
		courses = SingletonofCourses.getCourseSingleton();
	}

	//return Arraylist of Semesters for editing
	public ArrayList<Semester> getSemesters(){
		return semesters;
	}
	
	//replace saved semester data
	public void setSemesters(ArrayList<Semester> newSemesters){
		semesters = newSemesters;
	}
	
	public Administrator getAdmin(){
		return admin;
	}
	
	public void setAdmin(Administrator administrator){
		admin = administrator;
	}
		
	//add a new professor to the list
	public Professor getProf(){
		return profs;
	}
	
	public void setProf(Professor prof){
		profs = prof;
	}
	
	public SingletonofCourses getCourses(){
		return courses;
	}
	
	public void setCourses(SingletonofCourses course){
		courses = course;
	}
	
}
