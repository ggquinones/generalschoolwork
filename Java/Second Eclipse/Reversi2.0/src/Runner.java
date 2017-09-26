import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;


/*
 * The runner simply makes a frame, adds a board panel to it, and sets the frame visible and focusable.
 * The code that makes the project work is in the Board class, but the main method is here.
 */
public class Runner 
{

	public static void main(String[] args) 
	{
		
		MyFrame frame = new MyFrame();
		
		frame.setFocusable(true);
				
		
		
		Board board = new Board();
		frame.add(board);
		
		

		

		
		frame.setVisible(true);
	}

}

/**
 * Simple MYFrame class that extends the JFrame class, nothing fancy.
 * *
 */
class MyFrame extends JFrame
{
	
	
	public MyFrame()
	{
		
		setSize(500,550);
		setResizable(false);
				
		
		
	}


}













