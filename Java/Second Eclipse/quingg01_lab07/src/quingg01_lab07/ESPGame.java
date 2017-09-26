package quingg01_lab07;

import java.awt.Color;
import java.util.Random;
import javax.swing.*;
/*
 * <Gabriel Quiñones-Sanchez>
 * CS160-01 Fall 2014
 * Lab 7
 *
 */


public class ESPGame {

	//Declares String chosenColor which will store the string literal version of the output of the chooseColor method
	String chosenColor;
	
	/*	The chooseColor method takes an integer type as a parameter and return an instance of a Color object.
	 * 	A switch structure inside the method decides what color based on the input integer.Integers 1 through
	 * 6 have color and if the number is outside that range black is the default. The string literal of the color is
	 * saved to the chosenColor String declared above.
	 */
	
	public Color chooseColor(int a)
	{
		
		Color color = new Color(1);
		switch(a)
		{
		case 1:
		{
			color=Color.BLUE;
			chosenColor="blue";
			break;
		}
		case 2:
		{
			color=Color.YELLOW;
			chosenColor="yellow";
			break;
		}
		case 3:
		{
			color=Color.RED;
			chosenColor="red";
			break;
		}
		case 4:
		{
			color=Color.GREEN;
			chosenColor="green";
			break;
		}
		case 5:
		{
			color=Color.ORANGE;
			chosenColor="orange";
			break;
		}
		case 6:
		{
			color=Color.CYAN;
			chosenColor="cyan";
			break;
		}
		default:
		{
			color=Color.BLACK;
			chosenColor="black";
			break;
		}
		
		}
		
		return color;	
					
	}
	
	/*	The showColor method displays a frame with the inputed color and prompts the user to "Guess this color" on the title bar
	 * of the frame.
	 * 
	 */
	
	public void showColor(Color color)
	{
		JFrame frame = new JFrame("Guess this color");
		frame.setSize(200,200);		
		frame.setLocation(300,300);
		JPanel panel = new JPanel();
		panel.setBackground(color);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/*	The guessColor method is a void method which prompts the user to play the ESP Game.
	 * Within the method, if the user clicks YES, the method generates a random integer from
	 * 1 to 6 passes that to the chooseColor method. The color returned by the chooseColor method is then passed to the 
	 * showColor method and a screen with color options then appears for the user. Based on the string input the user either sees
	 * a message saying he/she guessed right or wrong, and the game goes on.
	 * 
	 */
	public void guessColor()
	{
		while(true)
		{
			
		int answer=JOptionPane.showConfirmDialog (null, "Enter ESP game?", "ESP Game",
				JOptionPane.YES_NO_OPTION); 
		
		if(answer==JOptionPane.YES_OPTION)
		{
			Random rand = new Random();
			int randNum= rand.nextInt(5)+1;
			showColor(chooseColor(randNum));
			String choice =JOptionPane.showInputDialog("Choose the name of the color you see:\nbrown\nred"
					+ "\ngreen\nblue\nmagenta\ncyan\nblack\norange\nyellow\nbeige");
			if(chosenColor.equals(choice))
			{
				JOptionPane.showMessageDialog(null, "You chose correct");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"You guessed wrong");
			}
			
			
			
		}
		else
		{
			break;
		}
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
