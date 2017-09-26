/*
 * Gabriel Quiñones-Sanchez 
 * CS260 Dr.Petruska
 * Homework 1
 * 
 * This is the application class for homework 1. Runs through the methods of
 * the Average class to check that they work.
 */
public class Application 
{

	public static void main(String[] args)
	{
		Integer [] integers = {3,3,3};
		Double  [] doubles = {1.0,2.0,3.0,4.0,5.0};
		float a = 1;
		float b = 2;
		Float   [] floats  = {a,b};
		byte c = 1;
		byte d= 3;
		Byte [] bytes = {c,d};
		
		Average<Integer> numsI = new Average<Integer>(integers);
		Average<Double> numsD = new Average<Double>(doubles);
		Average<Float> numsF = new Average<Float>(floats);
		Average<Byte> numsB = new Average<Byte>(bytes);
		
		System.out.println("Averages\n");
		System.out.println("Integers "+numsI.computeAverage());
		System.out.println("Doubles "+numsD.computeAverage());
		System.out.println("Floats "+numsF.computeAverage());
		System.out.println("Bytes "+numsB.computeAverage());
		
		System.out.println("\nComparisons\n");
		
		System.out.println("Integer and Double "+Average.compareAverages(numsI,numsD));
		System.out.println("Integer and Float "+Average.compareAverages(numsI,numsF));
		System.out.println("Integer and Byte "+Average.compareAverages(numsI,numsB));
		System.out.println("Double and Float "+Average.compareAverages(numsD,numsF));
		System.out.println("Double and Byte "+Average.compareAverages(numsD,numsB));
		System.out.println("Float and Byte "+Average.compareAverages(numsF,numsB));
		
	}

}
