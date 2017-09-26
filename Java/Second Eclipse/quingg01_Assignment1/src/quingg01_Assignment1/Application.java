package quingg01_Assignment1;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AssignOneAnswers ans = new AssignOneAnswers();
		int[] test={1,2,3,4};
		ans.reverse(test);
		
		for(int i =0;i<test.length;i++)
		{
			System.out.print(test[i]);
		}
		
		int[][] test2={{1,2,3},
					   {4,5,6}};
		
		
		int[][] printer =ans.transpose(test2);
		
		for(int i =0;i<test2.length;i++)
		{
			System.out.println();
			for(int k=0;k<test2[i].length;k++)
			{
				System.out.print(test2[i][k]);
				
			}
		}
		
		for(int i =0;i<printer.length;i++)
		{
			System.out.println();
			for(int k=0;k<printer[i].length;k++)
			{
				System.out.print(printer[i][k]);
				
			}
		}
		
	
		System.out.println();
		StringBuffer lol = new StringBuffer("card");
		System.out.print(lol);
		ans.randomize(lol);
		System.out.println();
		System.out.print(lol);
		
		System.out.println();
		System.out.println();
		
		Employee a = new Employee(100.0);
		Employee b = new Employee(200.0);
		Employee c = new Employee(300.0);
		ArrayList<Employee> tester= new  ArrayList<Employee>();
		tester.add(a);
		tester.add(b);
		tester.add(c);
		System.out.println(ans.salavg(tester));
		
	}

}
