
public class Node 
{
	 protected Object data;
	 protected Node link;   

	   // Constructor initializes data and link of Node
	   public Node(Object initialData, Node initialLink)
	   {
	      data = initialData;
	      link = initialLink;
	   }
	   
		// Getter for generic field data
		 public Object getData()
		 {
			 return this.data;
		 }
		 
		 // Getter for generic Node type field link
		 public Node getLink()
		 {
			 return this.link;
		 }
		 
		// adds element to the data structure and returns a reference to the link
		public Node addNodeAfter( Object element ) 
		{
			link = new Node( element, link );
			return link;
		}
		 
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
				   field1="data: "+getData()+"\n";
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
