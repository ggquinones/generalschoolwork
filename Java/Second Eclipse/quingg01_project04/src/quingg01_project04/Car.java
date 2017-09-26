package quingg01_project04;

/* <Gabriel Quiñones>  
 *  CS160 Fall 2014 
 *   * Project 4: Parking Management
 * This class describes car objects. A Car object knows it arrival time of occupying a parking bay. Car objects "park"
 * in Garage objects.
 */
public class Car {
	
	// Declaration of Data Field of type long which stores the time a Car object arrives in a parking bay.
	private long timeIn;
	
	// Accessor method which returns the time of arrival of the Car object to the parking bay.
	public long getTime()
	{
		return timeIn;
	}
	
	// Car object constructor which instantiates the data field timeIn of a Car object. 
	public Car()
	{
		timeIn=System.currentTimeMillis();
	}
	
	
	
	
	
	
}
