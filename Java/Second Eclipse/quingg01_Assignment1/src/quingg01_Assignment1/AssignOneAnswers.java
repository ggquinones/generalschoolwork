package quingg01_Assignment1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class AssignOneAnswers 
{
	// Q1 Method that takes as input an array of integers and reverses the elements. 
	// The return type is void.	
	
	public void reverse(int [] arr)
	{
		int ct = 1;
		int [] copy=new int[arr.length];
		for(int i=0;i<arr.length;i++ )
		{
			copy[i]=arr[i];
			
		}
		for(int k=0;k<arr.length;k++)
		{
			arr[k]=copy[copy.length-ct];
			ct++;
			
		}
	}
	
	// Q2 Method that takes as input a 2D array of integers and returns the array transposed. 
	
	public int [][] transpose(int [][] arr)
	{
		int rowsInArr=arr.length;
		int colsinArr=arr[0].length;
		int [][] trans = new int [colsinArr][rowsInArr];
		
		for(int i =0;i<arr.length;i++)
		{
			for(int k=0;k<arr[i].length;k++)
			{
				trans[k][i]=arr[i][k];
			}
		}
		
		return trans;
	}
	
	// Q3 Method that takes as input a StringBuffer and randomly shuffles the characters of the StringBuffer.
	// The return type is void.
	
	public void randomize(StringBuffer word)
	{
		ArrayList<Character> chars = new ArrayList<Character>();
		for(int i=0;i<word.length();i++)
		{
			chars.add(word.charAt(i));
		}

		Random rd = new Random();
		int num=0;
		for(int k =0;k<word.length();k++)
		{
			num=rd.nextInt(chars.size());
			word.setCharAt(k,chars.get(num));
			chars.remove(num);
		}
		
	}
	
	// Q4 method (outside the class Employee) that takes as input an 
	// ArrayList of Employee objects and returns the average of their salary.
	
	public double salavg(ArrayList<Employee> emps  )
	{
		double total=0;
		
		for(int k=0;k<emps.size();k++)
		{
			total+= emps.get(k).getSalary();
		}
		return (total/emps.size());
	}

}
