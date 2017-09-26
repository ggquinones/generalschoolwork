import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

import javax.swing.*;

public class DrawingGame {
  public static void main(String[] args) {
    MyFrame f = new MyFrame();
   
    
    
    f.setFocusable(true);
    f.setVisible(true);
    }
}

class MyFrame extends JFrame {
  MyPanel p;
  public MyFrame() {
    
	  setSize(500, 500);
	  JLabel text = new JLabel();
    JPanel buttonPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    p = new MyPanel(text);
    add(p);
    
    JMenuBar bar = new JMenuBar();
    setJMenuBar(bar);
    JMenu color = new JMenu("Color");
    JMenu exit = new JMenu("Exit");
    
    bar.add(color);
    bar.add(exit);
    
    JMenuItem green = new JMenuItem("Green");
    JMenuItem red = new JMenuItem("Red");
    JMenuItem blue  = new JMenuItem("Blue");
    JMenuItem exitTab = new JMenuItem("Exit Program");
    
     
    text.setText("Blue");
    color.add(green);
    color.add(red);
    color.add(blue);
    exit.add(exitTab);
    
    JButton blueButton = new JButton("Blue");
    JButton redButton = new JButton("Red");
    JButton greenButton = new JButton("Green");
    
    buttonPanel.add(blueButton);
    buttonPanel.add(redButton);
    buttonPanel.add(greenButton);
    infoPanel.add(text);
    add(buttonPanel,BorderLayout.SOUTH);
    add(infoPanel,BorderLayout.NORTH);
    
    this.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) 
        {
          char c = e.getKeyChar();
          if (c=='r')
  	    	{
  	    	p.changeColor(Color.RED);
  	    	}
  	    else if(c=='b')
  	    	{
  	    	p.changeColor(Color.BLUE);
  	    	}
  	    else if(c=='g')
  	    	{
  	    	p.changeColor(Color.GREEN);
  	    	}


        }
        });

    green.addActionListener(new ColorListener(Color.GREEN,text));
    greenButton.addActionListener(new ColorListener(Color.GREEN,text));
    red.addActionListener(new ColorListener(Color.RED,text));
    redButton.addActionListener(new ColorListener(Color.RED,text));
    blue.addActionListener(new ColorListener(Color.BLUE,text));
    blueButton.addActionListener(new ColorListener(Color.BLUE,text));
   
    exitTab.addActionListener(new exitListener(this));
  }
  
  class ColorListener implements ActionListener{
    private Color color;
    public ColorListener(){
      color = Color.BLUE;
     
    }
    public ColorListener(Color color,JLabel label){
      this.color = color;
      if(color.equals(Color.BLUE))
      {
    	  label.setText("BLUE");
    	  
      }
      else if(color.equals(Color.RED))
      {
    	  label.setText("RED");
    	  
      }
      else if(color.equals(Color.GREEN))
      {
    	  label.setText("GREEN");
      }
    }
    public void actionPerformed(ActionEvent e){
      p.changeColor(color);
    }
  }
  
  public MyPanel getPanel()
  {
  	return p;
  }
}


class exitListener implements ActionListener
{
	private MyFrame frame;
	public exitListener(MyFrame frame){
	      this.frame=frame;
	    }
	public void actionPerformed(ActionEvent e){
	      frame.dispose();
	    }

}




class MyPanel extends JPanel {
	  ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	  private Color currentColor;
	  private JLabel label;
	  public void changeColor(Color newColor){
	    currentColor = newColor;
	  }
	  public MyPanel(JLabel label) {
		  this.label=label;
		 
	    addMouseListener(new MouseAdapter() {int check = 0;
	      public void mousePressed(MouseEvent e) {
	         if(check==0)
	         {
	        	 check++;
	    	  if (e.getButton() == 1) 
	    	  {
	          shapes.add(new MyShape(e.getPoint(),currentColor));	
	          setLabelText();
	          repaint();
	    	  }
	         }
	         else if(check==1)
	         {
	        	 
	        	 
	        	 shapes = new ArrayList<>();
	        	 shapes.add(new MyShape(e.getPoint(),currentColor));
	        	 setLabelText();
	             repaint();

	         }
	       }
	     
	      
	    });
	    addMouseMotionListener(new MouseMotionAdapter() {
	      public void mouseDragged(MouseEvent e) {
	        
	        if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) 
	                                                         != 0) {
	        	shapes.get(shapes.size() - 1).
                addPoint(e.getPoint());
repaint();
}
}
	      
});
}
	  public void setLabelText()
	  {
		  if(currentColor.equals(Color.BLUE))
	      {
	    	  label.setText("BLUE");
	    	  
	      }
	      else if(currentColor.equals(Color.RED))
	      {
	    	  label.setText("RED");
	    	  
	      }
	      else if(currentColor.equals(Color.GREEN))
	      {
	    	  label.setText("GREEN");
	      }
	  }
public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D) g;
	g.setColor(Color.BLUE);
	for (MyShape s : shapes)
		{
			s.drawShape(g2);
		}
}

}


class MyShape {
private ArrayList<Point2D> points = 
              new ArrayList<Point2D>();
private Color color;
public MyShape(){
color = Color.BLUE;
}
public MyShape(Point2D point, Color color) {
    this.color = color;
    points.add(point);
  }

  public void addPoint(Point2D point) {
    points.add(point);
  }

  public void drawShape(Graphics2D g) {
    g.setPaint(color);
    if (points.size() == 0) {
      return;
    }
    Point2D start = points.get(0);
    for (Point2D end : points) {
      g.draw(new Line2D.Double(start, end));
      start = end;
    }
  }
}
