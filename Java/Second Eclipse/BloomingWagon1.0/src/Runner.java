import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class Runner {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException 
	{
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());		
		new LoginMenu();
		
		
	}

}
 class LoginMenu extends JFrame
 {
	 // Login Menu Dialog Page
	 public LoginMenu()
	 {
		 // Frame Details
		setTitle("Welcom to the Blooming Wagon");
		setSize(400,125);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Panel for Frame
		JPanel panel = new JPanel(new GridLayout(3,2,5,5));
		
		// Panel components
		JLabel loginL = new JLabel("Username:");
		JLabel passwordL = new JLabel("Password:");
		JTextField loginT = new JTextField();
		JTextField passwordT = new JTextField();
		JButton loginB = new JButton("Login");
		JButton exitB = new JButton("Exit");
		
		//// Panel components addition and panel addition
		panel.add(loginL);
		panel.add(loginT);
		panel.add(passwordL);
		panel.add(passwordT);
		panel.add(loginB);
		panel.add(exitB);
		add(panel);
		
		// action listeners
		exitB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		loginB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				new MainMenu();
			}
		});
		
		
		
		// frame is visible
		setVisible(true);
	 }
 }
 
 class MainMenu extends JFrame
 {
	 JFrame self=this;
	 public MainMenu()
	 {
		 // Frame Details
		setTitle("The Blooming Wagon: Main Menu");
		setSize(400,125);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		// Panel for Frame
		JPanel panel = new JPanel();
		
		//Panel Components Definition
		
		//Menus definition/addition
		JMenu orderM = new JMenu("Order");
		bar.add(orderM);
		JMenu productM = new JMenu("Product");
		bar.add(productM);
		JMenu customerM = new JMenu("Customer");
		bar.add(customerM);
		// Menu Items definition/addition
		JMenuItem newOrder = new JMenuItem("Enter New Order");
		JMenuItem browseOrders = new JMenuItem("Browse Orders DataBase");
		JMenuItem newProduct = new JMenuItem("Enter New Product");
		JMenuItem browseProducts = new JMenuItem("Browse Products DataBase");
		orderM.add(newOrder);
		orderM.add(browseOrders);
		productM.add(newProduct);
		productM.add(browseProducts);
		//Panel components addition and panel addition
			
		//panel.add();
		
		
		//Listeners
		newOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				
				JLabel prodNameL = new JLabel("Product Name:");
				 JTextField prodNameT = new JTextField();
				 JLabel prodDescL = new JLabel("Product Description:");
				 JTextField prodDescT = new JTextField();
				 panel.add(prodNameL);
				 panel.add(prodNameT);
				 panel.add(prodDescL);
				 panel.add(prodDescT);
				 add(panel);
			}
		});
		
		
		
		add(panel);
		setVisible(true);
		
	 }
 }
 
 class NewOrderPanel extends JPanel
 {
	 
	 public NewOrderPanel()
	 {
		 //Panel Components
		 
		 JLabel prodNameL = new JLabel("Product Name:");
		 JTextField prodNameT = new JTextField();
		 JLabel prodDescL = new JLabel("Product Description:");
		 JTextField prodDescT = new JTextField();
		 add(prodNameL);
		 add(prodNameT);
		 add(prodDescL);
		 add(prodDescT);
		
	 }
 }