import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class which makes the Schedules used for TAs and CRNs.
 * Stored as an array of colors green being available and yellow meaning occupied
 * @author Gabriel
 *
 */
public class Schedule implements Serializable{
	private ArrayList<Color> time;
	
	public Schedule(ArrayList<Color> newTimes){
		setTime(newTimes);
	}
	
	public void setTime(ArrayList<Color> newTimes){
		time = newTimes;
	}
	
	public ArrayList<Color> getTime(){
		return time;
	}
	
	
}
