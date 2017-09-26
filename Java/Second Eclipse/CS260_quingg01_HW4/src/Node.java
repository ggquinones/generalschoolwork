// Gabriel Quinones HW4 CS260
public class Node<E>
{

   private E data;
   private Node<E> link;   

   // Constructor initializes data and link of Node
   public Node(E initialData, Node<E> initialLink)
   {
      data = initialData;
      link = initialLink;
   }

           
   // adds element to the data structure and returns a reference to the link
   public Node addNodeAfter( E element ) 
   {
	    link = new Node( element, link );
	    return link;
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
   
  
   
   
}
           
