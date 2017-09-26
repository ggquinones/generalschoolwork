package quingg01_lab5;

import javax.swing.JOptionPane;

import java.util.Scanner;
/*
 * Gabriel Quiñones-Sanchez
 * CS160-01 Fall 2014
 * Lab 5
 *
 *This program will take an input String with at least three names and put them in alphabetical order
 *then print the names to the console.
 */

public class OrderStrings {

	public static void main(String[] args) {
		
		// Obtaining input names from user
		String title = "Welcome to the name ordering program";
		String names =  JOptionPane.showInputDialog(null,"Enter the names",title, JOptionPane.QUESTION_MESSAGE);		
		
		// Validating Input
		if(names==null || names.equals(""))
		{			
			System.out.println("Input is not valid; program terminates");
			System.exit(0);
		}
		
		// Breaking up the input String into three separate Strings
		String name1,name2,name3;
		
		Scanner inp = new Scanner(names);
		 name1 = inp.next();
		 name2 = inp.next();
		 name3 = inp.next();
		 inp.close();
		 
		 
		 // Extra strings used when putting list in alphabetical order
		 String first,second,third;
		 first="";
		 second="";
		 third="";
		 
		 // Alphabetizes the list
		 if(name1.compareToIgnoreCase(name2)==0 && name1.compareToIgnoreCase(name3)==0 )
		 {
			 first=name1;
			 second=name2;
			 third=name3;
			 
		 }
		 else if(name1.compareToIgnoreCase(name2)==0)
		 {
			 if(name1.compareToIgnoreCase(name3)<0)
			 {
				 first=second=name1;
				 third=name3;
			 }
			 else
			 {
				 first=name3;
				 third=second=name1;
			 }
		 }
		 else if(name1.compareToIgnoreCase(name3)==0)
		 {
			 if(name1.compareToIgnoreCase(name2)<0)
			 {
				 first=second=name1;
				 third=name2;
			 }
			 else
			 {
				 first=name2;
				 third=second=name1;
			 }
		 }
		 else if(name2.compareToIgnoreCase(name3)==0)
		 {
			 if(name2.compareToIgnoreCase(name1)<0)
			 {
				 first=second=name2;
				 third=name1;
			 }
			 else
			 {
				 first=name1;
				 third=second=name2;
			 }
		 }
		 else if(name1.compareToIgnoreCase(name2)<0 && name1.compareToIgnoreCase(name3)<0)
		 {
			 first=name1;
			 if(name2.compareToIgnoreCase(name3)<0)
			 {
				 second=name2;
				 third=name3;
			 }
			 else
			 {
				 third=name2;
				 second=name3;
			 }
		 }
		 else if(name2.compareToIgnoreCase(name1)<0 && name2.compareToIgnoreCase(name3)<0)
		 {
			 first=name2;
			 if(name1.compareToIgnoreCase(name3)<0)
			 {
				second= name1;
				 third=name3;
			 }
			 else
			 {
				 third=name1;
				 second=name3;
			 }				 			 
		 }
		 else
		 {
			 first=name3;
			 if(name1.compareToIgnoreCase(name2)<0)
			 {
				second= name1;
				 third=name2;
			 }
			 else
			 {
				 third=name1;
				second= name2;
			 }		
			 
		 }
		 
		 String namesOrdered = first+"\t"+second+"\t"+third;
		 System.out.println(namesOrdered);
		
		 
		 
		 
	}

}
