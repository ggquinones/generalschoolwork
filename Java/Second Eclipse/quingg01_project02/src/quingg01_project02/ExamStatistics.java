package quingg01_project02;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Project 2
 *
 */

public class ExamStatistics {
	// Initializes constants for the lower limits of the grades
	final static int LOWERD = 55;
	final static int LOWERC = 65;
	final static int LOWERB = 75;
	final static int LOWERA = 85;
	

	public static void main(String[] args) throws IOException {
	
	/* Initializes instance of a Scanner object to read input file from console,
	 * reads input file name from user, validates file's existence,
	 * keeps asking for a file name until a proper one is inputed.
	 * 
	*/	
	Scanner kb = new Scanner(System.in);	
	System.out.println("Please input file name with a .txt ending");
	String inputFileName = kb.nextLine();
	File inputCheck = new File(inputFileName);
	while(!inputCheck.exists())
	{
		System.out.println("File not found. Please reenter name.");
		inputFileName=kb.nextLine();
		inputCheck=new File(inputFileName);
		
	}	
	
	// Initializes needed variables to calculate Average,PSD, grade counts, and minimum and maximum scores
	
	int next = 0;
	int counter =0;
	int maxScore =0;
	int minScore =100;
	double sum = 0;
	int aCt = 0;
	int bCt = 0;
	int cCt = 0;
	int dCt = 0;
	int fCt = 0;
	
	// Makes instance of a scanner object to read from validated input file
	
	Scanner inputRdr = new Scanner(inputCheck);	
	
	// Goes through input file and takes a count of valid entries,
	// and counts how many are in each grade range, and calculates minimum and maximum scores
	
	while(inputRdr.hasNext())
	{
		next=inputRdr.nextInt();
		if(next>=0 && next<=100)
		{
		counter++;		
		
		sum+=next;
		if(next>maxScore)
		{
			maxScore=next;
		}
		else if(next<minScore)
		{
			minScore=next;
		}
		
		if(next>=LOWERA)
		{
			aCt++;
		}
		else if(next<LOWERA && next>=LOWERB)
		{
			bCt++;
		}
		else if(next<LOWERB && next>=LOWERC)
		{
			cCt++;
		}
		else if(next<LOWERC && next>=LOWERD)
		{
			dCt++;
		}
		else
		{
			fCt++;
		}
		}
	}
	inputRdr.close();
	
	// Calculates average score
	
	double average= ((double)sum/counter);
	
	/* Makes sum 0 again and goes through file again to calculate the summation of 
	*  the squared difference between the average and the current grade being looked at in the input file.
	*  makes another instance of a scanner object to go through input file
	*/
	
	sum =0;
	Scanner inputRdr2 = new Scanner(inputCheck);
	for(int i=0;i<counter;i++)
	{
		next=inputRdr2.nextInt();
		if(next>=0 && next <=100)
		{
			sum+=Math.pow(average-next,2);
			
		}
	}
	inputRdr2.close();
	
	// Calculates population Standard Deviation
	
	double psd= Math.sqrt(sum/counter);
    
	// Makes instance of a DecimalFormat object to round and modify numbers in output, 
	// makes output message, and prints it to the console
	
	DecimalFormat dF = new DecimalFormat("#00.00");
	String outputMessage= ("Exam Statistics\r\n\r\nTotal: "+counter+"\r\nAverage Score: "+dF.format(average)+
			"\r\nPopulation Standard Deviation of the scores: "+dF.format(psd)+"\r\n\r\n"
			+ "# of A, 85-100: "+aCt+"  "+dF.format(((double)aCt/counter)*100)+"%\r\n"
			+ "# of B, 75--84: "+bCt+"  "+dF.format(((double)bCt/counter)*100)+"%\r\n"
			+ "# of C, 65--74: "+cCt+"  "+dF.format(((double)cCt/counter)*100)+"%\r\n"
		    + "# of D, 55--64: "+dCt+"  "+dF.format(((double)dCt/counter)*100)+"%\r\n"
			+ "# of F, 00--54: "+fCt+"  "+dF.format(((double)fCt/counter)*100)+"%\r\n\r\n"
			+ "Minimum Score: "+minScore+"\r\n"
			+ "Maximum Score: "+maxScore);
	System.out.print(outputMessage);
	
	// Makes an instance of a PrintWriter object to write the output message to an output file named ExamStatFile
	PrintWriter outputFile = new PrintWriter("ExamStatFile.txt");
	outputFile.print(outputMessage);
	outputFile.close();
	
	
	
	}

}
