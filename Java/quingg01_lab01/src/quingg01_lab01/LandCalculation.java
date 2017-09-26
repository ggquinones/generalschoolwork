package quingg01_lab01;

/**
 * Gabriel Quiñones-Sanchez
 * CS-160-03 Fall 2014
 * Lab 1
 *
 *This class is responsible for calculating how many acres are in a given plot of land in square feet.
 */

public class LandCalculation {

	public static void main(String[] args) {
		
		int landInSqFt = 389767 ;
		final int CONVERSION_FACTOR =43560; // One acre = 43560 sq ft
		double numberOfAcres= (double)landInSqFt/CONVERSION_FACTOR;
		double numberOfAcres_ROUNDED= (Math.rint((1000*numberOfAcres)))/1000;
		
		System.out.println("The area of land in square feet is "+landInSqFt+ " square feet.");
		System.out.println("The area of land in acres is "+numberOfAcres_ROUNDED+ " acres.");
		
	}

}
