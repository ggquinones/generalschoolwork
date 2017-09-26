

package quingg01_project04;

import java.util.Random;

/* <Gabriel Quiñones>  
 *  CS160 Fall 2014 
 *   * Project 4: Parking Management
 *
 * Application class is where the main method is and it runs the project.
 * 
 */
public class Application {

	public static void main(String[] args) {
		// Declare and Initialize instance of a Random object, int for garage capacity, and int for the limit of
		// iterations
		Random rd = new Random();
		int garageCapacity =15;
		int limitOfIterations =15;
		//Declars and initializes instance of Garage object
		Garage garage = new Garage(garageCapacity);
		
		// initializes counter variable, and fills garage randomly
		int counter =0;
		for(int i=0;i<garage.getCars().length;i++)
		{
			int choice = rd.nextInt(2);
			if(choice==0)
			{
				garage.setCars(new Car(),i);
				counter++;
			}
		}
		 // Initializes instance of Manager object and runs the parkingprocess
		Manager mgr = new Manager(garage,counter);
		mgr.processParking(limitOfIterations);
		

	}

}
