
public class LinkedApplication {

	
	public static void main(String[] args) {
		
		Node<String> head = new Node("Bob",null);
		LinkedSequence<String> linkSeq = new LinkedSequence(head);
		linkSeq.addAfter("Tom");
		linkSeq.addAfter("Bill");
		linkSeq.addBefore("Harry");
		linkSeq.advance();
		LinkedSequence<String> newOne = linkSeq.clone();
		//linkSeq.addAll(newOne);
		
		
		Node<Rectangle> rect = new Node(new Rectangle(2,2),null);
		LinkedSequence<Rectangle> rectSeq = new LinkedSequence(rect);
		rectSeq.addAfter(new Rectangle(3,3));
		System.out.println(rectSeq.displayList());
		
		LinkedSequence<Rectangle> rects = new LinkedSequence(new Node(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1),null));
		for(int i=1;i<100000;i++)
		{
			rects.addAfter(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1));
		}
		System.out.println(Node.listPosition(rects.getHead(),100000));
		
		Rectangle[] rectArr = new Rectangle[rects.getItems()];
		
		
		for(int k=0;k<rectArr.length;k++)
		{
			if(rects.getHead().link !=null)
			{
				rectArr[k]=rects.getHead().data;
				head=head.link;
			}
		}
		
		Rectangle target = new Rectangle(15,15);
		long before = System.currentTimeMillis();
		counting(rectArr,target);
		long after =System.currentTimeMillis();
		System.out.println("Time elapsed "+(after-before));
		
		
		LinkedSequence<Rectangle> rects2 = new LinkedSequence(new Node(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1),null));
		for(int i=1;i<1000000;i++)
		{
			rects2.addAfter(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1));
		}
		System.out.println(Node.listPosition(rects2.getHead(),1000000));
		
		Rectangle[] rectArr2 = new Rectangle[rects2.getItems()];
		
		
		for(int k=0;k<rectArr2.length;k++)
		{
			if(rects2.getHead().link !=null)
			{
				rectArr2[k]=rects.getHead().data;
				head=head.link;
			}
		}
				
		 before = System.currentTimeMillis();
		counting(rectArr2,target);
		 after =System.currentTimeMillis();
		System.out.println("Time elapsed "+(after-before));
		
		LinkedSequence<Rectangle> rects3 = new LinkedSequence(new Node(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1),null));
		for(int i=1;i<1000000;i++)
		{
			rects3.addAfter(new Rectangle((int)(Math.random()*30)+1,(int)(Math.random()*30)+1));
		}
		System.out.println(Node.listPosition(rects3.getHead(),1000000));
		
		Rectangle[] rectArr3 = new Rectangle[rects3.getItems()];
		
		
		for(int k=0;k<rectArr2.length;k++)
		{
			if(rects3.getHead().link !=null)
			{
				rectArr3[k]=rects.getHead().data;
				head=head.link;
			}
		}
				
		before = System.currentTimeMillis();
		counting(rectArr3,target);
		after =System.currentTimeMillis();
		System.out.println("Time elapsed "+(after-before));
		
	}
	
	static long squares,occurences;
	 public static void counting(Rectangle[] boxes,  Rectangle target)
	 {
		 for(int i =0;i<boxes.length;i++)
		 {
			 if(boxes[i].equals(target))
			 {
				 occurences++;
			 }
			 if(boxes[i].length == boxes[i].width)
			 {
				squares++; 
			 }
		 }
	 }

}

/*
 * Big Oh estimate : O(n)
 * 
 * It seems the time grew somewhat linearly with how much items were in the respective arrays so Id estimate the time
 * elapsed for 100,000,000 rectangles to be the time elapsed for a million rectangles times 100
 * 
 * 
 * 
 * 
 * 
 */
