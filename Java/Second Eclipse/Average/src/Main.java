
public class Main 
{

	public static void main(String[] args) 
	{
		/*
		 * create array of different wrapper classes
		 * Integer, Float, Long, Byte, each with different
		 * numbers inside the array and not all necessarily
		 * the same size
		 */
		Integer ints[] = {1,2,3,4,5,6};
		Float flo[] = {6F,7F,8F,9F,10F};
		Long lon[] = {12L,23L,85L,19L,21L};
		Byte bye[] = {5,1,3,2,5,6,4,3,2,4};
		
		/*
		 * Create and instantiate the average class with
		 * different wrapper classes in them, all four are
		 * from the arrays created above
		 */
		Average<Integer> testInt = new Average<Integer>(ints);
		Average<Float> testFlo = new Average<Float>(flo);
		Average<Long> testLon = new Average<Long>(lon);
		Average<Byte> testBye = new Average<Byte>(bye);
		
		/*
		 * Prints out the average of all the arrays using the
		 * computeAverage method from the Average class
		 */
		System.out.println(testInt.computeAverage(ints));
		System.out.println(testFlo.computeAverage(flo));
		System.out.println(testLon.computeAverage(lon));
		System.out.println(testBye.computeAverage(bye));
		
		/*
		 * Prints out the boolean result using the compareAverage method
		 * of the Average class to check if the two averages equal each other 
		 */
		System.out.println("\n" + testInt.compareAverages(testInt.computeAverage(ints), testFlo.computeAverage(flo)));
		System.out.println(testInt.compareAverages(testInt.computeAverage(ints), testLon.computeAverage(lon)));
		System.out.println(testInt.compareAverages(testInt.computeAverage(ints), testBye.computeAverage(bye)));
		System.out.println(testInt.compareAverages(testFlo.computeAverage(ints), testLon.computeAverage(lon)));
		
	}

}
