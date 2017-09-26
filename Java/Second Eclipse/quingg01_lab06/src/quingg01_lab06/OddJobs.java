package quingg01_lab06;

import java.util.Scanner;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 6
 *
 */


public class OddJobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initializes Scanner and takes input from console
		Scanner kb = new Scanner(System.in);
		System.out.println("please enter an integer between 21 and 30");
		int days=kb.nextInt();
		// Validates input, and keeps asking for an input until it is correct
		while(days<21 || days>30)
		{
			System.out.println("Input incorrect");
			System.out.println("please enter an integer between 21 and 30");
			days=kb.nextInt();

		}
		int pennies=0;
		// Calculates pennies collected and then puts the number of pennies into dollars and stores it in wages
		for(int i =0;i<days;i++)
		{
			if(pennies==0)
			{
				pennies=1;
			}
			else
			{
				pennies*=2;
			}
			int actualDay=i+1;
			 
			System.out.printf("\n Day"+actualDay+"  %,d",pennies);
			
		}
		double wages = pennies/100.0;
		// Outputs results to console
		System.out.println("\nIn "+days+" days, the CS major earned $"+wages);
		
		/* The CS major I feel made the right choice. Though he makes less if the job takes 21 or 22 
		 * days,$10485.76 and $20971.52, as compared to $21000 and $22000 respectively. He makes
		 *  substantially more if the job takes 23 or more days. He can make $5368709.12 
		 * in 30 days! So I would make the same choice he made.
		 */
	}

}

