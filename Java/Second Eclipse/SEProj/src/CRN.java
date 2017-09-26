import java.io.Serializable;

/**
 * This class is how specific course instances are stored. For example,
 * the second section of CS160, as opposed to just the general course CS160.
 * Fields:
 * String courseNumber, courseName, courseDescription ~ CRN descriptive Strings
 * String professor ~ who teaches the course
 * Schedule schedule ~ the schedule of the CRN
 * @author Gabriel
 *
 */
public class CRN implements Serializable{
	private String courseNumber;
	private String courseName;
	private String courseDescription;
	private String professor;
	private Schedule schedule;
	
	public CRN(String newCourseNumber, String newCourseName, String newDescription, Schedule newSchedule){
		setCRN(newCourseNumber);
		setCourseName(newCourseName);
		setDescription(newDescription);
		setSchedule(newSchedule);
	}
	
	public void setCRN(String newCourseNumber){
		courseNumber = newCourseNumber;
	}
	
	public String getCRN(){
		return courseNumber;
	}
	
	public void setCourseName(String newCourseName){
		courseName = newCourseName;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public void setDescription(String newDescription){
		courseDescription = newDescription;
	}
	
	public String getDescription(){
		return courseDescription;
	}
	
	public void setSchedule(Schedule newSchedule){
		schedule = newSchedule;
	}
	
	public Schedule getSchedule(){
		return schedule;
	}
}
