package quingg01_Lab04;

import javax.swing.JOptionPane;

public class InputValidation {

	public static void main(String[] args) {
		
		// Taking Input
		String text = JOptionPane.showInputDialog("Enter text:");
		
		//Printing out the variable text(input)
		System.out.println(text);
		
		//Checking if input variable text is null
		if(text==null)
		{			
			System.out.println("Input value for text is null");
		}
		
		//int nullLength = text.length();
		
		//Checking if input variable text is empty String
		if(text.equals(""))
		{			
			System.out.println("Input value for text is the empty String");
			System.out.println(text.length());
		}
		
		//Checking if input variable text is neither null nor empty String
		if(!(text == null) && !(text.equals("")) )
		{
			
			System.out.println("Input value for text is not null and not empty String");

		}
		
		// Declaring text1 and text2, and assigning them text to check code is correct.
		// Commented out and replaced with JOptionPane to accept inputs from user.
		//String text1 = "Bob";
		//String text2 = "Paul";
		
		//Taking user inputs for text1 and text2 variables
		String text1 = JOptionPane.showInputDialog("Enter text1:");
		String text2 = JOptionPane.showInputDialog("Enter text2:");
		// Checking that text1 and text2 are admissible Strings
		if((!(text1 == null) && !(text1.equals(""))) && ((!(text2 == null) && !(text2.equals("")) )) )
		{
			System.out.println("Input Strings, text1 \""+text1+"\",and text2 \""+text2+"\", are admissible Strings!");
			
		}
		
		if(text1.equals(text2))
		{
			JOptionPane.showMessageDialog(null,"Input Strings are equal!" ,null, JOptionPane.WARNING_MESSAGE);
		}		
		else
		{
			
			JOptionPane.showMessageDialog(null,"Input Strings are not equal!" ,null, JOptionPane.WARNING_MESSAGE);

		}
	}

}
/* Null Length Error Message
 * 
*Exception in thread "main" java.lang.NullPointerException
	at quingg01_Lab04.InputValidation.main(InputValidation.java:18)
*
*
* Comparing text to null using equals() ERROR message
* 
* Exception in thread "main" null
java.lang.NullPointerException
	at quingg01_Lab04.InputValidation.main(InputValidation.java:13)
	equals() fails because text is null and as such cannot call any String methods such as equals().
	
	Comparing text to empty String using ==
	It fails because these are reference variables. Therefore == checks if they have the same
	reference, not their content. Though legal it is not logically what we are trying to check.
	
	
	
	
*/ 

