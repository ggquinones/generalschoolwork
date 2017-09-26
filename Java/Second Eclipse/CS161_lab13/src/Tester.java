import java.util.Scanner;


public class Tester 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter an odd number");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		printTop(n/2,1);
		printBottom(0,n);
		
	}
	
	public static void printChar(int n, String s)
	{
		if(n==0)
		{
			return;
		}
		System.out.print(s);
		printChar(n-1,s);
	}
	 
	public static void printTop(int numberOfSpaces, int numberOfStars)
	 {
		 if(numberOfSpaces<1)
		 {
			 return;
		 }
		 printChar(numberOfSpaces," ");
		 printChar(numberOfStars,"*");
		 System.out.println();
		 printTop(numberOfSpaces-1,numberOfStars+2);
	 }
	
	public static void printBottom(int numberOfSpaces, int numberOfStars)
	 {
		 if(numberOfStars<0)
		 {
			 return;
		 }
		 printChar(numberOfSpaces," ");
		 printChar(numberOfStars,"*");
		 System.out.println();
		 printBottom(numberOfSpaces+1,numberOfStars-2);
	 }
	
}
