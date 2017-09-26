import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

/**
 * This is a program that displays a relevant image,
 *  some words, and a color image in this case a blue rectangle
 * @author Gabriel
 *
 */
public class Tester
{

	public static void main(String[] args) 
	{
		MyFrame f = new MyFrame();
		f.setVisible(true);
		f.setSize(500,500);
	}

}

class MyFrame extends JFrame
{
	public MyFrame()
	{
		MyPanel center = new MyPanel();
		JLabel words = new JLabel("This is a volleyball. I play volleyball, and it is awesome.");
		center.add(words);
		
	    add(center);
	}

}

class MyPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setColor(Color.BLUE);
		Image image = new ImageIcon("volleyball.jpg" ).getImage();
		
		Rectangle2D r=new Rectangle2D.Double(85,85,300,300);
		g2.draw(r);
		g2.fill(r);
		g2.drawImage(image,135,135,200,200,this);
		
		repaint();
		
	}
	
	
}