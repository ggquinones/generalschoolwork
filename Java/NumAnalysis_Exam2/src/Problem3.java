
public class Problem3 
{

	public static void main(String[] args) 
	{
		// Change 3rd parameter to change step size
		TaylorMethodOrder2(0.0,3.0,200,48.0);
		
	}

	public static void TaylorMethodOrder2(double a,double b,int N,double OMEGA)
	{
		double h =(b-a)/N;
		double t = a;
		double w = OMEGA;
		System.out.printf("t\t\tw\n%.2f\t%.2f\n",t,w);		
		for(int i =1;i<=N;i++)
		{
			w = w + (h)*T2(w,h,i) ;
			t= a+i*h;
			if(i%3 == 0) // Used to filter output when testing
			System.out.printf("%.3f\t%.2f\n",t,w);
		}		
	}
	
	//Taylor Function of Order 2 using the upward motion equation
	static double func(double w,double h)
	{
		double m,k,g;
		m = 0.11;
		k = 0.002;
		g = 9.8;
		return ((-2.0 *m*m*g) + (-2.0*m*k*w*w) + (2.0*k*h*m*g) + (2*k*k*h*w*w))/(2.0*m*m);
	}
	// Taylor Function using the formula in the book with the absolute value
	static double T2(double v,double h, int i)
	{
		double m,k,g;
		m = 0.11;
		k = 0.002;
		g = 9.8;		
		return (((-m*g)-(k*v*Math.abs(v)))/m) + (h/2.0)*((-2*k*Math.abs(v)/(m))+ (i/10.0));
	}
}
