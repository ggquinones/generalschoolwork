import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the Professor class which creates instances of Professors
 * which teach specific CRNs.
 * @author Gabriel
 *
 */
public class Professor implements Serializable {
	private ArrayList<String> professors;
	private static Professor profSingleton = null;
	
	public static Professor profSingleton(){
		if(profSingleton == null){
			profSingleton = new Professor();
		}
		return profSingleton;
	}
	
	private Professor(){
		professors = null;
	}
	
	public void addProfessor(String prof){
		boolean exists = false;
		for(int i = 0; i < professors.size();i++){
			if(professors.get(i).equals(prof)){
				exists = true;
			}
		}
		if(!exists){
			professors.add(prof);
		}
	}
	
	public ArrayList<String> getProfessors(){
		return professors;
	}
	
	public void removeProfessor(String prof){
		for(int i = 0; i < professors.size(); i++){
			if(professors.get(i) == prof){
				professors.remove(i);
			}
		}
	}
}
