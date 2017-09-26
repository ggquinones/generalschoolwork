package quingg01_lab01;

/**
 * Gabriel Quiñones-Sanchez
 * CS-160-03 Fall 2014
 * Lab 1
 *
 *This class is responsible for printing out a given pattern of stars to the console using one 
 *Print statement.
 */

public class StarPattern 
{

	public static void main(String [] lol) 
	{
		// TODO Auto-generated method stub
		String symbol = new String("*");
		String newLine = new String("\n");
		String space = new String(" ");
		String pattern= new String
				(symbol + newLine 
				+ symbol+ space + symbol+ space +symbol+ space + newLine 
				+symbol+ space + symbol+ space +symbol+ space + symbol+ space + symbol+newLine
				+space+space+space+space+ symbol+ space + symbol+ space +symbol+ space + newLine
				+space+space+space+space+space+space+space+space+ symbol);		
		
		
		System.out.print(pattern);
		System.out.println(newLine+newLine);
		System.out.print("This program was created by Gabriel Quiñones Sanchez on September 8th, 2014");

	}
	/*
	 * Part C)
	 * 1) Error: Main method not found in class quingg01_lab01.StarPattern, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

	 * 2) Error: Main method not found in class quingg01_lab01.StarPattern, please define the main method as:
   		public static void main(String[] args)
		or a JavaFX application class must extend javafx.application.Application
	 * 
	 * 3) Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	string cannot be resolved to a type

	at quingg01_lab01.StarPattern.main(StarPattern.java:18)
	
	4) No error message
	
	5) Error: Main method not found in class quingg01_lab01.StarPattern, please define the main method as:
   	public static void main(String[] args)
	or a JavaFX application class must extend javafx.application.Application

6) Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	system cannot be resolved
	
7)Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Systemout cannot be resolved
	
	8) Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Syntax error, insert ";" to complete Statement
	
	9)Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	String literal is not properly closed by a double-quote
	 * 
	 */

}

