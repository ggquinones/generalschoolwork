import java.io.*;
import java.util.Scanner;


public class MazeApplication 
{
	public static void main(String[]args) throws FileNotFoundException
	{
		// Reads in file inputs names and makes Scanners for the files
		Scanner kb =new Scanner(System.in);
		System.out.println("Enter North South file(include .txt extension): ");
		String name =kb.nextLine();
		File file = new File(name);
		Scanner NSR = new Scanner(file);
		System.out.println("Enter East West file(include .txt extension): ");
		 name =kb.nextLine();
		file = new File(name);
		Scanner EWR = new Scanner(file);
		// reads inlength and width
		int length=EWR.nextInt();
		int width=EWR.nextInt();
		// makes queue and linkedmaze
		Queue pathfinder = new Queue(50);
		LinkedMaze maze = new LinkedMaze(length,width,pathfinder);
		//makes maze, finds path, and displays what path you get
		maze.connectMaze(NSR, EWR);		
		boolean flag=maze.findPath();
		if(flag)
		{
			System.out.println("Solution FOund!");
			//maze.displayPath(); goes into infinite loop
			System.out.print("Max Distance:"+ maze.maxDistance);
		}
		else{
			System.out.println("Solution not FOund!");
			//maze.displayPath(); goes into infinite loop
			System.out.print("Max Distance:"+ maze.maxDistance);
		}
		// error in my find path or my input file or a combination
	}
}
