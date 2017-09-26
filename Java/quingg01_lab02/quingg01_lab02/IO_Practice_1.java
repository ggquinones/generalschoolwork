package quingg01_lab02;
import java.util.Scanner;
/*
 * Gabriel Quiñones-Sanchez
 * CS160-01 Fall 2014
 * Lab 2
 *
 */ 


public class IO_Practice_1 {


	public static void main(String[] args) {
		//write code here to declare a String type variable 'name'
		String name;
				
				
		//write code here to declare an integer variable 'size'
				
				int size;
				
		//write code here to declare a char type variable 'letter'
				
				char letter;
				
		//declare a Scanner and instantiate a Scanner object to read data from the console
		//find the syntax on page 84 of your book
				
				Scanner keyboard = new Scanner(System.in);
				
		/*Print the message "Enter your name: " to the console to solicit a name.
		  Use the Scanner object and the nextLine( ) method of the Scanner class
		  Assign the value to the variable 'name'.
		  For a template of these operations see the Example Usage on page 86 of your book.
		  A sample for the console input is shown on Figure 1 
		*/
				
				System.out.println("Enter your name:");
				name = keyboard.nextLine();
				
		//Write code here to get the length of the input string and assign the result to variable'size'
		//For templates of using string methods see page 74 of your textbook
				
				size = name.length();
				
		//Write code here to get the first character of the input string and assign the result to variable 'letter'
				
				letter = name.charAt(0);
				
		//Print the message of Figure 2 to the console
				
				System.out.println("The name is "+ name +"\n\nThe length of this name is: " +size+ 
						
						"\n\nThe first character of the name is " + letter );
				
		//Write code here to get the last character of the input string and assign the result to variable 'letter'
		//Note that the index of the last character of the string is size-1;
				
				letter = name.charAt(size-1);
						
		//Print a message to the console showing the last character
						
				System.out.println("\nThe last character of the name is "+ letter);
						
		//Write code here to get the character of index 10 of the input string and assign the result to variable 'letter'
						
				letter = name.charAt(10);
						
		//Print a message to the console showing the character of index 11 of the name
						
				System.out.println("\nThe 11th character of the name is "+ letter); 
						
		//Write code here to get the all upper case version of the name and assign the result to name.
						
				name = name.toUpperCase();
						
		//Print a message to the console showing the upper case version
						
				System.out.println("\nThe name in all upper case is " + name);
						
		//Write code here to get the all lower case version of the name and assign the result to name.
						
				name = name.toLowerCase();
		//Print a message to the console showing the upper case version
						
				System.out.println("\nThe name in all lower case is " + name);
						
		//A template showing all the work on the console is displayed in Figure 3

	}// end main

}//end class


