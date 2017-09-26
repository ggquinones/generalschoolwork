package quingg01_lab02;

public class Sorter 
{

	public static void main(String [] args)
	{
		int [] arr={7,3,1,5,5,4,8,7,10,15,49};
		int[]b=sort(arr);
		for(int el:b)
		{
			System.out.println(el);
		}
		System.out.println();

		for(int el:arr)
		{
			System.out.println(el);
		}
		
	}
	public static int[] sort(int[] arr)
	{
		int [] sorted = new int[arr.length];
		for(int i =0, time=1;i<arr.length;i++,time++)
		{
			int temp = arr[0];
			removeFirst(time,arr);
			add(temp,sorted);
		}
		return sorted;
	}
	
	public static void removeFirst(int time, int[] arr)
	{
		for(int i =0;i<arr.length-1;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[arr.length-time]=0;
	}
	
	public static void add(int num, int[] arr)
	{
		int spot=findSpot(num,arr);
		if(arr[spot]==0)
		{
			arr[spot]=num;
		}
		else if(arr[spot]!=0)
		{
			shiftRight(spot,arr);
			arr[spot]=num;
		}
	}
	
	public static int findSpot(int num,int[] sorted)
	{
		for(int i =0;i<sorted.length;i++)
		{
			if(sorted[i]==0 || num<sorted[i])
			{
				return i;
			}
		}
		return sorted.length-1;
	}

	public static void shiftRight(int spt, int[] sorted)
	{
		
		for( int i =sorted.length-2; i >= spt ; i-- )
            sorted[i+1] = sorted[i];
		
	}












}