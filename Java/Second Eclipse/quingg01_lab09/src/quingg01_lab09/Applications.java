package quingg01_lab09;

import java.text.DecimalFormat;
import java.util.Random;

/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 9
 */
//Class where everything is run. Contains the main method
public class Applications {

	public static void main(String[] args) {
		
		String[]  names={"Collin","Scott","Jordan","Moncho","Brian","Tony","Alex","Mal","Austin","David"};
		
		ArrayPractice AP = new ArrayPractice(names.length,names);
		
		int[] temp=AP.getNumbers();
		System.out.println("Here are the random numbers");
		System.out.println();
		for(int i=0;i<temp.length;i++)
		{
			System.out.print(temp[i]+" ");
		}
		
		
	DecimalFormat dF = new DecimalFormat("#0.0000");
	
	Rectangle[] quad=AP.getRectangles();
	
	System.out.println();
	System.out.println();
	System.out.println("Here are the random rectangle data of length and width:");
	System.out.println();
	for(int i =0;i<quad.length;i++)
	{
		System.out.println(dF.format(quad[i].getLength())+"\t"+dF.format(quad[i].getWidth()));
	}
	System.out.println();
	System.out.println("Here are my friend's names: ");
	System.out.println();
	for(int i =0;i<names.length;i++)
	{
		System.out.print(names[i]+" ");

	}
	
	
	
	
	
	
	
	}
}
