import java.util.Random;


public class ArrayPractice 
{

    
    public ArrayPractice()
    {
    
    }
    int[] numbers;
    String[] names;
    Rectangle[]Rectangle;
    public int[] copyNumbers()
    {
        
        int [] temp = new int[numbers.length]; 
                
        for (int i=0; i<temp.length; i++)
        {
            temp[i] = numbers[i];
        }
       return temp;
    }
    public Rectangle[] copyRectangles()
    {
        Rectangle[] temp = new Rectangle[Rectangle.length];
        for (int k = 0; k< temp.length;k++)
        {
            temp [k] = Rectangle[k];
                            
        }
            return temp;
        
    }
    public String[] copyStrings()
    {
      String []temp = new String[names.length];
    for (int k = 0; k< temp.length;k++)
    {
        temp[k] = new String(names[k]);
    }
    return temp;
    }
    
   
    public int[] getnumbers()
    {
      
      return copyNumbers();
     
    }
     
    public String[] getnames()
    {
       
           return copyStrings(); 
   
    }
    
    public Rectangle[] getRectangle()
    {
       
           return copyRectangles();
    }
   public boolean equalsForNumbers(int[]i)
   {
       boolean ifEquals= false;
       
       for(int k =0;k<numbers.length;k++)
       {
           if (i[k]==i[k])
             ifEquals = true;
             return ifEquals;
       }
       return ifEquals;
   }
   public boolean equalsForBoxes(Rectangle[]r)
           {boolean ifEquals=false;
           
               return ifEquals;
           }
   public boolean equalsForNames(String[]s)
           {boolean ifEquals=false;
           if (s.equals(s))
           {
               return ifEquals;
           }
           return ifEquals;
           }
   public boolean equals()
   {
       boolean ifArrayEqual= false;
               
       return ifArrayEqual;
   }
    
    public void loadArray()
    {//assign integer array, and rectangle array 
        //for loop for length
      
        for (int k = 0;k < numbers.length;k++)
      {
      Random rd = new Random();
       int random = rd.nextInt(100)+1;
       numbers[k]= random;
       
      }
      for (int k = 0;k<Rectangle.length;k++)
      {
        Random rd = new Random();
        int num = rd.nextInt(100)+1;
       
        Rectangle[k]=new Rectangle((int)Math.random()*101,
                (int)Math.random()*101);
      }
      
    }
    //constructor
    public ArrayPractice(int shared,String[]array)
    { 
      numbers=new int [shared];
      Rectangle=new Rectangle[shared];
      names= array;
       loadArray();
       
    }
}
