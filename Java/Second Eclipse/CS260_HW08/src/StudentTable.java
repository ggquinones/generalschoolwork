
public class StudentTable {
	
	protected Student[] data;
	private ID[] keys;
	private boolean[] hasBeenUsed;
	private int manyItems;
	
	public StudentTable(int size)
	{
		if(size<=0)
		{
			throw new IllegalStateException("Size not valid.");
		}
		data=new Student[size];
		keys=new ID[size];
		hasBeenUsed=new boolean[size];
		manyItems=0;
	}
	
	public int capacity()
	{
		return data.length;
	}
	
	public int size()
	{
		return manyItems;
	}
	
	private int findIndex(ID key)
	{
		int  count =0;
		int i=hash(key);
		
		while((count<data.length)&&(hasBeenUsed[i]))
		{
			if(key.equals(keys[i]))
			{
				return i;
			}
			count++;
			i=nextIndex(i);
		}
		return -1;
	}
	public Student put(Student element)
	{
		int index=findIndex(element.getID());
		Student answer=null;
		
		if(index!= -1)
		{
			answer=data[index];
			data[index]=element;
			return answer;
		}
		else if(manyItems<data.length)
		{
			index=hash(element.getID()); 
			
			while(keys[index] !=null)
			{
				index=nextIndex(index); 
				keys[index]=element.getID();
				data[index]=element;
				hasBeenUsed[index]=true;
				manyItems++;
				return answer;
			}
		}
		else
		{
			throw new IllegalStateException("Table is full.");
		}
		return answer;
	}
	
	
	public Student remove(ID key)
	{
		int index=findIndex(key);
		Student answer=null;
		
		if(index != -1)
		{
			answer= data[index];
			keys[index]=null;
			data[index]=null;
			manyItems--;
		}
		return answer;
	}
	
	public Student get(ID key)
	{
		int index=findIndex(key);
		
		if(index != -1)
		{
			return null;
		}
		else
			return data[index];
	}
	
	public boolean containsKey(ID key)
	{
		return(findIndex(key) != -1);
	}
	
	private int hash(ID key)
	{
		return(Math.abs(key.hashCode()) %data.length);
	}
	
	private int nextIndex(int i)
	{
		if(i+1 == data.length)
		{
			return 0;
		}
		else
			return i+1;
	}
	
}
