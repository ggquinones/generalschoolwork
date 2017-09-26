
public class Average <T extends Number> 
{
	//After creating a generic class with T
	//Generic number array created
	private T nums[];
	
	/**
	 * Constructor that accepts any type of number
	 * type due to Number being a superclass
	 * assigns parameter to variable created
	 * for the class
	 * @param nums - superclass variable array
	 */
	public Average(T nums[])
	{
		this.nums = nums;
	}

	/**
	 * Method that returns a double yet extends
	 * T as a Number for it to accept any wrapper
	 * class variable, be it Integer or Float or
	 * anything else, then simply computes the average
	 * by using for loop to add then divide by length
	 * of array
	 * @param num - array that will be computed to find average
	 * @return - the average of the array
	 */
	public <T extends Number> double computeAverage(T num[])
	{
		double avg = 0;
		double add = 0;
		int i = 0;
		
		for(i = 0; i < num.length; i++)
		{
			add += num[i].doubleValue();
		}
		
		avg = add/num.length;
		
		return avg;
	}
	
	/**
	 * Boolean method that simply checks to see
	 * if the first average is the same amount
	 * as the second average, if so return true
	 * else return false
	 * @param avg1 - the first average computed from the computeAverage method
	 * @param avg2 - the second average computed from the computeAverage method
	 * @return - true if both averages are equal, else return false
	 */
	public boolean compareAverages(double avg1, double avg2)
	{
		if(avg1 == avg2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
