import java.io.Serializable;

/**
 * The Administrator class is the class that actually "uses" the Lisatron 3000.
 * The class is a Singleton and has the ability to login and logout.
 * Fields:
 * Administrator administrator ~ Singleton 
 * String username,password ~ used to login and can be changed once logged into the system
 * @author Gabriel Quinones & Trevor Seitz
 *
 */
public class Administrator implements Serializable {

	private static Administrator administrator = null;
	private String username, password;
	
	public static Administrator singletonAdmin(){
		if(administrator == null){
			administrator = new Administrator();
		}
		return administrator;
	}
	
	private Administrator(){
		username = "Admin";
		//System.out.println("Username\t" + username);
		password = "Password";
		//System.out.println("Password\t" + password);
	}
	
	public boolean login(String user, String pass){
		//System.out.println("Username\t" + username + "\tPassword\t" + password);
		if(username.equals(user) && password.equals(pass)){
			return true;
		}
		return false;
	}
	
	public void changeUsername(String user){
		username = user;
	}
	
	public void changePassword(String pass){
		password = pass;
	}
}
