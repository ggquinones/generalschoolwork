


public class Runner 
{

	public static void main(String[] args) 
	{
		String word = "coffee";
		System.out.println(palindromeCheck(word,0,word.length()-1));
	}

	public static boolean palindromeCheck( String word , int start, int end )
	{
		
		if(start>=end )
		{
			return true;
		}
		
		if(!(word.charAt(start)==word.charAt(end)))
		{
			return false;
			
		}
		
		return palindromeCheck(word,++start,--end);
	} 
		
	
}

   

/*
 *Write a recursive method that takes as input an array. 
 *The method should reverse the array.
 * Add additional parameters to the method as needed.

 */
 

