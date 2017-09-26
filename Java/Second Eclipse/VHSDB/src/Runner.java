import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {

	public static void main(String[] args) throws FileNotFoundException
	{
		// TODO Auto-generated method stub
		
		boolean DONE =false;
		Scanner kb = new Scanner(System.in);
		String movie="";
		PrintWriter output = new PrintWriter("VHSDB.txt");
		while(!DONE)
		{
			System.out.println("Enter Movie Name or / to exit:");
			movie=kb.nextLine();
			if(movie.equals("/"))
			{
				DONE=true;
				output.close();
				continue;
			}
			else
			{
				output.println(movie);
				System.out.println(movie+" added successfully!");
			}
			
		}
		
		
		
		System.out.println("Program exited!");
	}

}
