package gabriel_quinones_HW3;

public class ArrayBag<T> implements Cloneable
{
   
   private T[ ] data;
   private int manyItems; 
   
     
   public ArrayBag(int initialCapacity)
   {
      if (initialCapacity < 0)
         throw new IllegalArgumentException
         ("The initialCapacity is negative: " + initialCapacity);
      data = (T[]) new Object[initialCapacity];
      manyItems = 0;
   }
        
 
   public ArrayBag(T[] arr)
   {
	   if(arr==null)
	   {
		   throw new IllegalArgumentException("Array inputed is null");
	   }
	   else
	   {
		   setData(arr);
	   }
	   
   }
   
   
   public T[] getData()
   {
	   return this.data;
   }
   
   public void setData(T[]arr)
   {
	   data = (T[]) new Object[arr.length];
	   for(int i=0;i<arr.length;i++)
	   {
		   data[i]=arr[i];
		   manyItems++;
	   }
   }
   
   public T getData(int i)
   {
	   return(data[i]);
   }
   
   public void setData(int i, T obj)
   {
	   data[i]=obj;
	   
   }
   
   
   
   public void add(T element)
   {
      if (manyItems == data.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + 1));
         
      }

      data[manyItems] = element;
      manyItems++;
   }

   public void ensureCapacity(int minimumCapacity)
   {
      T biggerArray[ ];
      
      if (data.length < minimumCapacity)
      {
         biggerArray = (T[]) new Object[minimumCapacity];
         System.arraycopy(data, 0, biggerArray, 0, manyItems);
         data = biggerArray;
         //setData(biggerArray);
      }
   }
  
   
   public void addMany(T... elements)
   {
	   if(elements==null)
	   {
		   return;
	   }
	   else
	   {
		   for(T t : elements)
		   {
			   add(t);
		   }
	   }
   }


   
   public void addAll(ArrayBag<T> addend)
   {
      // If addend is null, then a NullPointerException is thrown.
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.
	   //int temp = manyItems;
	   if(addend==null)
	   {
		   return;
	   }
	   else
	   {
		   for(int i=0;i<addend.getCapacity();i++)
		   {
			   add(addend.getData(i));
		   }
	   }
   }   
   
   
  
   public ArrayBag<T> clone( )
   {  // Clone an ArrayBag object.
      ArrayBag<T> answer;
      
      try
      {
         answer = (ArrayBag<T>) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.data = data.clone( );
      
      return answer;
   }
   

   
   public int countOccurrences(T target)
   {
      int answer;
      int index;
      
      answer = 0;
      for (index = 0; index < manyItems; index++)
         if (target.equals(data[index]) ) // CHANGED from ==
            answer++;
      return answer;
   }


   

   
   public int getCapacity( )
   {
      return data.length;
   }

              
   
   public T grab( )
   {
      int i;
      
      if (manyItems == 0)
         throw new IllegalStateException("Bag size is zero");
         
      i = (int)(Math.random( ) * manyItems) + 1;
      return data[i];
   }
   
  
   public boolean remove(T target)
   {
      int index; // The location of target in the data array.
       
      // First, set index to the location of target in the data array,
      // which could be as small as 0 or as large as manyItems-1; If target
      // is not in the array, then index will be set equal to manyItems;
      if (target == null)
      {  // Find the first occurrence of the null reference in the bag.
	 index = 0;
	 while ((index < manyItems) && (data[index] != null))
            index++;
      }
      else
      {  // Find the first occurrence of the target in the bag.
	 index = 0;
	 while ((index < manyItems) && (!target.equals(data[index])))
            index++;
      }

      if (index == manyItems)
         // The target was not found, so nothing is removed.
         return false;
      else
      {  // The target was found at data[index].
         // So reduce manyItems by 1 and copy the last element onto data[index].
         manyItems--;
         data[index] = data[manyItems];
	 data[manyItems] = null;
         return true;
      }
   }
                 
   
   
   public int size( )
   {
      return manyItems;
   }
   
   
  
   public void trimToSize( )
   {
      T trimmedArray[ ];
      
      if (data.length != manyItems)
      {
         trimmedArray = (T[]) new Object[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      }
   }
   
   public String toString()
   {
	   String printOut="";
	   for(int i = 0;i<data.length;i++)
	   {
		   if(getData(i)==null)
		   {
			   continue;
		   }
		   printOut+=getData(i).toString()+"\t";
	   }
	   return printOut;
   }
       
   public static <T> ArrayBag<T> union(ArrayBag<T> b1, ArrayBag<T> b2)
   {
      // If either b1 or b2 is null, then a NullPointerException is thrown. 
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.   
      ArrayBag<T> answer = new ArrayBag<T>(b1.getCapacity( ) + b2.getCapacity( ));
      
      System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
      System.arraycopy(b2.data, 0, answer.data, b1.manyItems, b2.manyItems);
      answer.manyItems = b1.manyItems + b2.manyItems;
      
      return answer;
   }
   
   public int removeAll(T target)
   {
	   int taken = 0;
	   
	   for(int temp=0;temp<manyItems;temp++)
	   {
		   if(getData(temp).equals(target))
		   {
			   setData(temp,null);
			   taken++;
			   manyItems--;
		   }
	   }
	   return taken;
   }
      
}