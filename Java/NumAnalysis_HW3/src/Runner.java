
public class Runner 
{

	public static void main(String[] args) 
	{
		
		//NewtonsMethod(Math.PI/4, .00000000001 ,100);
		//SecantMethod(.5,Math.PI/4,.00000000001,100);
		//problem2();
		NewtonsMethod(1.5, Math.pow(10, -4),100);
	}
	
	
	
	
	public static void problem2()
	{
		double [] tolerances = {Math.pow(10, -1),Math.pow(10, -3),Math.pow(10, -5),Math.pow(10, -7),Math.pow(10, -11)};
		for(int i=0;i<tolerances.length;i++)
		{
			NewtonsMethod(1.5,tolerances[i],100);
			System.out.println();
			System.out.println();
		}
	}
	
	
	/*
	 

* SECANT METHOD
	 * Way of approximating a functions roots based on two approximation of the function. Derivative not needed.
	 * Used example from book on p. 71 uses same functions as in the Newton Method below.
	 * Inputs:
	 * double p0 and p1 : approximations of the function
	 * TOL tolerance of answer
	 * NMAX max number of iterations, for safety.
	 * 
	 * OUTPUTS:
	 * 
	 *  
	 *  Procedure success!
 		p=0.7390851493372764
		Iterations to solution 4
		Tolerance 0.001
		
		Procedure success!
		p=0.7390851493372764
		Iterations to solution 4
		Tolerance 1.0E-4
		
		Procedure success!
 		p=0.7390851332150645
		Iterations to solution 5
		Tolerance 1.0E-7
		
		Procedure success!
		p=0.7390851332151607
		Iterations to solution 6
		Tolerance 1.0E-11
		
		Stark difference to Newton's method is the number of iterations needed to find the same approximations.
		This method though is better if differentiating F(x) is difficult.
	 * 
	 * */
	public static void SecantMethod(double p0, double p1, double TOL, int NMAX)
	{
		
		int i = 2;
		double q0 = F(p0);
		double q1 = F(p1);
		System.out.println("Iteration\t\tp0\t\tApproximation(p)\t\tq0\t\tq1");
		while(i <= NMAX )
		{
			double p = p1 - (q1 * ( (p1-p0) / (q1-q0) ) );
			System.out.println(i+"\t\t"+p0+"\t\t"+p+"\t\t"+q0+"\t\t"+q1);
			if(Math.abs(p-p1) < TOL )
			{
				System.out.print("Procedure success!\n p="+p+"\nIterations to solution "+i+"\nTolerance "+TOL);
				return;
			}
			i++;
			p0=p1;
			q0=q1;
			p1=p;
			q1=F(p);
		}
		System.out.print("Procedure Failed.\nIterations"+NMAX+"\nTolerance "+TOL);
		return;
	}
	
	
	// Newton's Method Implementation
	/*	Efficient way of finding the roots of a function. 
	 * Based on Taylor polynomials and needs an approximations.
	 * Inputs:
	 * p0 initial approximation
	 * TOL tolerance to which you would like your answer
	 * NMAX max number of iterations to find answer, for safety
	 * 
	 * Used the example in the book p. 69 with f(x)=cos(x)-x to prove code works.
	 * Used p0 = Math.PI / 4, 
	 * TOL .001,.0001, .0000001, and .00000000001  (RESULTS BELOW),
	 * NMAX =100
	 * p is about .74 as in the book problem
	 * 
	 * OUTPUTS:
	 * 
	 *  Success!! Answer is 0.7390851781060102
 		Found in 2 iterations. With tolerance 0.001
 		
 		Success!! Answer is 0.7390851332151611
 		Found in 3 iterations. With tolerance 1.0E-4
 		
 		Success!! Answer is 0.7390851332151611
 		Found in 3 iterations. With tolerance 1.0E-7
 		
 		Success!! Answer is 0.7390851332151607
 		Found in 4 iterations. With tolerance 1.0E-11
	 * 	.
	 * */
	public static void NewtonsMethod(double p0,double TOL, int NMAX)
	{
		//Setting counter
		int i = 1;
		System.out.println("Iteration\t\tp0\t\tApproximation(p)");
		while(i<=NMAX)
		{
			//Calculating p subscript i
			double p = p0 - (F(p0)/FDERIV(p0));
			System.out.println(i+"\t\t"+p0+"\t\t"+p);
			// Checking if answer found
			if(Math.abs(p-p0)<TOL)
			{
				System.out.print("Success!! Approximation is "+ p+" Found in "+i+" iterations. With tolerance "+TOL);
				return;
			}
			// if not found continues iterations adjusting i and p0 for next iteration
			i++;
			p0 = p;			
		}
		// Failure of method in the given max iterations and tolerance
		System.out.print("Method unsuccessful!! Failed after "+ NMAX+" iterations and tolerance "+TOL);
		return; 
	}
	
	// f(x) 
	public static double F(double x)
	{
		//return(Math.sqrt(Math.pow(x, -2) - 4*x + Math.pow(x, -2) - (2*Math.pow(x, -1)) +5  ));	
		return(x - 2 - (Math.pow(x, -3)) + (Math.pow(x, -2)) );
	}
	// f'(x)
	public static double FDERIV(double x)
	{
		//return((x - 2 - Math.pow(x, -3) +Math.pow(x, -2)) / (Math.sqrt(Math.pow(x, -2) - 4*x + Math.pow(x, -2) - (2*Math.pow(x, -1)) +5  )));	
		return(1+ (3*Math.pow(x, -4)) - (2*Math.pow(x, -3) ));
	}
	
	
	
}
