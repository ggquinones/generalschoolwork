package quingg01_lab8;
import java.util.Random;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 8
 *
 */

public class Applications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		Freezing_Boiling substance = new Freezing_Boiling();
		Random rd = new Random();
		
		for(int i=0;i<20;i++)
		{
			int a = rd.nextInt(600)-300;
			substance.setTemp(a);
			System.out.println("entry"+i);
			System.out.println(substance.stateReport(substance.getTemp()));
			
		}
		
	}

}
