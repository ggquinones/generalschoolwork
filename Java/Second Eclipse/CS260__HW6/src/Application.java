
public class Application 
{

	public static void main(String[] args) 
	{
		SimpleNode noItems = null;  // list of length 0
		System.out.println(SimpleNode.Reverse(noItems)); // print reverse of list of length 0
		
		SimpleNode head = new SimpleNode("paul",null);// list of length 1
		System.out.println(SimpleNode.Reverse(head)); // print reverse of list of length 1
		
		SimpleNode tail = head.addNodeAfter("bob");
		tail.addNodeAfter("tim");
		tail.addNodeAfter("joe");
		tail.addNodeAfter("luis");
		System.out.println(SimpleNode.Reverse(head)); // print reverse of list of length 5
		
		SimpleNode head2 = new SimpleNode("paul",null);
		SimpleNode tail2 = head.addNodeAfter("bob");
		tail2 .addNodeAfter("john");
		tail2 .addNodeAfter("zak");
		tail2 .addNodeAfter("gabe");
		tail2 .addNodeAfter("scott");
		tail2 .addNodeAfter("mike");
		tail2.addNodeAfter("tim");
		tail2.addNodeAfter("joe");
		tail2.addNodeAfter("luis");
		System.out.println(SimpleNode.Reverse(head)); // print reverse of list of length 10
		
		BinaryNode root0=BinaryNode.BSTFactory(0, 0);
		root0.print(0);
		System.out.println();
		BinaryNode root1=BinaryNode.BSTFactory(1, 1);
		root1.print(1);
		System.out.println();
		BinaryNode root2=BinaryNode.BSTFactory(1, 2);
		root2.print(0);
		System.out.println();
		BinaryNode root3=BinaryNode.BSTFactory(1, 3);
		root3.print(1);
		System.out.println();
		BinaryNode root4=BinaryNode.BSTFactory(1, 4);
		root4.print(4);
		System.out.println();
		
		
	}

}
