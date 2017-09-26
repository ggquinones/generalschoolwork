
public class Rectangle {
	private double length;
    private double width;
    public Rectangle()
    {
        
    }
    public Rectangle(int length, int width)
    {
        this.length = length;
        this.width = width;
    }
    public Rectangle(Rectangle other)
    {
        length = other.length;
        width = other.width;
    }
   
    
    public void setLength(double leng)
    {
        length = leng;
    }
    public void setWidth(double wide)
    {
        width = wide;
    }
    public double getLength()
    {
        return length;
    }
    public double getWidth()
    {
        return width;
    }
    public double computeArea()
    {
        return length*width;
    }
    public boolean equals(Rectangle other)
    {
        boolean ifEqual;
             
        ifEqual=false;
        if (other.length == length )
        {
            if (other.width==width)
            {
                ifEqual= true;
                return ifEqual;
            }
        }
        if (other.width==width)
                {
                    if (other.length == length )
                    {
                        ifEqual = true;
                        return ifEqual;
                    }
                }
        
        return ifEqual;
    }
    public String toString()
    {
        
        String message= "The length of the rectangle is: "+length+
                      "\nThe width of the is: "+width+
                      "\nThe area is: "+computeArea();
        return message;
    }
}

