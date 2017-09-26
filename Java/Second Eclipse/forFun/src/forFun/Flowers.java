package forFun;
import javax.swing.*;

public class Flowers {

	String[] productNames = {"Rose","Center Piece","Headband"};
	double[] flowerPrices = {2.56,56.26,16.00};
	
	public int getProductIndex(String name)
	{
		for(int i=0;i<productNames.length;i++)
		{
			if(productNames[i].equalsIgnoreCase(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	public double getPrice(int index)
	{
		return flowerPrices[index];
	}
	
	public void howManyFlowers()
	{
		JTextField numRoses
		= new JTextField(5);
	      
	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("Flowers:"));
	      myPanel.add(numRoses);	
	}
}
