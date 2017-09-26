import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;





import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Assignment3 extends JPanel
{
	public static void main (String [] args)
	{
		
		
		
		JPanel panel = new Assignment3();
		panel.setVisible(true);
		
		JFrame frame = new JFrame();
		frame.add(panel);
		panel.setBackground(Color.RED);
		frame.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;		
	   
	    showMessage("GAME OVER",g2);
	     
	}
	
	public void showMessage(String s, Graphics2D g2) {
	    Font myFont = new Font("SansSerif", 
	                               Font.BOLD+Font.ITALIC,30);
	    g2.setFont(myFont);
	    g2.setColor(Color.WHITE);
	    Rectangle2D textBox = myFont.getStringBounds(s,
	                               g2.getFontRenderContext());
	    g2.drawString(s, (int)(getWidth()/2 - 
	 textBox.getWidth() / 2),
	          (int) (getHeight() / 2 - textBox.getHeight()));
	  }

}



 



 
  