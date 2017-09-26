
public class Runner 
{

	public static void main(String[] args) 
	{
		// First problem 10^-2 accuracy
		BisectionMethodProblem1(0,2,Math.pow(10,-2),20);
		System.out.println();
		System.out.println();
		// Second problem 10^-5 accuracy
		BisectionMethodProblem1(0,2,Math.pow(10,-5),20);
		System.out.println();
		System.out.println();
		// Third problem 10^-4 accuracy
		BisectionMethodProblem2(2,3,Math.pow(10,-4),20);

	}
	
	/*  USED FOR FIRST PROBLEM BECAUSE OF DIFFERENT POLYNOMIAL THAN SECOND
	 * Implementation of the Bisection method as described in the book.
	 * Takes in the interval which is being observed, the tolerance to which we wish to evaluate p, and the max number of iterations we would like to
	 * use. This is a safety feature to avoid infinite looping.
	 */
	public static  double BisectionMethodProblem1(double a, double b, double TOL, int maxIterations)
	{
		int i=1;
		double FA,FP,p;
		FA=f(a);
		System.out.println("n\t\t\ta\t\t\tb\t\t\tp\t\t\tf(p)");
		while(i<=maxIterations)
		{
			
			p = (a+b)/2;
			FP=f(p);
			System.out.print(i+"\t\t\t"+a+"\t\t\t"+b+"\t\t\t"+p+"\t\t\t"+FP+"\n");
			if(FP==0 || ((b-a)/2)<TOL)
			{
				System.out.println("\nSolution found! Answer is "+p+" with tolerance of "+TOL);
				
				return(p);
			}
			i++;
			if(FA*FP >0)
			{
				a=p;
				FA=FP;
			}
			else
			{
				b=p;
			}
		}
		System.out.println("COULD NOT FIND SOLUTION");
		return -1.0;
	}
	
	/* USED FOR SECOND PROBLEM BECAUSE OF DIFFERENT POLYNOMIAL THAN FIRST
	 * Implementation of the Bisection method as described in the book.
	 * Takes in the interval which is being observed, the tolerance to which we wish to evaluate p, and the max number of iterations we would like to
	 * use. This is a safety feature to avoid infinite looping.
	 */
	public static  double BisectionMethodProblem2(double a, double b, double TOL, int maxIterations)
	{
		int i=1;
		double FA,FP,p;
		FA=f2(a);
		System.out.println("n\t\t\ta\t\t\tb\t\t\tp\t\t\tf(p)");
		while(i<=maxIterations)
		{
			
			p = (a+b)/2;
			FP=f2(p);
			System.out.print(i+"\t\t\t"+a+"\t\t\t"+b+"\t\t\t"+p+"\t\t\t"+FP+"\n");
			if(FP==0 || ((b-a)/2)<TOL)
			{
				System.out.println("\nSolution found! Answer is "+p+" with tolerance of "+TOL);
				return(p);
			}
			i++;
			if(FA*FP >0)
			{
				a=p;
				FA=FP;
			}
			else
			{
				b=p;
			}
		}
		System.out.println("COULD NOT FIND SOLUTION");
		return -1.0;
	}
	
	/*
	 * Helper method used to evaluate the polynomial used in the FIRST problem at a given x
	 */
	public static double f(double x)
	{
		return((Math.pow(x, 4)) - (2*Math.pow(x, 3)) -(4*Math.pow(x, 2)) +(4*x)+4);		
	}
	
	/*
	 * Helper method used to evaluate the polynomial used in the SECOND problem at a given x
	 */
	public static double f2(double x)
	{
		return( (Math.pow(x, 3)) - 25);		
	}
	
	
}

