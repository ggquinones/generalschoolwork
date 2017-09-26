
public class BinaryNode 
{
	private int data;
    private BinaryNode left;
    private BinaryNode right;
    
    
    public BinaryNode(int data, BinaryNode l, BinaryNode r)
    {
    	this.data=data;
    	left=l;
    	right=r;
    }  
    
    public void print( int depth ) {
        int i;
        
        for ( i = 1; i <= depth; i++ )
             System.out.print( "    " );
        	System.out.println( data );
        if  ( left != null )
           left.print( depth+1 );
        else if ( right != null ) {
           for ( i = 1; i <= depth+1; i++ )
              System.out.print( "    " );
           System.out.println( "--" );
        }
        if ( right != null )
           right.print( depth+1 );
        else if ( left != null ) {
           for ( i = 1; i <= depth+1; i++ )
        	   System.out.print( "    " );
           System.out.println( "--" );
        }
        
  }

    public static BinaryNode BSTFactory(int top,int depth) {
        BinaryNode root=new BinaryNode(top,null,null);
        BinaryNode leftChild,rightChild;
        if(depth==0)
        {
        	return root;
        }
        if(depth==1){
            //create 2 children left and right
            leftChild=new BinaryNode(top-1,null,null);
            rightChild=new BinaryNode(top+1,null,null);
            root=new BinaryNode(top,leftChild,rightChild);
            return root;
        }
        if(depth>1){

            leftChild=BSTFactory(top-1,depth-1);
            rightChild=BSTFactory(top+1,depth-1);
            root=new BinaryNode(top,leftChild,rightChild);
            return root;
        }
        return root;
    }


}
