import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main 
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
		setSize(400,400);
		add(p);
		
	}

}

class MyPanel extends JPanel
{
	private final int SIZE=2;
	private int oldX=-1;
	private int oldY=-1;
	ImageArray imgArr= new ImageArray("giba.jpg",SIZE);
	
	public MyPanel()
	{
		addMouseListener(new MouseAdapter(){
			
			public void mousePressed(MouseEvent e)
			{
				if(e.getButton()==1)
				{
					if(oldX==-1)
					{
						oldX=e.getX();
						oldY=e.getY();
					}
					else
					{
						imgArr.swapPoints(oldX,oldY,e.getX(),e.getY());
						oldX=-1;
						oldY=-1;
						repaint();
					}
				}
			}
			
		});
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		imgArr.draw(g2);
		imgArr.isCorrect();
		repaint();
	}
	
	
}


class ImageArray 
{
	private int size;
	private Square[][] squares;
	public ImageArray(String fileName, int size) 
	{
	    this.size = size;
	    squares = new Square[size][size];
	    try {
	      BufferedImage image = ImageIO.read(new File(fileName));
	      int w = image.getWidth() / size;
	      int h = image.getHeight() / size;
	      for (int i = 0; i < size; i++) 
	      {
	        for (int j = 0; j < size; j++) 
	        {
	          squares[i][j] = new Square(image.getSubimage(i*w , j*h , w, h), i, j, w, h);
	        }
	      }
	    } catch (Exception e) {
	      System.out.println("Can't open file!");
	    }
	    shuffle();
	} 
	
	

	public void shuffle()
	{
		for(int i=0;i<size*size;i++)
		{
			int a = (int)(Math.random()*2);
			int b = (int)(Math.random()*2);
			swap(a,b);
		}
	}
	
	public void swap(int a, int b)
	{
		Square temp=squares[a][b];
		squares[a][b]=squares[b][a];
		squares[b][a]=temp;
	}
	
	public void swapPoints(int oldX, int oldY, int xNow ,int yNow)
	{
		//Virtual Coordinates
		int vOldX= oldX/(squares[oldX][oldY].getWidth());
		int vOldY= oldY/(squares[oldX][oldY].getHeight());
		int vXNow= xNow/(squares[oldX][oldY].getWidth());
		int vYNow= yNow/(squares[oldX][oldY].getHeight());
				
				
				
		Square temp= squares[vOldX][vOldY];
		squares[vXNow][vYNow]=squares[vOldX][vOldY];
		squares[vXNow][vYNow]=temp;
	}
	
	public boolean isCorrect()
	{
		for(int i = 0;i<squares.length;i++)
		{
			for(int k=0;k<squares.length;k++)
			{
				if(!(squares[i][k].getInitialX()==i && squares[i][k].getInitialY()==k ) )
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void draw(Graphics2D g2)
	{
		for(int i=0;i<squares.length;i++)
		{
			for(int k=0;i<squares.length;k++)
			{
				squares[0][0].draw(g2, i, k);
				
			}
		}
	}
}


class Square
{
	  private BufferedImage image;
	  private int initialX;
	  private int initialY;
	  private int w;
	  private int h;
	
	  public Square(BufferedImage subImage, int initialX,int initialY, int w, int h)
	  {
		  this.image=subImage;
		  this.initialX=initialX;
		  this.initialY=initialY;
		  this.w=w;
		  this.h=h;
	  }
	  
	  public int getInitialX()
	  {
		  return initialX;
	  }
	  public int getInitialY()
	  {
		  return initialY;
	  }
	  
	  public int getWidth()
	  {
		  return w;
	  }
	  
	  public int getHeight()
	  {
		  return w;
	  }
	  
	  public void draw(Graphics g2,int x,int y)
	  {
		  if(x==0 && y==0)
		  {
			  g2.drawImage(getImage(),getWidth()/2,getHeight()/2,null);
		  }
		  else if(x==1 && y==0)
		  {
			  g2.drawImage(getImage(),(int)getWidth(),getHeight()/2,null);
		  }
		  else if(x==0 && y==1)
		  {
			  g2.drawImage(getImage(),getWidth()/2,(int)getHeight(),null);
		  }
		  else
		  {
			  g2.drawImage(getImage(),(int)getWidth(),(int)getHeight(),null);
		  }
	  }
	  
	  public BufferedImage getImage()
	  {
		  return image;
	  }
	  public boolean isCorrect(int x, int y)
	  {
		  if(x==this.initialX && y==this.initialY)
		  {
			return true;  
		  }
		  return false;
	  }
}

























