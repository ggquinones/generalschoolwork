import java.io.Serializable;

/**
 * The Course class is how a generic class is stored such as CS160. This
 * is different from a CRN which is a specific instance of a class.
 * Fields:
 * String courseName ~ course name such as CS160
 * String courseDescription ~ brief description of course
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
public class Course implements Serializable {
	private String courseName;
	private String courseDescription;
	
	public Course(String newCourse, String newDescription){
		setCourse(newCourse);
		setDescription(newDescription);
	}
	
	public void setCourse(String newCourse){
		courseName = newCourse;
	}
	
	public String getCourse(){
		return courseName;
	}
	
	public void setDescription(String newDescription){
		courseDescription = newDescription;
	}
	
	public String getDescription(){
		return courseDescription;
	}
	
	public boolean equals(Course course){
		if(courseName.equals(course.getCourse())){
			return true;
		}
		return false;
	}
}
