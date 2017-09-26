package forFun;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GingerProjectOne {	
	
	private String accountName;
	private String dateOfEvent;
	private String location;
	private String[] accountInfo = new String[3];
	private String[] products;
	private double[] prices;
	private int[] amounts;
	
	// Sets class data fields for account info. Name, date, and location.
	public void setCustomerInfo()
	{
		  JTextField customerName = new JTextField(5);
	      JTextField eventDate = new JTextField(5);
	      JTextField location1 = new JTextField(5);
	      
	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("Account Name:"));
	      myPanel.add(customerName);				  // adds input boxes
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("Date of Event:"));
	      myPanel.add(eventDate);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("Location:"));
	      myPanel.add(location1);
		
	      int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Account Information", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) 
	      {
	    	  
	    	  accountName=customerName.getText();
	    	  dateOfEvent=eventDate.getText();
	    	  location = location1.getText();
	      }
	}
	
	// Gets data fields related to account info.
	public String[] getAccountInfo()
	{
		accountInfo[0]=accountName;
		accountInfo[1]=dateOfEvent;
		accountInfo[2]=location;
		return accountInfo;
	}
	
	// Sets parallel arrays, products,prices,and amounts with each products name price and amount purchased.
	public void setSales()
	{
		String input=JOptionPane.showInputDialog(null, "Please enter the amount of products:","The Blooming Wagon",JOptionPane.INFORMATION_MESSAGE);
		int prods = Integer.parseInt(input);
		products=new String[prods];
		prices=new double[prods];
		amounts=new int[prods];
		for(int i=0;i<products.length;i++)
		{
			JTextField prodName = new JTextField(5);
		      JTextField prodPrice = new JTextField(5);
		      JTextField prodAmt = new JTextField(5);
		      
		      JPanel myPanel = new JPanel();
		      myPanel.add(new JLabel("Product Name:"));
		      myPanel.add(prodName);				  // adds input boxes
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("Price:"));
		      myPanel.add(prodPrice);
		      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
		      myPanel.add(new JLabel("Amount:"));
		      myPanel.add(prodAmt);
			
		      int result = JOptionPane.showConfirmDialog(null, myPanel, 
		               "The Blooming Wagon", JOptionPane.OK_CANCEL_OPTION);
		      if (result == JOptionPane.OK_OPTION) 
		      {
		    	  
		    	  products[i] = prodName.getText();
		    	  prices[i]   = Double.parseDouble(prodPrice.getText());
		    	  amounts[i]    = Integer.parseInt(prodAmt.getText());
		      }
		}
		
	}
	
	

	public String[] getProducts()
	{
		return products;
	}
	public double[] getPrices()
	{
		return prices;
	}
	public int[] getAmounts()
	{
		return amounts;
	}
	
	public double calcTotal()
	{
		double total=0;
		for(int i =0;i<prices.length;i++)
		{
			total+=prices[i];
		}
		return total;
	}
	// calls setCustomerInfo and getAccountInfo to compile customer info and then displays it on console
	public void dispAccountInfo()
	{
		setCustomerInfo();
		String[] temp=getAccountInfo();
		System.out.println("The Blooming Wagon");
		System.out.println("Weeding Proposal");
		System.out.println();
		
		for(int i =0;i<temp.length;i++)
		{
			System.out.println(temp[i]);
		}
		
		for(int i =0;i<products.length;i++)
		{
			System.out.println(products[i]+"\t$"+prices[i]+"\t"+amounts[i]);
		}
		
		System.out.println("\nThe account total is "+calcTotal());
	}
	
	
	
	
	
	
	
	
}
