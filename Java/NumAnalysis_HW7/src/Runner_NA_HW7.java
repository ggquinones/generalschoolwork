
public class Runner_NA_HW7 
{

	public static void main(String[] args) 
	{
		// Problem 1
		//RKF_Method(1.0,2.0,1.0 ,Math.pow(10, -4), 0.25,0.02);
		//Problem 2
		//RKF_Method(0.0,1.0,1.0,Math.pow(10, -6),.5,.05);
		
		//Problem 3
		//RKF_Method(1.0,2.0,1.0,Math.pow(10, -6),.1,.01);
		//RK_Method(1.0,2.0,10,1);
		AB_4Step();
		System.out.println();
		System.out.println();
		AB_3Step();
		System.out.println();
		System.out.println();
		AB_2Step();
	}
	
	//Inputs: endpoints a,b; initial condition ALPHA; tolerance TOL; maximum step size hmax; minimum step size hmin
	//Outputs: t,w,h where w approximates y(t) and the step size h was used, or a message that the minimum step size was exceeded
	static void RKF_Method(double A , double B, double ALPHA, double TOL, double HMAX, double HMIN)
	{
		//Step 1
		double t,w,h,R,DELTA;
		double [] K=new double[6];
		int FLAG =1;
		t=A;
		w=ALPHA;
		h=HMAX;
		System.out.println("    t \t\t     w \t\t     h \t\t Actual Value \t\t Actual Error");
		System.out.printf("%.8f \t %.8f \t \n",t,w);
		
		// Step 2
		while(FLAG==1) 
		{
			// Step 3
			K[0] = h*F1(t,w);
			K[1] = h*F1(t + (1/4.0)*h , w + (1/4.0)*K[0] );
			K[2] = h*F1(t + (3/8.0)*h , w + (3/32.0)*K[0] + (9/32.0)*K[1] );
			K[3] = h*F1(t + (12/13.0)*h, w + (1932/2197.0)*K[0] - (7200/2197.0)*K[1] + (7296/2197.0)*K[2]);
			K[4] = h*F1(t + h, w + (439/216.0)*K[0] - 8*K[1] + (3680/513.0)*K[2] - (845/4104.0)*K[3] );
			K[5] = h*F1(t + (1/2.0)*h, w - (8/27.0)*K[0] + 2*K[1] - (3544/2565.0)*K[2] + (1859/4104.0)*K[3] - (11/40.0)*K[4] );
			
			/*for(int i =0;i<K.length;i++)
			{
				System.out.printf("K[%d] = %f \n",i,K[i]);
			}*/
			
			// Step 4
			R= (1/h)*Math.abs( (1/360.0)*K[0] - (128/4275.0)*K[2] - (2197/75240.0)*K[3] + (1/50.0)*K[4] + (2/55.0)*K[5]);
			
			// Step 5
			if(R <= TOL)
			{
				// bits commented out are used in problem 2
				// Step 6
				t += h;
				//double actualValue = F4(t);
				w = w + (25/216.0)*K[0] + (1408/2565.0)* K[2] + (2197/4104.0)*K[3] - (1/5.0)*K[4];
				// Step 7
				//double actualError = Math.abs(actualValue - w);
				//System.out.printf("%.8f \t %.8f \t %.8f \t %.8f \t\t %.8f \n",t,w,h,actualValue,actualError);
				System.out.printf("%.8f \t %.8f \t %.8f \t \n",t,w,h);
			}
			// Step 8
			DELTA = .84*Math.pow((TOL/R) , .25);
			
			// Step 9 
			if(DELTA <= 0.1)
			{
				h *= 0.1;
			}
			else if(DELTA >= 4.0)
			{
				h *= 4.0;				
			}
			else
			{
				h *= DELTA;
			}
			
			// Step 10
			if(h > HMAX)
			{
				h = HMAX;
			}
			
			// Step 11
			if(t >= B)
			{
				FLAG =0;
			}
			else if( (t+h) > B)
			{
				h = B - t;
			}
			else if(h < HMIN)
			{
				FLAG =0;
				System.out.println("-------Minimum H Exceeded-------");
				System.out.println("------Procedure Unsuccessful------");
			}
		}
	}
	
	// Function of y prime used in problem 1 and 2
	static double F1(double t,double y)
	{
		//for first problem
		//return Math.sin(t) + Math.exp(-t);
		// for second problem
		//return -t*y + (4*t)/y;
		// for third problem initial values
		return (y/t)- Math.pow((y/t), 2);
	}
	
	// Used in problem 2 this is the actual solution and I use it to find the actual error. |wi - F4(t)|
	static double F4(double x)
	{
		return Math.sqrt(4- (3/Math.exp(x*x)));
	}
	

	static void AB_4Step()
	{
		double [] W = new double[11];
		W[0] = 1.0000000;
		W[1] = 1.0042815;
		W[2] = 1.0149520;
		W[3] = 1.0298133;
		double h=0.1;
		System.out.println("\n t \t\t Exact \t\t    w \t\t  Actual Error \t\t Absolute Max. Local Trunc. Error");
		for(int i=0;i<W.length;i++)
		{
			if(i<=3)
			{
				System.out.printf("%.1f\t\t%.5f\t\t -------\t   ------- \t\t   -------- \n", 1+ i*h,F2(1 + (i*h)));
			}
			else
			{
				W[i]=W[i-1] + (h/24)*( 55 *F3(1+ h*(i-1),W[i-1]) - 59*F3(1+h*(i-2), W[i-2]) + 37*F3(1+h*(i-3),W[i-3])-9*F3(1+h*(i-4),W[i-4]) ); 
				double actualerror = Math.abs(F2(1+ h*i) - W[i]);
				double LTE = (251/720.0)*(-0.82592)*Math.pow(h, 4) ; // used my calculator to figure out the derivative at 2.0
				System.out.printf("%.1f\t\t%.5f \t %.5f \t   %.7f \t\t   %.7f \n", 1+ (i*h) ,F2(1 + (i*h)),W[i],actualerror,Math.abs(LTE));
			}
		}
	}
	
	static void AB_3Step()
	{
		double [] W = new double[11];
		W[0] = 1.0000000;
		W[1] = 1.0042815 ;
		W[2] = 1.0149520;
		double h=0.1;
		System.out.println("\n t \t\t Exact \t\t    w \t\t  Actual Error \t\t Absolute Max. Local Trunc. Error");
		for(int i=0;i<W.length;i++)
		{
			if(i<=2)
			{
				System.out.printf("%.1f\t\t%.5f\t\t -------\t   ------- \t\t   -------- \n", 1+ i*h, F2(1 + (i*h)));
			}
			else
			{
				W[i]=W[i-1] + (h/12)*(23*F3(1+ h*(i-1),W[i-1]) - 16*F3(1+ h*(i-2), W[i-2]) + 5*F3(1+ h*(i-3),W[i-3]) ); 
				double actualerror = Math.abs(F2(1+ h*i) - W[i]); 
				double LTE = (3/8.0)*(0.259408)*Math.pow(h, 3) ;
				System.out.printf("%.1f\t\t%.5f \t %.5f \t   %.7f \t\t   %.7f \n", 1+ (i*h) ,F2(1 + (i*h)),W[i],actualerror, Math.abs(LTE));
			}
		}
		
	}
	
	static void AB_2Step()
	{
		double [] W = new double[11];
		W[0] = 1.0;
		W[1] = 1.0042815 ;
		
		double h=0.1;
		System.out.println("\n t \t\t Exact \t\t    w \t\t  Actual Error \t\tLocal Trunc. Error");
		for(int i=0;i<W.length;i++)
		{
			if(i<=1)
			{
				System.out.printf("%.1f\t\t%.5f\t\t -------\t   ------- \t\t   -------- \n", 1+ i*h,F2(1+ i*h));
			}
			else
			{
				W[i]=W[i-1] + (h/2)*(3*F3(1+h*(i-1),W[i-1]) -F3(1+h*(i-2), W[i-2]) ); 
				double actualerror = Math.abs(F2(1+ h*i) - W[i]); 
				double LTE = (5/12.0)*(-0.09531)*Math.pow(h, 2) ;
				System.out.printf("%.1f\t\t%.5f \t %.5f \t   %.7f \t\t   %.7f \n", 1+(i)*h,F2(1+(i)*h),W[i],actualerror,Math.abs(LTE));
			}
		}
		
	}
	
	static double F2( double t)
	{		
		return t/(1 + Math.log(t));
	}
	static double F3(double t, double y)
	{
		
		return (y/t)- Math.pow((y/t), 2);
	}

	static void RK_Method(double a, double b, int N, double ALPHA)
	{
		// step 1
		double k1,k2,k3,k4;
		double h=(b-a)/N;
		double t=a;
		double w = ALPHA;
		System.out.println("  t \t     w");
		System.out.printf(" %.2f \t %.7f \n", t,w);
		for(int i=1;i<=N;i++)
		{
			k1 = h* func(t,w);
			k2 = h* func(t + (h/2), w+(k1/2));
			k3 = h* func(t + (h/2), w+(k2/2));
			k4 = h* func( t + h, w + k3);
			
			w= w + ((k1+2*k2+2*k3+k4)/6);
			t = a+i*h;
			System.out.printf(" %.2f \t %.7f \n", t,w);
		}
	}
	
	static double func(double t,double y)
	{
		return (y/t)- Math.pow((y/t), 2);
	}

}
