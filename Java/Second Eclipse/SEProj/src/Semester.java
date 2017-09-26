import java.io.Serializable;
import java.util.ArrayList;
/**
 * Fields:
 *   ArrayList<String> tutoringRooms ~ all the rooms where tutoring is held that semester
	 String year ~ what year it is
	 String semester ~ spring,fall, or summer season
	 ArrayList<TeachingAssistant> teachingAssistants ~ TAs for the semester
	 ArrayList<CRN> crn ~ that semesters specific CRNs
 * @author Gabriel Quinones & Trevor Seitz
 *
 */

public class Semester implements Serializable {
	private ArrayList<String> tutoringRooms;
	private String year;
	private String semester;
	private ArrayList<TeachingAssistant> teachingAssistants;
	private ArrayList<CRN> crn;
	
	public Semester(String year, String newSemester, ArrayList<String> rooms){
		setRooms(rooms);
		setYear(year);
		setSemester(newSemester);
	}
	
	public String toString()
	{
		String answer,rooms,TAs,CRNs;
		rooms="";
		TAs="";
		answer="";
		for(int i =0;i<tutoringRooms.size();i++)
		{
			rooms+=tutoringRooms.get(i)+", ";
		}
		
		for(int i =0;i<teachingAssistants.size();i++)
		{
			TAs+=teachingAssistants.get(i).toString()+", ";
		}
		
		answer=semester+" "+year+"\nTA Rooms:\n"+rooms+"\nTeaching Assistants:\n"+TAs;
		
		
		return answer;
	}
	public Semester(String year, String newSemester){
		setSemester(newSemester);
		setYear(year);
	}
	
	public void setRooms(ArrayList<String> rooms){
		tutoringRooms = rooms;
	}
	
	public void setRooms(String rooms){
			tutoringRooms.add(rooms);
	}
	
	public ArrayList<String> getRooms(){
		return tutoringRooms;
	}
	
	public void setYear(String year){
		this.year = year;
	}
	
	public String getYear(){
		return year;
	}
	
	public void setSemester(String newSemester){
		semester = newSemester;
	}
	
	public String getSemester(){
		return semester;
	}
	
	public void addTeachingAssistant(TeachingAssistant newTA){
		teachingAssistants.add(newTA);
	}
	
	public ArrayList<TeachingAssistant> getTeachingAssistants(){
		return teachingAssistants;
	}
	
	public void addCRN(CRN crn){
		this.crn.add(crn);
	}
	
	public ArrayList<CRN> getCRNs(){
		return crn;
	}
	
	public void remove(String roomNum){
		for(int i = 0; i < tutoringRooms.size(); i++){
			if(tutoringRooms.get(i) == roomNum){
				tutoringRooms.remove(i);
			}
		}
	}
	public void remove(TeachingAssistant ta){
		for(int i = 0; i < teachingAssistants.size(); i++){
			if(teachingAssistants.get(i).equals(ta)){
				teachingAssistants.remove(i);
			}
		}
	}	public void remove(CRN removeCRN){
		for(int i = 0; i < crn.size(); i++){
			if(crn.get(i) == removeCRN){
				crn.remove(i);
			}
		}
	}
	
	public String semesterTag(){
		return year + " " + semester;
	}
}