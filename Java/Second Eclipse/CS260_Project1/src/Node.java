//Project 1
public class Node <E> 
{
	protected E data;
	protected Node<E> link;
	
	 // Constructor initializes data and link of Node
	 public Node(E initialData, Node<E> initialLink)
	 {
	      data = initialData;
	      link = initialLink;
	 }
	 
	// Getter for generic field data
	 public E getData()
	 {
		 return this.data;
	 }
	 
	 // Getter for generic Node type field link
	 public Node<E> getLink()
	 {
		 return this.link;
	 }
	 //Setter for generic Node type field link
	 public void setLink(Node<E> link)
	 {
		 this.link=link;
	 }
	 public void setData(E data)
	 {
		 this.data=data;
	 }
	// adds element to the data structure and returns a reference to the link
	public Node addNodeAfter( E element ) 
	{
		 link = new Node( element, link );
		 return link;
	}
	
	public Node<E> removeNodeAfter( ) 
	{
		return link.link;
	}  
	
	//Node class toString() method which checks for null references
	   public String toString()
	   {
		   String field1="";
		   String field2="";
		   
		   if(data==null)
		   {
			   field1="data: dummy\n";
		   }
		   else
		   {
			   field1="data: "+data.toString()+"\n";
		   }
		   
		   if(link==null)
		   {
			   field2="link: null in tail!\n";
		   }
		   else
		   {
			   field2="link: "+link.toString()+"\n";
		   }
		   
		   return field1+field2;
	   }
	   
	   /**
	    * Compute the number of nodes in a linked list.
	    * param head
	    *   the head reference for a linked list (which may be an empty list
	    *   with a null head)
	    * return
	    *   the number of nodes in the list with the given head 
	    **/   
	    public static <E> int listLength(Node<E> head) {

	       int answer = 0;
	       while(head.link!=null)
	       {
	    	   answer++;
	       }
	         
	       return answer;
	    }
	    
	    /**
	     * Find a node at a specified position in a linked list.
	     * param head
	     *   the head reference for a linked list (which may be an empty list in
	     *   which case the head is null)
	     * param position
	     *   a node number
	     * precondition
	     *   position > 0.
	     * return
	     *   The return value is a reference to the node at the specified position in
	     *   the list. (The head node is position 1, the next node is position 2, and
	     *   so on.) If there is no such position (because the list is too short),
	     *   then the null reference is returned.
	     * exception IllegalArgumentException
	     *   Indicates that position is not positive.    
	     **/   
	     public static <E> Node<E> listPosition(Node<E> head, int position) {
	        
	        if (position <= 0)
	             throw new IllegalArgumentException("position is not positive");
	        
	        Node<E> cursor = head;
	        for (int i = 1; (i < position) && (cursor != null); i++)
	           cursor = cursor.link;

	        return cursor;
	     }
	     
	     public static <E> Node<E> listCopy(Node<E> source) 
	     {
	         
	         // Handle the special case of the empty list.
	         if (source == null)
	            return null;
	            
	         // Make the first node for the newly created list.
	         Node<E> copyHead = new Node<E>(source.data, null);
	         Node<E> copyTail = copyHead;
	         
	         // Make the rest of the nodes for the newly created list.
	         while (source.link != null) {
	            source = source.link;
	            copyTail = copyTail.addNodeAfter(source.data); 
	           // copyTail = copyTail.link;
	         }
	    
	         // Return the head reference for the new list.
	         return copyHead;
	      }
	     
	     public static <E>  Node<E> getTail(Node<E> startNode)
	     {
	    	 while (startNode.link != null)
	    	 {
	    		
		           startNode=startNode.link;
		     }
	    	 return startNode;
	    	 
	     }
}
