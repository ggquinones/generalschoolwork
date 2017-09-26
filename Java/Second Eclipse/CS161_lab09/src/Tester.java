import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Tester 
{
	public static void main(String[] args) 
	{
		MyFrame f = new MyFrame();
		MyPanel p = new MyPanel();
		f.add(p);
		f.setVisible(true);
		f.setResizable(false);
		f.setSize(500,500);

	}
}

class MyFrame extends JFrame
{
	
	
}

class MyPanel extends JPanel
{
	ArrayList<Image> images = new ArrayList<>();
	int count=0;
	
	public MyPanel()
	{
		
		try {
		      File folder = new File("c:/users/Gabriel/Documents/pictures");
		      for (File file : folder.listFiles()) {
		    	  
		    	  images.add(ImageIO.read(file));
		        //do something with ImageIO.read(file);
		      }
		    } catch (Exception ex) {
		      System.out.println("Can't open file");
		    }
		
		Timer t = new Timer(2000,new ActionListener(){
			
			public void actionPerformed(ActionEvent e)
			{
				   
				   
				
				if(count==images.size()-1)
				{
					count=0;
					
				}
				else
				{
					count++;
				}
				repaint();
			}			
			
		});
		t.start();
		
		
	}
	//g2.drawImage(ImageIO.read(file),135,135,200,200,this);
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(images.get(count),200,200,null);
		
		
	}
	
	public int getCount()
	{
		
		return count;
	}
	
}

