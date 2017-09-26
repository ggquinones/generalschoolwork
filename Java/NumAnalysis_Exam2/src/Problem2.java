
public class Problem2 
{

	public static void main(String[] args) 
	{
		// Part a of Exercise 2 with h = 1
		EulersWError(0.0,50.0,50,.01);
		// Part b of Exercise 2 with h = 1 month = 1/12 year
		EulersWError2(0.0,50.0,600,0.01); 
	}

	//Euler's Method with Error used in part a
	public static void EulersWError(double a,double b,int N,double OMEGA)
	{
		double h =(b-a)/N;		
		double t = a;
		double exact = (1 - (0.99 * Math.exp(-0.002*t) ) ); // Exact Solution given in book 		
		double w = OMEGA;
		double absError = Math.abs(exact-w);
		
		System.out.printf("t\t\tw\t\tExact\t\tError\n%f\t%f\t%f\t%f\n",t,w,exact,absError);
		
		for(int i =1;i<=N;i++)
		{
			w = w+ h*F2(t,w);
			t=a+i*h;
			exact = (1 - (0.99 * Math.exp(-0.002*t) ) );
			absError = Math.abs(exact-w);
			System.out.printf("%f\t%f\t%f\t%f\n",t,w,exact,absError);
		}
		
	}
	
	//Euler's Method with Error used in part b
	public static void EulersWError2(double a,double b,int N,double OMEGA)
	{
		double h =(b-a)/N;		
		double t = a;
		double exact = (1 - (0.99 * Math.exp(-0.002*t) ) ); // Exact Solution given in book 		
		double w = OMEGA;
		double absError = Math.abs(exact-w);
		
		System.out.printf("t\t\tw\t\tExact\t\tError\n%f\t%f\t%f\t%f\n",t,w,exact,absError);
		
		for(int i =1;i<=N;i++)
		{
			w = w+ h*F2(t,w);
			t=a+i*h;
			exact = (1 - (0.99 * Math.exp(-0.002*t) ) );
			absError = Math.abs(exact-w);
			if(i%12 == 0 )
				System.out.printf("%f\t%f\t%f\t%f\n",t,w,exact,absError);
		}
		
	}
	
	// represents p'
	public static double F2(double t,double y)
	{
		return (0.002)*(1-y);
	}
}
