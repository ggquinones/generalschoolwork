/*
 * Queue class is an circular array based queue used in the finiding of a path through the maze in the project
 */
public class Queue 
{
	int manyItems, front, rear ; // manyItems is how many things are in the queue front and rear keep track of the front and rear indicies where
								// things are stored in the queue
	Cell cellQueue[]; // circular array of Cells
	
	// constructor intitalizes array
	public Queue(int size)
	{
		cellQueue= new Cell[size];
	}
	// implements circular array
	public int nextIndex(int index)
	{
		return((index+1)%cellQueue.length);
	}
	// ensures capacity (rarely called)
	public void ensureCapacity( int minimumCapacity ) {
	      Cell biggerArray[ ];
	      int n1, n2;
	      if ( cellQueue.length >= minimumCapacity )                                  // No change needed
	         return;
	      else if ( manyItems == 0 )   // Just increase the capacity ignoring array elements
	    	  cellQueue = new Cell[ minimumCapacity ];
	      else if ( front <= rear ) {                            // Create larger array and shift the data
	         biggerArray = new Cell[ minimumCapacity ];
	         System.arraycopy(cellQueue, front, biggerArray, front, manyItems);
	         cellQueue = biggerArray;
	      } else {                                // Create a bigger array with more attention to copying 
	         biggerArray = new Cell[ minimumCapacity ];
	         n1 = cellQueue.length - front;
	         n2 = rear + 1;
	         System.arraycopy(cellQueue, front, biggerArray, 0, n1);
	         System.arraycopy(cellQueue, 0, biggerArray, n1, n2);
	         front = 0;
	         rear = manyItems-1;  
	         cellQueue = biggerArray;
	      }
	   }
// puts Cells at back of queue
	public void enqueue( Cell item ) 
	{
	      if ( manyItems == cellQueue.length )
	            ensureCapacity(manyItems*2 + 1);
	      if ( manyItems == 0 ) 
	      {
	         front = 0;
	         rear = 0;
	      } else
	         rear = nextIndex( rear ); 
	      cellQueue[ rear ] = item;
	      manyItems++;
	}
	// takes stuff from front of queue
	public Cell dequeue( )  
	{
	      Cell answer;
	      
	      if ( manyItems == 0 )
			try {
				throw new NoSuchElementException("Queue Underflow");
			} catch (NoSuchElementException e) {}
	      answer = cellQueue[ front ];
	      front = nextIndex( front );
	      manyItems--;
	      return answer;
	}
	// checks if queue is empty
	public boolean isEmpty()
	{
		return(manyItems==0);
	}

}
// exception used in this class
class NoSuchElementException extends Exception
{
	public NoSuchElementException(String message)
	{
		super(message);
	}
}




