
public class SimpleNode 
{
	protected String data;
	protected SimpleNode link;
	
	 public SimpleNode(String initialData, SimpleNode initialLink)
	 {
	      data = initialData;
	      link = initialLink;
	 }
	 
	public static SimpleNode Reverse(SimpleNode head)
	{
	    if (head == null) return null; // empty list
	    if (head.link == null) return head; // one item list
	    SimpleNode nextLink = head.link;
	    head.link = null;	   
	    SimpleNode reverseRest = Reverse(nextLink);	  // recursive call
	    nextLink.link = head; 
	    return reverseRest;
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
	
	public static SimpleNode getTail(SimpleNode startNode)
    {
   	 while (startNode.link != null)
   	 {
   		
	           startNode=startNode.link;
	 }
   	 
   	 return startNode;
   	 
    }
	
	public void setLink(SimpleNode link)
	 {
		 this.link=link;
	 }
	 
	 public SimpleNode addNodeAfter( String element ) 
		{
			 link = new SimpleNode( element, link );
			 return link;
		}
}
