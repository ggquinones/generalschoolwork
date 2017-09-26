
public class NodeApplication 
{

	public static void main(String[] args) 
	{
		Node<String> head = new Node("Paul",null);
		Node<String> tail = head.addNodeAfter("Saul");
		System.out.println(head.toString()); // FIGURE 1

		tail.addNodeAfter("Raul");
		tail.addNodeAfter("mauls");
		head.addNodeAfter("mauls");
		tail.addNodeAfter("Saul");
		
		System.out.println(head.toString()); // FIGURE 2
		
		Node<String> dummy = new Node(null,head);
		
		head=dummy.addNodeAfter("Raul");
		head.addNodeAfter("Paul");
		//head.addNodeAfter("Paul");
		head.addNodeAfter("mauls");
		System.out.println(dummy.toString()); // FIGURE 3
	}

}
