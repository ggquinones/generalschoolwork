import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Tester 
{

	public static void main(String[] args) 
	{

		
		firstFrame one = new firstFrame();
		secondFrame two = new secondFrame();
		thirdFrame three = new thirdFrame();
		fourthFrame four = new fourthFrame();
		four.setVisible(true);
		one.setVisible(true);
		three.setVisible(true);
		two.setVisible(true);
		
		
		
		
		
	}

	
	
}

class firstFrame extends JFrame
{
	public firstFrame()
	{
		
	    JPanel panel = new JPanel();
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    setLayout(new BorderLayout()); 
	    
		final JTextField one = new JTextField(5);
		final JTextField two = new JTextField(5);
		final JTextField three = new JTextField(5);
		final JTextField four = new JTextField(5);
		final JTextField five = new JTextField(5);
		final JTextField six = new JTextField(5);
		final JTextField seven = new JTextField(5);
		JButton button = new JButton("READ DATA");
		
		
		panel.add(new JLabel("Enter Row Number: "));		
		panel.add(one);
		panel.add(new JLabel("Enter Column Number: "));
		panel.add(two);
		panel.add(new JLabel("Limit on Generations: "));
		panel.add(three);
		panel1.add(new JLabel("max Stay Alive: "));
		panel1.add(four);
		panel1.add(new JLabel("min Stay Alive: "));
		panel1.add(five);
		panel1.add(new JLabel("max To Life: "));
		panel1.add(six);
		panel1.add(new JLabel("min to Life: "));
		panel1.add(seven);
		panel2.add(button);
		add(panel,BorderLayout.NORTH);
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		pack();
	}
}


class secondFrame extends JFrame
{
		public secondFrame()
		{
			JPanel p = new JPanel();
		    add(p,BorderLayout.NORTH);
		    setTitle("Select Data Source");
		    JRadioButton upButton = new JRadioButton("Data From User", false);
		    JRadioButton downButton = new JRadioButton("Data From File",false);
		    p.add(new JLabel("Choose source: "));
		    p.add(upButton);
		    p.add(downButton);
		    ButtonGroup group = new ButtonGroup();
		    group.add(upButton);
		    group.add(downButton);
		    pack();
		}

}

class thirdFrame extends JFrame
{
	public thirdFrame()
	{
		JPanel p = new JPanel();
	    add(p,BorderLayout.NORTH);
	    
		setTitle("Initialize World?");
		p.add(new JLabel("Create First Generation By: "));
		
		JComboBox box = new JComboBox();
		box.addItem("User Initializaion");
		box.addItem("Random Initializaion");
		p.add(box);
		
		
		
		
		
		pack();
	}

}


class fourthFrame extends JFrame
{
	
	public fourthFrame()
	{
		JPanel buttons = new JPanel();
	    JPanel grid = new JPanel();
	    JPanel bottomPanel = new JPanel();

	    String[] buttonNames = {"1,1","1,2","1,3","1,4","1,5","2,1","2,2","2,3","2,4","2,5","3,1","3,2","3,3","3,4","3,5","4,1","4,2","4,3","4,4"
	    		,"4,5","5,1","5,2","5,3","5,4","5,5"};
	    	    grid.setLayout(new GridLayout(5, 5, 5, 5));
	    	    int ct=0;
	    	    for(int i =0;i<25;i++)
	    	    {
	    	    	JButton temp = new JButton(buttonNames[i]);
	    	    	grid.add(temp);
	    	    	if(ct==0 || ct == 5 || ct==11 || ct==12 || ct==16 || ct==17 || ct==23 || ct==24)
	    	    	{
	    	    		temp.setBackground(Color.GREEN);
	    	    		
	    	    	}
	    	    	ct++;
	    	    }

	   JButton b1 = new JButton("Next");
	   JButton b2 = new JButton("Nonstop");
	   JButton b3 = new JButton("Reset"); 	    
	   JButton b4 = new JButton("Display Data"); 	    
	   JButton b5 = new JButton("New Game");	    
	    	    
	    buttons.add(b1);
	    buttons.add(b2);
	    buttons.add(b3);
	    buttons.add(b4);
	    buttons.add(b5);
	    	    
	    final JTextField one = new JTextField(20);	
	    
	    bottomPanel.add(one);
	   add(grid,BorderLayout.NORTH); 	    
	    add(buttons,BorderLayout.CENTER);	    
	        add(bottomPanel,BorderLayout.SOUTH);
	    	    
	    	    pack();
	}

}










