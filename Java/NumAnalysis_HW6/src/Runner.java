
public class Runner 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Romberg(Math.E,2*Math.E,6);
		//Eulers(1.0,2.0,10,(-1.0/Math.log(2)));
		//EulersModWError(1.0,2.0,1000,(-1.0/Math.log(2)));
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
		return (1/(num*Math.log(num)));
		//return Math.sin(num);
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
	// End Exercise One Code
	
	//Exercise Two Code
	//Euler's Method
	public static void Eulers(double a,double b,int N,double OMEGA)
	{
		double h =(b-a)/N;
		double t=a;
		double w = OMEGA;
		System.out.printf("t\t\tw\n%f\t%f\n",t,w);
		for(int i =1;i<=N;i++)
		{
			w = w+ h*F2(t,w);
			t=a+i*h;
			System.out.printf("%f\t%f\n",t,w);
		}
		
	}
	
	//Euler's Method with Error
		public static void EulersWError(double a,double b,int N,double OMEGA)
		{
			double h =(b-a)/N;
			
			double t=a;
			double exact= -1.0/(Math.log(t+1));
			
			double w = OMEGA;
			double absError = Math.abs(exact-w);
			System.out.printf("t\t\tw\t\tError\n%f\t%f\t%f\n",t,w,absError);
			for(int i =1;i<=N;i++)
			{
				w = w+ h*F2(t,w);
				t=a+i*h;
				absError = Math.abs(exact-w);
				System.out.printf("%f\t%f\t%f\n",t,w,absError);
			}
			
		}
	
	public static double F2(double t,double y)
	{
		return(Math.pow(y,2))/(1+t);		
	}
	
	//End Exercise Two Code
	
	
	//start code exercise 3
	
	//Euler's Modified Method with Error
	public static void EulersModWError(double a,double b,int N,double OMEGA)
	{
		double h =(b-a)/N;
		
		double t=a;
		double exact= -1.0/(Math.log(t+1));
		
		double w = OMEGA;
		double absError = Math.abs(exact-w);
		System.out.printf("t\t\tw\t\tError\n%f\t%f\t%f\n",t,w,absError);
		for(int i =1;i<=N;i++)
		{
			w = w+ (h/2)*(F2(t,w)+F2(a+i*h,w  + h*F2(t,w)));
			t=a+i*h;
			absError = Math.abs(exact-w);
			System.out.printf("%f\t%f\t%f\n",t,w,absError);
		}
		
	}
	
	// end code exercise three
}
