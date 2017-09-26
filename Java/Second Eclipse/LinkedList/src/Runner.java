
public class Runner 
{

	public static void main(String[] args) 
	{
		
		LinkedList LL = new LinkedList();
		
		LL.addNode_END(5);
		LL.addNode_HEAD(5);
		LL.addNode_HEAD(1114);
		LL.addNode_END(1);
		LL.addNode_END(2);
		LL.addNode_END(3);
		LL.deleteTail();
		LL.deleteHead();
		System.out.print(LL);
	}

}

class LinkedList
{
	Node head = new Node(0,null);

	public void deleteHead()
	{
		if(head.nextNode == null)
		{
			System.out.println("Empty list has no head!");
			return;
		}
		
		Node newHead= head.nextNode.nextNode;
		head.nextNode=newHead;
	}
	
	public void deleteTail()
	{
		if(head.nextNode == null)
		{
			System.out.println("Empty list has no tail!");
			return;
		}
		Node priorNode=null;
		Node currentNode = head;
		while(currentNode.nextNode != null)
		{
			priorNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		priorNode.nextNode = null;
		
	}
	
	
	public void addNode_END(int dataToAdd)
	{
				
		//case of empty list
		if(head.nextNode == null)
		{
			head.nextNode = new Node(dataToAdd, null);
			return;
		}
		Node currentNode = head;
		// finding last Node
		while(currentNode.nextNode != null)
		{
			currentNode =currentNode.nextNode;
		}
		currentNode.nextNode = new Node(dataToAdd, null);
	}
	
	public void addNode_HEAD(int dataToAdd)
	{
		Node temp = head.nextNode;
		head.nextNode = new Node(dataToAdd,temp);
	}
	
	public String toString()
	{
		String answer="";
		Node currentNode = head.nextNode;
		//case of empty list
		if(currentNode == null)
		{
			return "Empty List";
		}
			
		// going up to last node
		while(currentNode.nextNode != null)
		{
			answer += currentNode.data+ " ";
			currentNode =currentNode.nextNode;
			
		}
		
		answer += currentNode.data;
		return answer;
	}
	
}

class Node
{
	int data;
	Node nextNode;
	
	public Node(int data,Node nextNode)
	{
		this.data= data;
		this.nextNode=nextNode;
	}	
}