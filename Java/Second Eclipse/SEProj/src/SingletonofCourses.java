import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the Singleton of courses where all courses can be stored and used from
 * Semester to Semester.
 * @author Gabriel
 *
 */
public class SingletonofCourses implements Serializable{
	private static SingletonofCourses courseSingleton = null;
	private static ArrayList<Course> courses;
	
	public static SingletonofCourses getCourseSingleton(){
		if(courseSingleton == null){
			courseSingleton = new SingletonofCourses();
		}
		return courseSingleton;
	}
	
	private SingletonofCourses(){
		
	}
	
	public static ArrayList<Course> getCourseList(){
		return courses;
	}
	
	public static boolean courseExists(Course course){
		for(int i = 0; i < courses.size();i++){
			if(courses.get(i).equals(course)){
				return true;
			}
		}
		return false;
	}
	
	public static void addCourse(Course course){
		courses.add(course);
	}
	
	public static void remove(Course course){
		for(int i = 0; i < courses.size(); i++){
			if(courses.get(i) == course){
				courses.remove(i);
			}
		}
	}
}
