package quingg01_Lab3;
import javax.swing.JOptionPane;


/*
 * Gabriel Quiñones-Sanchez
 * CS160-01 Fall 2014
 * Lab 3
 *
 */


public class RomanNumerals {

	public static void main(String[] args) {
		
		// Displays initial prompt and takes in an input, also initializes decimal
		String text = "Enter a Roman numeral between \"I\" and \"VIII\"";
		
		String roman = JOptionPane.showInputDialog(text);
		
		int decimal =0;
		
		// Assigns integer value to decimal based on input, or 9 for incorrect inputs		
		if(roman.charAt(0)=='I')
		{
			if(roman.equals("I"))
			{
				decimal=1;
			}
			else if(roman.equals("II"))
			{
				decimal=2;
			}
			else if(roman.equals("III"))
			{
				decimal=3;
			}
			else
			{
				decimal=4;
			}
		}
		else if (roman.charAt(0)=='V')
		{  
			
			if(roman.equals("V"))
			{
				decimal=5;
			}
			else if(roman.equals("VI"))
			{
				decimal=6;
			}
			else if(roman.equals("VII"))
			{
				decimal=7;
			}
			else
			{
				decimal=8;
			}
			
		}
		else
		{
			decimal=9;
		}
		
		// Selecting which output message to print to screen 
		if(decimal == 9)
		{
			JOptionPane.showMessageDialog(null, "Input \""+roman+"\"is not an admissible Roman numeral", "Conversion of Roman Numerals", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		else
			JOptionPane.showMessageDialog(null, "The decimal value of your Roman numeral \""+roman+"\" is: "+decimal,"Conversion of Roman Numerals", JOptionPane.INFORMATION_MESSAGE ); 
			System.exit(0);
	}

}





