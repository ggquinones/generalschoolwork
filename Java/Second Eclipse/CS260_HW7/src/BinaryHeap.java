
public class BinaryHeap {

	private String []  heap;
	private int manyItems,pos;
	
	public BinaryHeap(int capacity)
	{
		pos=0;
		heap=new String[capacity];
	}
	
	public void add(String value)
	{
		if(pos==heap.length)
		{
			ensureCapacity();
		}
		
			heap[pos]=value;
			pos++;
			manyItems++;
			int child = pos-1;// value added
			int parent =child/2; // value added parent
			 try
			 {
				 while(heap[parent].compareTo(heap[child])<0 && parent>=0)
				 {
					 String temp=heap[parent];
					 heap[parent]=heap[child];
					 heap[child]=temp;
					 child=parent ;
					 parent=child/2;
				 }
			 }catch(NullPointerException e){}
			 
			
		
	}
	public String remove()
	{
		String answer=heap[0];
		heap[0]=getLeftmostData();
		removeLeftmostData();
		//while (( node of d is not a leaf ) && ( d < data in either of d’s children ))
		//swap d with the data in the largest child
		siftDown(0);
		
				
		
		return answer;
	}
	
	private void siftDown(int nodeIndex) { 

        int leftChildIndex, rightChildIndex, minIndex; 
        String tmp;

        leftChildIndex =(2*nodeIndex) +1; 

        rightChildIndex = (2*nodeIndex) +2; 

        if (rightChildIndex >= manyItems) { 

              if (leftChildIndex >= manyItems) 

                    return; 

              else 

                    minIndex = leftChildIndex; 

        } else { 

              if (heap[leftChildIndex].compareTo(heap[rightChildIndex])<=0 ) 

                    minIndex = leftChildIndex; 

              else 

                    minIndex = rightChildIndex; 

        } 

        if (heap[nodeIndex].compareTo(heap[minIndex])>0  ) { 

              tmp = heap[minIndex]; 

              heap[minIndex] = heap[nodeIndex]; 

              heap[nodeIndex] = tmp; 

              siftDown(minIndex); 

        } 

  } 



	
	public String getLeftmostData( ) {
	     String answer=null;
	     int marker=0;
	     int leftNode = (2*marker)+1;
	     while(leftNode<heap.length )
	     {
	    	 marker=leftNode;
	    	 leftNode=(2*marker) +1;
	     }
	     answer=heap[marker];
	     return answer;
	}

	public void removeLeftmostData()
	{
		int marker=0;
	     int leftNode = (2*marker)+1;
	     while(leftNode<heap.length )
	     {
	    	 marker=leftNode;
	    	 leftNode=(2*marker) +1;
	     }
	     heap[marker]=null;
	}
	// goes through array from 0 to last index
	public String toString()
	{
		String answer="";
		for(int i=0;i<manyItems;i++)
		{
			answer+=heap[i]+" ";
		}
		return answer;
	}
	
	public void ensureCapacity()
	{
		int newSize=heap.length*2;
		String [] newHeap = new String[newSize];
		for(int i=0;i<manyItems;i++)
		{
			newHeap[i]=heap[i];
		}
		heap=newHeap;
	}
	
	/*
	 * 7.	Implement a method named heapFactory ( ).
	 *  The method takes an array of Strings for parameter and by calling the add() method repeatedly, heapFactory( )
	 *   adds all the array elements to this heap. The method must also work if the heap is empty. It is a precondition
	 *   , however, that the base array of the heap is not null.
	 */
	public void heapFactory(String[] words)
	{
		for(int i =0;i<words.length;i++)
		{
			add(words[i]);
		}
	}
	public void trim()
	{
		if(manyItems==0)
		{
			return;
		}
		else if(manyItems==1)
		{
			remove();
			return;
		}
		else if(manyItems==2) 
		{
		remove();
		remove();
		return;
		}
		else{
			remove();
			remove();
			remove();
			return;
		}
	}
}
