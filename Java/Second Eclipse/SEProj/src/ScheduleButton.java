
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Special button made to implement a seeable schedule where you can click the times where someone is
 * not available and the color changes to match that.
 * Green is available
 * Yellow occupied
 * @author Gabriel
 *
 */
public class ScheduleButton extends JLabel{
	
	private Color backGround = Color.GREEN;
	
	public ScheduleButton(String label){
		setOpaque(true);
		setText(label);
		setBackground(backGround);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		repaint();
		
		button();
		
	}
	
	public ScheduleButton(String label, Color color){
		backGround = color;
		setOpaque(true);
		setText(label);
		setBackground(backGround);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		repaint();
		
		button();
	}
	
	public void button(){
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				if (backGround == Color.GREEN) {
					backGround = Color.YELLOW;
					setBackground(backGround);
					}
				else if(backGround == Color.YELLOW){
					backGround = Color.GREEN;
					setBackground(backGround);
				}
				repaint();
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setBackground(Color.CYAN);
				repaint();
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				setBackground(backGround);
				repaint();
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		//g2.;
	}
	
	public Color getColor(){
		return backGround;
	}
	
	public void setColor(Color color){
		backGround = color;
	}
}