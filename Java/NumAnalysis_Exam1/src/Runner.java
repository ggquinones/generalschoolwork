public class Runner 
{

	public static void main(String[] args)
	{
		//fixedIteration(10,Math.pow(10, -10),50);
		//HornerArrangment(1.0/60.0);
		//NewtonsMethod(1,Math.pow(10,-16),100);
		//NewtonsDividedDifferencePartA();
		//NewtonsDividedDifferencePartB();
		double [] nums = {16.08554, 12.64465 ,9.863738 ,7.623176 ,5.825013 , 4.389056 };
		System.out.println(fiveMidpoint(nums[1],nums[2],nums[4],nums[5],.2));
	}

	// START OF PROBLEM 1 CODE
	
	// Fixed Iteration Algorithm
	public static void fixedIteration(double p0, double TOL, int maxIterations)
	{
		int i=1;
		
		System.out.println("n\t\tp");
		while(i <= maxIterations)
		{
			double p= G(p0);
			System.out.printf("%d\t\t %.6f\n",i, p);
			if(Math.abs(p-p0)< TOL)
			{
				System.out.printf("Object hits floor at approximately %.6f seconds after release.\n", p);
				return;
			}			
			i=i+1;
			p0=p;
		}
		
		System.out.println("Answer not found to the given tolerance in the given max iterations!");
		
	}
	
	// Helper method to figure out g(t) used in above method (fixedIteration)
	public static double G(double t)
	{
		int s0 =410;		// initial height of object
		double m=0.27,		// weight of object in lbs
			   k=0.0901,	// some coefficient of friction I assume in lb*s/ft			   
			   g=32.17;		// gravity in ft/s^2
		double a = ((k*s0) / (m*g));
		double b = (m / k);
		double c = (-k / m);
		
		return a + b*(1 - Math.exp(c*t));
	}

	// END OF PROBLEM 1 CODE
	
	// START OF PROBLEM 2 CODE
	// Evaluation of Fibonacci expression for the root in terms of powers of 1/60
	public static void HornerArrangment(double x)
	{
		double fibExp = (((((40.0*x + 4.0)*x + 33.0)*x +42.0)*x+7.0)*x +22.0)*x +1.0;
		System.out.printf("Evaluation of Fibonacci expression for the root in terms of powers of 1/60 using the Horner Arrangement "
				+ "is equal to %.15f", fibExp);
		
	}
	
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
		return (Math.pow(x, 3)) + (2*Math.pow(x, 2)) + (10*x) - 20;
	}
	// f'(x)
	public static double FDERIV(double x)
	{
		return (3*Math.pow(x, 2)) + (4*x) + 10;
	}
	
	// END OF PROBLEM 2 CODE
	
	// START OF PROBLEM 3 CODE
	
	public static void NewtonsDividedDifferencePartA()
	{
		
		double [] Xs = {0.0,0.1,0.3,0.6,1.0};
		double [] FX = {-6.0,-5.89483,-5.65014,-5.17788,-4.28172};
		int n = Xs.length;
		double [][] FXs = new double [n][n];
		FXs[0][0] = FX[0];
		FXs[1][0] = FX[1];
		FXs[2][0] = FX[2];
		FXs[3][0] = FX[3];
		FXs[4][0] = FX[4];
		
		
		
		
		for(int i=1;i<n;i++)
		{
			for(int j =1;j<=i;j++)
			{
				
				FXs[i][j] = (FXs[i][j-1] - FXs[i-1][j-1]) / (Xs[i] - Xs[i-j]);
			}
		}
		System.out.println("i\txi");
		for(int i =0;i<FXs.length;i++)
		{
			System.out.print(i+"\t"+Xs[i]+" ");
			for(int j=0;j<FXs[i].length;j++)
			{
				
				if(FXs[i][j] != 0.0)
				{
					System.out.printf("%.7f\t ",FXs[i][j]);
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	public static void NewtonsDividedDifferencePartB()
	{
		
		double [] Xs = {0.0,0.1,0.3,0.6,1.0,1.1};
		double [] FX = {-6.0,-5.89483,-5.65014,-5.17788,-4.28172,-3.99583};
		int n = Xs.length;
		double [][] FXs = new double [n][n];
		FXs[0][0] = FX[0];
		FXs[1][0] = FX[1];
		FXs[2][0] = FX[2];
		FXs[3][0] = FX[3];
		FXs[4][0] = FX[4];
		FXs[5][0] = FX[5];
		
		
		
		
		for(int i=1;i<n;i++)
		{
			for(int j =1;j<=i;j++)
			{
				
				FXs[i][j] = (FXs[i][j-1] - FXs[i-1][j-1]) / (Xs[i] - Xs[i-j]);
			}
		}
		System.out.println("i\txi");
		for(int i =0;i<FXs.length;i++)
		{
			System.out.print(i+"\t"+Xs[i]+" ");
			for(int j=0;j<FXs[i].length;j++)
			{
				
				if(FXs[i][j] != 0.0)
				{
					System.out.printf("%.7f\t ",FXs[i][j]);
				}
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	// END OF PROBLEM 3 CODE
	
	// START PROBLEM 5 CODE
	
	// x1= end-point x2=next x3=next after that
	public static double threeEndpoint(double x1,double x2,double x3, double h)
	{
		
		return (1/(2*h))* ((-3*x1) +(4*x2)- (x3) );
	}
	// x1= point after selected point x2=point before
	public static double threeMidpoint(double x1,double x2, double h)
	{
		
		return (1/(2*h))*(x1-x2);
	}
	
	public static double fiveMidpoint(double x1,double x2,double x3,double x4, double h)
	{
		return (1 / (12*h))*(x1 - (8*x2) + (8*x3)-(x4));
	}
	
	public static double fiveEndpoint(double x1,double x2,double x3,double x4,double x5, double h)
	{
		return (1 / (12*h))*((-25*x1) +(48*x2) -(36*x3)+(16*x4)-(3*x5));
	}
	
	// END PROBLEM 5 CODE
}
