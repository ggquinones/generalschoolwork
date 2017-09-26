/*
 * Gabriel Quinones
 * Senior Capstone Project
 * Start Date: 9/13/16
 * 
 * This program is meant to go through a file with a plethora of text files in it.
 * The program's goal is to, for each text file, extract the book name, and save the text file
 * with that book name as its title(bookName.txt)
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String [] args) throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		File directory = new File("C:/Users/Gabriel/Desktop/batchbooks");
		String flag ="NOPE";
		int ct=1;
		for (File currFile : directory.listFiles()) 
		{			
			
			//PrintWriter outFile = new PrintWriter("c:\\users\\gabriel\\desktop\\Trans\\"+currFile.getName());
		    Scanner fileReader = new Scanner(currFile);
		    
		    while(fileReader.hasNext())
			{
		    	//System.out.println("IN WHILE");
		    	String nextL =fileReader.nextLine();		    	
		    	if(nextL.contains("[The End]")|| nextL.contains("End of this Project Gutenberg Etext of")||nextL.contains("*** END OF THE PROJECT GUTENBERG EBOOK")||nextL.contains("*** END OF THIS PROJECT GUTENBERG EBOOK") || nextL.contains("***END OF THE PROJECT GUTENBERG EBOOK") || nextL.contains("End of Project Gutenberg Etext")||nextL.contains("End of The Project Gutenberg Etext"))
				{					
					flag = "FOUND";
					break;
				}
		    	else
		    	{
		    		
		    		//outFile.println(nextL);
		    	}
		    								
			}
		    
		    if(flag.equals("NOPE"))
		    {
		    	System.out.println(ct+"\t"+currFile.getName());
		    	ct++;
		    }
		    flag="NOPE";
		    //outFile.close();		    	
		    fileReader.close();
		    
		}// end of for loop
		
		
		
		
		
		
		
		
		/*
		
		
		code to change file names
		try{
		    	
		    	File namedFile = new File("C:/Users/Gabriel/Desktop/batchbooks/"+temp+".txt");
				Files.move(currFile.toPath(),namedFile.toPath());
		    }catch(FileAlreadyExistsException e){}
		    catch(NoSuchFileException ex){}	
		
		temp=fileReader.nextLine();
					//temp=temp.substring(1);		
					temp=temp.replace("START OF THIS PROJECT GUTENBERG EBOOK", "");
					//temp=temp.replace("OF", "");
					temp=temp.replace("THIS", "");
					temp=temp.replace("PROJECT", "");
					temp=temp.replace("GUTENBERG", "");
					temp=temp.replace("EBOOK", "");
					temp=temp.replace("***", "");
					//temp=temp.replace("THE", "");
					temp=temp.replace("", "_");
					temp.trim();
					System.out.println(temp);
					//File namedFile = new File("C:/Users/Gabriel/Desktop/namedbooks/"+temp+".txt");
					//Files.move(currFile.toPath(),namedFile.toPath());
					//System.out.println(namedFile);
					//System.out.println(currFile.renameTo(namedFile));
					 
					 
					 for(String line:lines)	
		{
			if(line.contains("by "))
			{
				int index = line.indexOf("by");
				//books.add(line.substring(0,index));
				//authors.add(line.substring(index+3));
				//System.out.println("Title: "+line.substring(0,index));
				//System.out.println("Author: "+line.substring(index+3));
			}
			
		}
		*/
		
	}
}
