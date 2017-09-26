package quingg01_lab03;

import java.util.ArrayList;

public class Sorter {
	
	public static void main(String [] args)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(4);
		arr.add(6);
		arr.add(3);
		//ArrayList<Integer>arr2=sort(arr);
		//System.out.println(arr);
		System.out.println(sort(arr));
		System.out.println(arr);
	
		
	}
	public static ArrayList<Integer> sort(ArrayList<Integer> ints)
	{
		ArrayList<Integer> sorted = new ArrayList<>();
		int times = ints.size();
		
		for(int i=0;i<times;i++)
		{
			int temp=ints.get(0);
			ints.remove(0);
			int spot = findSpot(temp,sorted);
			setInt(spot,temp,sorted);
			
		}
		
		return sorted;
	}
	public static void setInt(int spt,int el,ArrayList<Integer> arr)
	{
		
			arr.add(spt,el);
	
	}

	public static int findSpot(int var,ArrayList<Integer> arr)
	{
		int spot = 0;
		for(int i=0;i<arr.size();i++)
		{
			if(var<=arr.get(i))
			{
				return spot;
			}
			else
			{
				spot++;
			}
			
		}
		return arr.size();
		
	}
	
	
	
	
	
	
	
}
