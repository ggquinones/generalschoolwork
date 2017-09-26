package quingg01_lab09;

import java.util.Random;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 9
 */
//This class is responsible for array manipulations vital to this project.
public class ArrayPractice {

	private int[] numbers;
	private String[] names;
	private Rectangle[] quads;
	//ArrayPractice class constructor takes an int and a String[] as parameters
	public ArrayPractice(int length,String[] b)
	{
		numbers = new int[length];
		quads = new Rectangle[length];
		names=b;
		loadArrays();
	}
	// Void method which assigns random values to the int[] data field and random widths and lengths to the Rectangles in the Rectangle[] data field
	public void loadArrays()
	{
		Random rand = new Random();
		for(int i=0;i<numbers.length;i++)
		{
			
			//numbers[i]= (int)((Math.random()*3)*(numbers.length));
			numbers[i]= (rand.nextInt(numbers.length)+1)*(rand.nextInt(3)+1);//*(numbers.length) ;
			quads[i]=new Rectangle(0,0);
			quads[i].setLength(Math.random());
			quads[i].setWidth(Math.random());
		}
		
	}
	//Method which copies the numbers array which is a data field of the class
	private int[] copyNumbers()
	{
		int [] temp = new int[numbers.length];
		for(int i =0;i<numbers.length;i++)
		{
			temp[i]=numbers[i];
		}
		return temp;
		
	}
//Method which copies the quads array which is a data field of the class
	private Rectangle[] copyRectangles()
	{
		Rectangle[] temp=new Rectangle[quads.length];
		for(int i=0;i<quads.length;i++)
		{
			temp[i]=new Rectangle(quads[i]);
			
		}
		return temp;
	}
	// accessor method that returns a copy of the numbers data field array
	public int[] getNumbers()
	{
		return copyNumbers();
		
	}
	// accessor method that returns a copy of the quads data field array
	public Rectangle[] getRectangles()
	{
		return copyRectangles();
	}
	
}
