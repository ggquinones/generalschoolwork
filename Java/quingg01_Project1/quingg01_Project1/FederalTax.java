package quingg01_Project1;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 * Gabriel Quiñones-Sanchez
 * CS160-01 Fall 2014
 * Project 1
 *
 */

public class FederalTax {
	

	public static void main(String[] args) {		
		
		//Declaring (and initializing) needed variables and objects for program.
		Scanner keyboard = new Scanner(System.in);
		double taxValue = 0;
		String message;
		
		String taxPayerName;
		int income=0;
		int filingStatus;
		
		// Asking for Name, Marriage Status, and Income from user.
		System.out.println("Enter your name:");
		taxPayerName = keyboard.nextLine();
		
		System.out.println("Enter 1 if you are single, 2 if you are married:");
		filingStatus = keyboard.nextInt();
		
		//Checking validity of marriage status.
		if(filingStatus != 1 && filingStatus != 2)
		{
			JOptionPane.showMessageDialog(null, "Marriage status not recognized!\nRestart the program!","ERROR", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			
		}
		
		String input = JOptionPane.showInputDialog("Enter the taxable income:");
		
		// Checking if income input is null, if not assigning parsed value to variable income.
		if(input.equals(""))
		{
			JOptionPane.showMessageDialog(null, "There is no value for income!\nRestart the program!","ERROR", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		else
		income = Integer.parseInt(input); 
		
		// Declaring and Initializing Upper limit constants as well as tax percentage constants.
		int SI1 = 9075;
		int SI2 = 36900;
		int SI3 = 89350;
		int SI4 = 186350;
		int SI5 = 405100;
		int SI6 = 406750;
		
		int MJ1 = 18150;
		int MJ2 = 73800;
		int MJ3 = 148850;
		int MJ4 = 226850;
		int MJ5 = 405100;
		int MJ6 = 457600;
		
		double TR1=.1;		
		double TR2=.15;
		double TR3=.25;
		double TR4=.28;
		double TR5=.33;
		double TR6=.35;
		double TR7=.396;
		
		
		// Calculating tax based on marriage status.
		switch((int)filingStatus)
		{
		case 1:		
			if(income <= SI1)
			{
				taxValue= TR1*(income);
			}
			else if(income > SI1 && income <=SI2)
			{
				taxValue= TR2*(income-SI1)+ TR1*(SI1);
			}
			else if(income > SI2 && income <=SI3)
			{
				taxValue= TR3*(income-SI2)+TR2*(SI2-SI1)+ TR1*(SI1);
			}
			else if(income > SI3 && income <=SI4)
			{
				taxValue= TR4*(income-SI3)+TR3*(SI3-SI2)+TR2*(SI2-SI1)+ TR1*(SI1);
			}
			else if(income > SI4 && income <=SI5)
			{
				taxValue= TR5*(income-SI4)+TR4*(SI4-SI3)+TR3*(SI3-SI2)+TR2*(SI2-SI1)+ TR1*(SI1);
			}	
			else if(income > SI5 && income <=SI6)
			{
				taxValue= TR6*(income-SI5)+TR5*(SI5-SI4)+TR4*(SI4-SI3)+TR3*(SI3-SI2)+TR2*(SI2-SI1)+ TR1*(SI1);
			}	
			else
			{
				taxValue= TR7*(income-SI6)+TR6*(SI6-SI5)+TR5*(SI5-SI4)+TR4*(SI4-SI3)+TR3*(SI3-SI2)+TR2*(SI2-SI1)+ TR1*(SI1);
			}	
			break;
		case 2:
			if(income <= MJ1)
			{
				taxValue= TR1*(income);
			}
			else if(income > MJ1 && income <=MJ2)
			{
				taxValue= TR2*(income-MJ1)+ TR1*(MJ1);
			}
			else if(income > MJ2 && income <=MJ3)
			{
				taxValue= TR3*(income-MJ2)+TR2*(MJ2-MJ1)+ TR1*(MJ1);
			}
			else if(income > MJ3 && income <=MJ4)
			{
				taxValue= TR4*(income-MJ3)+TR3*(MJ3-MJ2)+TR2*(MJ2-MJ1)+ TR1*(MJ1);
			}
			else if(income > MJ4 && income <=MJ5)
			{
				taxValue= TR5*(income-MJ4)+TR4*(MJ4-MJ3)+TR3*(MJ3-MJ2)+TR2*(MJ2-MJ1)+ TR1*(MJ1);
			}	
			else if(income > MJ5 && income <=MJ6)
			{
				taxValue= TR6*(income-MJ5)+TR5*(MJ5-MJ4)+TR4*(MJ4-MJ3)+TR3*(MJ3-MJ2)+TR2*(MJ2-MJ1)+ TR1*(MJ1);
			}	
			else
			{
				taxValue= TR7*(income-MJ6)+TR6*(MJ6-MJ5)+TR5*(MJ5-MJ4)+TR4*(MJ4-MJ3)+TR3*(MJ3-MJ2)+TR2*(MJ2-MJ1)+ TR1*(MJ1);
			}
			break;
			
				
		}
		
		// rounding to two nearest whole number and formatting. 
		DecimalFormat formatter = new DecimalFormat("#0.00");
		String number = formatter.format(Math.rint(taxValue));
		
		 
		
		
		// Final Output Message.
		message= "Name: "+taxPayerName+"\nIncome: "+income+"\nFiling Status: "+filingStatus+"\nTax Calculated: "+number;
		JOptionPane.showMessageDialog(null, message,"Tax Calculator", JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}

}
