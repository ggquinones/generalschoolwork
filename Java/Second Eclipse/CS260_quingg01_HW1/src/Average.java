
/*
 * Gabriel Quiñones-Sanchez 
 * CS260 Dr.Petruska
 * Homework 1
 * 
 * This class has an array of any of the 6 numeric types and can compute its average
 * as well as compare it to the average of other arrays.
 */

public class Average <T extends Number> 
{
	private T[] numbers; // Array of Numbers
	
	//Constructor
	// Takes in an array of Numbers and initializes the classes private field
	public Average(T[] nums)
	{
		for(int i =0;i<nums.length;i++)
		{
			this.numbers=nums;
		}
	}
	
	//Computes the average of an array of numbers
	// returns a double
	public double computeAverage()
	{
		int sum=0;
		for(int i =0;i<numbers.length;i++)
		{
			sum+=numbers[i].doubleValue();
			
		}
		
		return(sum/numbers.length);
	}

	//COmpares the averages of two different arrays
	//return boolean(true if theyre equal and false if not)
	public static boolean compareAverages(Average<?> nums1,Average<?>nums2)
	{
		if(nums1.computeAverage()==nums2.computeAverage())
		{
			return true;
		}
		return false;
	}
}
