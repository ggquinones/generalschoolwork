package quingg01_project04;

/* <Gabriel Quiñones>  
 *  CS160 Fall 2014 
 *   * Project 4: Parking Management
 *
 * Blueprint of Garage class which stores cars. Can park and remove cars, and show the state of the garage.
 * 
 */

public class Garage {
	
	// Data Field: an array of Cars
	private Car[] cars;
	
	// Accessor method which returns the Data Field cars, an array of Cars.
	public Car[] getCars()
	{
		return cars;
	}
	
	// Mutator method which takes two parameters, a Car object,auto, and an integer,index. 
	// The method puts auto in the cars Data Field of the Garage object at index.
	public void setCars(Car auto,int index)
	{
		cars[index]=auto;
	}
	
	// Method which checks if a parking bay is empty.
	// Takes an integer value,k, and returns the boolean value of cars[k]==null
	public boolean isEmpty(int k)
	{
		return cars[k]==null;
	}
	
	// Void method which prints to the console the state of the garage bay.
	// The method prints the indices of the cars array and then under them print
	// 'E'(Empty) for a null space and 'C'(Car) for a non-null array element	
	public void displayState()
	{
		
		for(int i=0;i<cars.length;i++)
		{
			System.out.print(i+"  ");
		}
		System.out.println();
		
		for(int i =0;i<cars.length;i++)
		{
			if(isEmpty(i)==true)
			{
				if(i>=10)
				{
					System.out.print("E   ");
				}
				else
				{
					System.out.print("E  ");
				}
			}
			else
			{
				if(i>=10)
				{
					System.out.print("C   ");
				}
				else
				{
					System.out.print("C  ");
				}
			}
		}
		System.out.println();
		System.out.println();
	}
	
	// Method which takes a Car object, auto, as a parameter, and return an integer value.
	// The method goes through the cars Data Field of the Garage class and checks if each index is empty.
	// If the cars array is full the method returns -1, if not, the method will place auto to the first empty
	// space and returns the index of the space.
	public int park(Car auto)
	{
		for(int i=0;i<cars.length;i++)
		{
			if(isEmpty(i)==true)
			{
				cars[i]=auto;
				return i;
			}
			
		}
		return -1;
	}
	
	// Method which takes an integer parameter,index.Computes the elapsed parking time of the elements cars[index],
	// assigns null to the bay of index and returns the elapsed time in seconds.
	public double remove(int index)
	{
		
		double timeNow=System.currentTimeMillis();
		double timeElapsed= timeNow-(cars[index].getTime());
		cars[index]=null;
		return timeElapsed/1000;
		
	}
	
	
	
	public int findBayOfCar(int carNumber)
	{ 
		
		int count=0;
		int index=-1;
		for(int i=0;i<cars.length;i++)
		{
			index++;
			if(isEmpty(index)==false)
			{
				count++;
				if(count==carNumber)
				{
					break;
				}
			}
		}
		return index;
	}
	// Garage class constructor which instantiates the cars Data Field to length of integer parameter, capacity.
	public Garage(int capacity)
	{
		cars= new Car[capacity];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
