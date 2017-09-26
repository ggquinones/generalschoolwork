package quingg01_lab8;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 8
 *
 */
public class Freezing_Boiling {
	
	// Declaring data fields
	private int temp;
	final int ETHYL_FREEZING = -173;
	final int ETHYL_BOILING = 172;  
	final int WATER_FREEZING =32 ;
	final int WATER_BOILING = 100; 
	
	// mutator method that sets the temperature of the Freezing_Boiling object
	public void setTemp(int a)
	{
		temp =a;
	}
	
	// accessor method which returns the value of the Freezing_Boiling objects temperature
	public int getTemp()
	{
		return temp;
	}
	
	// Method which runs through a selection logic to see if ethyl alcohol is solid at the given temperature
	// Returns true if it is a solid at the given temperature.
	public boolean isEthylFreezing()
	{
		if(temp<=ETHYL_FREEZING)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Method which runs through a selection logic to see if ethyl alcohol is a gas at the given temperature
	// Returns true if it is a gas at the given temperature.
	public boolean isEthylBoiling()
	{
		if(temp>=ETHYL_BOILING)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Method which runs through a selection logic to see if water is solid at the given temperature
	// Returns true if it is a solid at the given temperature.
	public boolean isWaterFreezing()
	{
		if(temp<=WATER_FREEZING)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Method which runs through a selection logic to see if water is a gas at the given temperature
	// Returns true if it is a gas at the given temperature.
	public boolean isWaterBoiling()
	{
		if(temp>=WATER_BOILING)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	// Method which determines what state ethyl alcohol and water are in at the given temperature, solid, liquid or gas.
	// Returns a String, report, stating the given temperature and what state ethyl alcohol and water are in.
	public String stateReport( int a)
	{
		String report="For the given temperature "+ a +" Fahrenheit\n";
		
		if(isEthylFreezing() == true)
		{
			report= report + "ethyl alcohol is solid\n";
		}
		else if(isEthylBoiling() == true)
		{
			report= report+"ethyl alcohol is gas\n";
		}
		else
		{
			report = report+"ethyl alcohol is liquid\n";
		}
		
		if(isWaterFreezing() == true)
		{
			report= report+"water is solid";
		}
		else if(isWaterBoiling() == true)
		{
			report = report +"water is gas";
		}
		else
		{
			report = report+"water is liquid";
		}
		
		return report;
	}
}
