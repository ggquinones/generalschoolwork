package quingg01_project04;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

/* <Gabriel Quiñones>  
 *  CS160 Fall 2014 
 *   * Project 4: Parking Management
 *
 * Manager class runs the garage. Decided whether cars are leaving or arriving randomly, and processes parking operations.
 * 
 */
public class Manager {
	
	private Garage garage;
	private final double FEE_PER_HOUR=1.5;
	private double feeTotal;
	private int manyCars;
	
	// Method which calls the park method of the Garage class with parameter newCar() and stores the return value 
	// in a return value index. If index is not -1 displays one message, updates manyCars Data Field, and calls the displayState 
	// method of the Garage class. If index IS -1 the method displays two different messages and terminates the program.
	public void parkACar()
	{
		int index = garage.park(new Car());
		if(index!=-1)
		{
			garage.displayState();
			JOptionPane.showMessageDialog(null, "A car is arriving at bay #"+index+
					".\nGarage displayed on console.");
			manyCars++;
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The garage is full.\nThe parking process terminates.","Parking Management",JOptionPane.WARNING_MESSAGE);
			System.out.println("Total parking fee collected is $"+feeTotal);
			System.exit(0);
		}
		
	}
	
	// Method which randomly chooses a Car object to leave the garage by calling the findBayofCar() method of the Garage class
	// Method displays a message if the garage is not empty, and two different ones if it is and terminates the program if it
	// is empty.
	
	public void chooseACarToLeave()
	{
		Random rd = new Random();
		DecimalFormat df = new DecimalFormat("#0.00");
		
		if(manyCars==0)
		{
			JOptionPane.showMessageDialog(null, "The garage is empty.\nThe parking process terminates.","Parking Management",JOptionPane.WARNING_MESSAGE);
			
			System.exit(0);
		}
		else
		{
			int carNumber= rd.nextInt(manyCars)+1;
			int carLeaving=garage.findBayOfCar(carNumber);
			
			double elapsedTIme=garage.remove(carLeaving);
			garage.displayState();
			
			double fee =elapsedTIme*FEE_PER_HOUR;
			feeTotal+=fee;
			manyCars--;
			
			JOptionPane.showMessageDialog(null, "The car from bay #"+carLeaving+" is leaving the garage.\nParking fee paid: $"+df.format(fee),null,JOptionPane.INFORMATION_MESSAGE);
						
		}
	}
	
	// Method random selects with equal probability whether a car will park or leave.
	public void processParking(int limit)
	{
		Random rd = new Random();
		JOptionPane.showMessageDialog(null, "Welcome to the garage parking simulation!\nSee the initial state of the garage on the console.","Parking Management",JOptionPane.WARNING_MESSAGE);
		
		garage.displayState();
		int count =0;
		DecimalFormat df = new DecimalFormat("#0.00");
		
		
		for(int i =0;i<limit;i++)
		{
			count++;
			
			int choice = rd.nextInt(2);
			if(choice==0)
			{
				parkACar();
			}
			else
			{
				chooseACarToLeave();
			}
		}
		System.out.println("After "+count+" parking operations the process is terminated.");
		System.out.println("Total parking fee collected is $"+df.format(feeTotal));
	}
	
	// Constructor of Manager class takes garage and integer parameters.
	public Manager(Garage garages,int many)
	{
		garage=garages;
		manyCars=many;
	}
	

}
