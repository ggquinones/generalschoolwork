
public class Runner 
{

	public static void main(String[] args) 
	{
		double [] x1 = {1.5,1.7};
		double [] x2 = {2,1.9};
		double [] x3 = {1.6,1.8};
		double [] x4 = {1.2,1.5};
		double [] x5 = {1.5,1.0};
		
		double [][] dataSets = {x1,x2,x3,x4,x5};
		double [] query = {1.4,1.6};
		
		for(int i=0;i<5;i++)
		{	
			
			//System.out.println("D = "+ euclideanDistance(query,dataSets[i]));
			//System.out.println("D = "+ manhattanDistance(query,dataSets[i]));
			System.out.println("D = "+ cosineDistance(query,dataSets[i]));
		}
		
	}

	public static void PPMC()
	{
		int [] sub1 = {13, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 35, 35, 35, 36, 40, 45, 46, 52, 70};
		int [] sub2 = {11, 12, 13, 15, 17, 20, 20, 21, 21, 22, 22, 23, 23, 25, 30, 31, 31, 32, 35, 35, 35, 36, 40, 45, 45, 53, 55};
		
		int [] bin1= {13, 15, 16, 16, 19, 20, 20, 21, 22};
		int [] bin2= {22, 25, 25, 25, 25, 30, 33, 33, 35};
		int [] bin3= {35, 35, 35, 36, 40, 45, 46, 52, 70};
		
		int sum1=0,sum2=0,sum3=0;
		
		for(int i=0;i<bin1.length;i++)
		{
			sum1 += bin1[i];
			sum2 += bin2[i];
			sum3 += bin3[i];
		}
		
		System.out.println("Mean of bin 1: " + sum1/9 );
		System.out.println("Mean of bin 2: " + sum2/9 );
		System.out.println("Mean of bin 3: " + sum3/9 );
		
		int n =sub1.length;
		
		int sumXY=0, sumXX=0, sumYY=0, sumX=0,sumY=0;
		for(int i=0;i<sub1.length;i++)
		{ 
			sumX  += sub1[i];
			sumY  += sub2[i];
			sumXY += sub1[i]*sub2[i];
			sumXX += sub1[i]*sub1[i];
			sumYY += sub2[i]*sub2[i];	
		}
		
		System.out.println("Sum xy:"+sumXY);
		System.out.println("Sum xx:"+sumXX);
		System.out.println("Sum yy:"+sumYY);
		System.out.println("Sum x:"+sumX);
		double meanX = (sumX*1.0)/n;
		System.out.println("Mean:"+ meanX);
		System.out.println("Sum y:"+sumY);
		
		double SD = 0;		
		for(int i=0;i<n;i++)
		{
			SD += Math.pow((sub1[i]- meanX), 2); 
		}
		
		SD = SD/(n-1);
		SD = Math.sqrt(SD);
		System.out.println("Std. Dev. of X: "+SD);
		double PPMC = (n*(sumXY)-(sumX*sumY))/(Math.sqrt( ( n*sumXX - (Math.pow(sumX,2)) ) * (n*sumYY - (Math.pow(sumY,2)))));
		
		System.out.println(PPMC);
	}

	public static double euclideanDistance(double [] query, double [] data)
	{
		return Math.sqrt( Math.pow(Math.abs(query[0]-data[0]), 2) + Math.pow(Math.abs(query[1]-data[1]), 2) );
	}
	
	public static double manhattanDistance(double [] query, double [] data)
	{
		return  (Math.abs(data[0]-query[0])) + (Math.abs(data[1]-query[1]));
	}
	
	public static double cosineDistance(double [] query, double [] data)
	{
		double dotProd = (query[0]*data[0]) + (query[1]*data[1]);
		double queryNorm = Math.sqrt(Math.pow(query[0], 2) + Math.pow(query[1], 2)); 
		double dataNorm = Math.sqrt(Math.pow(data[0], 2) + Math.pow(data[1], 2)); 
		return dotProd/(queryNorm*dataNorm);
	}
}