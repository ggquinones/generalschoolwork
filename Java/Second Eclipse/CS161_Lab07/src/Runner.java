import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Runner 
{
	public static void main(String[] args) 
	{
		MyFrame f = new MyFrame();		
		f.setVisible(true);

	}
}

class MyFrame extends JFrame
{
	public MyFrame()
	{		
		MyPanel p = new MyPanel();
		add(p);
		setSize(500,500);
	}
}

class MyPanel extends JPanel
{
	private ArrayList<MyShape> shapesToDraw = new ArrayList<>();
	
	public MyPanel()
	{
		
		fillShapesToDraw();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;		
		
		for(MyShape el: shapesToDraw)
		{
			el.draw(g2);
		}
		
	}
	
	public void fillShapesToDraw()
	{
		for(int i =0;i<25;i++)
		{			
			shapesToDraw.add(new MyShape());
		}
		
	}	

}

class MyShape
{
	
	
	private Shape shape;
	private Color color;
	private boolean filled;
	
	public MyShape()
	{
		int i= (int)(Math.random()*3);
		
		if(i==0)
		{
			this.shape= new Rectangle2D.Double((int) (Math.random()*300),(int)(Math.random()*300),(int)(Math.random()*50),(int)(Math.random()*50));
		}
		else if(i==1)
		{
			this.shape= new Ellipse2D.Double((int) (Math.random()*300),(int)(Math.random()*300),(int)(Math.random()*50),(int)(Math.random()*50));
		}
		else
		{
			this.shape= new Line2D.Double((int) (Math.random()*300),(int)(Math.random()*300),(int)(Math.random()*300),(int)(Math.random()*300));
		}
		
		
		this.color=randomColor();
		this.filled=randomFill(this.shape);
		
	}

	public boolean fillable(Shape shape)
	{
		if(shape instanceof Line2D)
		{
			return false;
		}
		return true;
	}
	
	public boolean randomFill(Shape s)
	{
		if(fillable(s))
		{
			int i = (int)(Math.random()*2);
			if(i==1)
			{
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics2D brush)
	{
		
			brush.setColor(this.getColor());
			brush.draw(this.getShape());
			if(this.getFilled())
			{
				brush.fill(this.getShape());
			}	
			
		
	}
		
	public Color getColor()
	{
		return this.color;
	}

	public Color randomColor()
	{
		Random r = new Random();
		int choice =r.nextInt(3);
		if(choice==0)
		{
			return(Color.RED);
		}
		else if(choice==1)
		{
			return(Color.BLUE);
		}
		
		return Color.GREEN;
	}
	
	public Shape getShape()
	{
		return this.shape;
	}

	public boolean getFilled()
	{
		return this.filled;
	}
}