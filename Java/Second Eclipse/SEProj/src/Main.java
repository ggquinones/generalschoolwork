import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
/**
 * This is the main class for the project where the main method is located. 
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
public class Main {
	
	private static boolean loggedIn;
	private static String fileName = "databank.gts";
	private static DataBank dataSingleton;
	private static ArrayList<Semester> semesters = new ArrayList<Semester>();
	private static Semester current;
	private static MainFrame f;
	public static void main(String[] args) {
		loggedIn = false;
		try(
				InputStream file = new FileInputStream("quarks.ser");
			    InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream (buffer);
			){
			dataSingleton = (DataBank) input.readObject();
			System.out.println("Loaded DataSingleton");
			semesters = dataSingleton.getSemesters();
		}catch(ClassNotFoundException ex){
		      System.out.println("class not found");
	    }catch(IOException e){
			dataSingleton = DataBank.getData();
			System.out.println("Created DataSingleton");
		}
		/*
		if(dataSingleton != null){
			System.out.println("loaded");
		}else{
			System.out.println("failed");
		}*/
		semesters.addAll(testSemesters());
		f = new MainFrame();
		f.setVisible(true);
		f.setFocusable(true);
	}
	
	//for testing the semester drop-down
	public static ArrayList<Semester> testSemesters(){
		int year = 2012;
		String[] sem = {"Spring", "Summer", "Fall"};
		ArrayList<Semester> tempSem = new ArrayList<Semester>();
		for(int i = 0; i < 4; i++){
			for(int j =  0; j < 3; j++){
				Semester temp = new Semester(Integer.toString(year + i), sem[j]);
				System.out.println(temp.semesterTag());
				tempSem.add(temp);
			}
		}
		return tempSem;
	}
	
	public static MainFrame getFrame(){
		return f;
	}
	
	public static String getFileName(){
		return fileName;
	}
	
	public static Semester getSemester(int tagIndex){
		return semesters.get(tagIndex);
	}
	
	public static void addNewSemester(Semester newSem){
		if(checkSemesterTagExists(newSem)){
			System.out.println("Semester already exists");
		}else{
			semesters.add(newSem);
		}
	}
	
	public static boolean checkSemesterTagExists(Semester newSem){
		for(int i = 0; i < semesters.size(); i++){
			if(semesters.get(i).semesterTag().equals(newSem.semesterTag())){
				return true;
			}
		}
		return false;
	}
	
	/*public static void allocateIPFWSemesterInfo(FileInputStream file){
		try {
			ArrayList<String[]> info = InputIPFWXLS.getInfo(file);
			for(int i = 0; i < info.size();i++){
				Course course = new Course(info.get(i)[0], info.get(i)[1]);
				
			}
		} catch (IOException e) {
			System.out.println("File format Error");
		}
	}*/
	
	public static boolean getLoggedIn(){
		return loggedIn;
	}
	
	public static void setLoggedIn(boolean set){
		loggedIn = set;
	}
	
	public static Administrator getAdmin(){
		return dataSingleton.getAdmin();
	}
	
	public static SingletonofCourses getCourses(){
		return dataSingleton.getCourses();
	}
	
	public static String[] semTags(){
		ArrayList<String> temp = new ArrayList<String>();
		for(Semester next:semesters){
			temp.add(next.semesterTag());
		}
		String[] semesterTags = new String[temp.size()];
		for(int i = 0; i < temp.size(); i++)
		{
			semesterTags[i] = temp.get(i);
		}
			return semesterTags;
	}
	
	public static void setCurrent(Semester sem){
		current = sem;
	}
	
	public static Semester getCurrent(){
		return current;
		}
	}