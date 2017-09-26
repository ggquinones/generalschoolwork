
public class TestNode 
{

	//public static void main(String[] args) commented out so the main method in Linked Application works just reverse it to test TestNode
	{
		Node<String> head = new Node("Paul",null);
		head.addNodeAfter("Tom");
		head.addNodeAfter("Bill");
		head.addNodeAfter("Auto");
		
		head.setLink(head.removeNodeAfter());
		System.out.println(head);
		System.out.println(head.getTail(head));
		System.out.println(Node.listCopy(head));
		System.out.println(Node.listLength(head));
		System.out.println(Node.listPosition(head,2));
		
	}

}
