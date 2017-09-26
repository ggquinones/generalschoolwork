import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;


public class LinkedListStack <E>
{

	private Node top;
	private Node dummy =new Node(null,null);
	
	/**
	 * Constructor for 
	 */
	public LinkedListStack()
	{
		top=null;
		
	}
	/**
	 * 
	 * @param item
	 */
	public void push(Object item) 
	{
	      top = new Node( item, top );
	      //sortStack();
	}

	
	public int pop() 
	{
		int answer;
	      if ( top == null )
	            throw new EmptyStackException( );
	      answer = (int)top.getData( );
	      top = top.getLink( );
	      return answer;
	}

	public boolean isEmpty()
	{
		if(top==null)
			return true;
		
		return false;
	}
	
	public Object peek()
	{
		if(isEmpty())
		{
			System.err.println("ERROR");
		}
		return  top.getData();
	}
	
	public String displayStack() {

		return top.toString();

	}
	public Node addAfter(int element)
	{
		
		if(top==null)
		{
			top=dummy.addNodeAfter(element);
			
		}
		else
		{
			
			top=top.link;
			top=dummy.addNodeAfter(element);
			
		}
		return top;
	}

}
