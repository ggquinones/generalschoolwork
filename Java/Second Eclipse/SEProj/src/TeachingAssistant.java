import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the Teaching Assistant object class.
 * Fields:
 *   String fName, lName ~ first and last name
	 ArrayList<CRN> tasFor ~ CRNs they TA for
	 double hours ~ how much they work
	 Schedule schedule, personalSchedule ~ work and personal schedule of the TA
 * @author Gabriel
 *
 */
public class TeachingAssistant implements Serializable{
	private String fName, lName;
	private ArrayList<CRN> tasFor;
	private double hours;
	private Schedule schedule, personalSchedule;
	
	public TeachingAssistant(String newFName, String newLName, Schedule newPersonalSchedule){
		setFName(newFName);
		setLName(newLName);
		setPersonalSchedule(newPersonalSchedule);
	}
	public String toString()
	{
		String answer="";
		answer=fName+" "+lName;
		return answer ;
	}
	public void setFName(String newFName){
		fName = newFName;
	}
	
	public String getFName(){
		return fName;
	}
	
	public void setLName(String newLName){
		lName = newLName;
	}
	
	public String getLName(){
		return lName;
	}
	
	public void setSchedule(Schedule newSchedule){
		schedule = newSchedule;
	}
	
	public Schedule getSchedule(){
		return schedule;
	}
	
	public void setPersonalSchedule(Schedule newPersonalSchedule){
		personalSchedule = newPersonalSchedule;
	}
	
	public Schedule getPersonalSchedule(){
		return personalSchedule;
	}
	
	public void addCRN(CRN classToTA){
		tasFor.add(classToTA);
	}
	
	public ArrayList<CRN> getTAsCRN(){
		return tasFor;
	}
	
	public void remove(CRN removeCRN){
		for(int i = 0; i < tasFor.size(); i++){
			if(tasFor.get(i) == removeCRN){
				tasFor.remove(i);
			}
		}
	}
	public boolean equals(TeachingAssistant other)
	{
		return(this.fName.equals(other.getFName()) && this.lName.equals(other.getLName()));
	}
}