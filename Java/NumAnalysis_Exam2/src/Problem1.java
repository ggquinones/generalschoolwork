
public class Problem1 
{

	public static void main(String[] args) 
	{	
		
		Romberg(0.0,1.0,6);
		System.out.println();
		CompositeSimpsons(0.0, 1.0, 100);
		double h = 1.0/6.0;
		
		double error =  0.842700664*(h*h) + 0.842700793*(h*h*h*h) + 0.842700793*(h*h*h*h*h*h);
		System.out.println("Romberg Error: "+error);
	}
	
	// Exercise One Code
		// Romberg Integration Algorithm
		public static void Romberg(double a, double b, int n)
		{
			//Step 1
			double h= b-a;
			Double [][] R = new Double[n+1][n+1];
			R[1][1]= (h/2)*(F(a)+F(b));
			//end Step 1
			
			//Step 2
			System.out.println(Math.floor(R[1][1])+" ");
			//end Step 2
			
			//Step 3
			for(int i=2;i<=n;i++)
			{
				R[2][1] = (.5)*(R[1][1] + h*Trap(i,h,a)); // step 4
				
				for(int j=2;j<=i;j++)//step 5
				{
					R[2][j]=R[2][j-1] + (R[2][j-1] - R[1][j-1])/(Math.pow(4, j-1)-1);
				
				}
				for(int j=1;j<=i;j++) // step 6
				{
					System.out.printf("%.9f  ",R[2][j]);
				}
				System.out.println();
				h=h/2;//step 7
				for(int j=1;j<=i;j++)
				{
					R[1][j]=R[2][j];
				}
			}// end step 3
					
		}
		
		//Used to approximate f(x) = 1/(xln(x)) at a given num
		public static double F(double num)
		{
			//return (1/(num*Math.log(num)));
			//return Math.sin(num);
			return (2/(Math.sqrt(Math.PI)))*(Math.exp(-(num*num)));
		}
		
		// Trap Approximation used in Romberg Integration
		public static double Trap(int i,double h,double a)
		{
			double sum=0;
			for(int k =1;k<=Math.pow(2, i-2);k++)
			{
				sum+= F(a+(k-0.5)*h);
			}
			return sum;
		}
		
	    public static void CompositeSimpsons(double a, double b, int n)
	    {
	    	double h = (b-a)/n;// step 1
	    	//step 2
	    	double X0 = func(a) + func(b);
	    	double X1 = 0;
	    	double X2 = 0;
	    	
	    	for(int i =1;i<=n-1;i++)//step 3
	    	{
	    		double X = a +(i*h); // step 4
	    		// step 5
	    		if(i%2 == 0)
	    		{
	    			X2 = X2 +func(X);	    			
	    		}
	    		else
	    		{
	    			X1 = X1 + func(X);
	    		}
	    		
	    	}
	    	double XI = h*( (X0 + (2*X2)+ (4*X1) ))/3.0;
	    	System.out.println(XI);	    	
	    	
	    }
	
	    public static double func(double num)
	    {
	    	return (2/(Math.sqrt(Math.PI)))*Math.exp(-(num*num));
	    }
	
	
	
	

}
