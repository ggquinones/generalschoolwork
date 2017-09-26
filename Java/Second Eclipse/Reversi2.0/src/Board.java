import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * This class is the brains of the whole Reversi game. It extends the JPanel class.
 * The class works around a 2D array of Color objects which signify the chips.
 * The class also contains the mouse listeners which make the game possible.
 * The class also contains the AI code which allows one to play against the computer
 * @author Gabriel Quiñones-Sanchez
 *
 */

public class Board extends JPanel
{
	
	private Color[][] colors = new Color[8][8];
	private ArrayList<int[]> possibleMoves = new ArrayList<>();	
	private static int turn=1;	
	private static Color turnColor;  
	final int SQUARESIDE=50;
	final int CHIPSIZE=30;
	//Colors used in this project
	final Color AI = Color.BLUE;
	final Color PLAYER = Color.RED;
	final Color BLANK = Color.WHITE;
	final Color HIGHLIGHT = Color.GREEN;	
	
	/**
	 * Board constructor which adds and makes the mouse listeners
	 */
	public Board()
	{
		
		setBackground(BLANK);
		
		addMouseListener( new MouseAdapter(){
			
			
			public void mousePressed(MouseEvent click)
			{
				int row= getRowORCol(click.getY());
				int col = getRowORCol(click.getX());
				
				if(isBoardFull())
				{					
					JOptionPane.showMessageDialog(null,"Board is full!\nWinner is "+getWinner(getReds(colors),getBlues(colors))+"\nRed has: "+getReds(colors)+"\nBlue has: "+getBlues(colors)
				,"GAME OVER",JOptionPane.WARNING_MESSAGE);
				}
				else if(!(anyMovesToMake()))
				{
					JOptionPane.showMessageDialog(null,"No moves left!\nWinner is "+getWinner(getReds(colors),getBlues(colors))+"\nRed has: "+getReds(colors)+"\nBlue has: "+getBlues(colors),"GAME OVER",JOptionPane.WARNING_MESSAGE);
				}				
				else if(moveIsValid(row,col,PLAYER) )
				{
					colors[row][col]=PLAYER;
					AIMove();				
				}
				else if(!movesLeft(PLAYER))
				{
					JOptionPane.showMessageDialog(null,"PASS\n+RED has no moves.","PASS",JOptionPane.WARNING_MESSAGE);
					AIMove();
				}

				repaint();
			
			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			
			public void mouseMoved(MouseEvent mouse)
			{
				int row= getRowORCol(mouse.getY());
				int col = getRowORCol(mouse.getX());
				
				
				if(canPlayHere(getRowORCol(mouse.getY()),getRowORCol(mouse.getX()),getCurrentColor()))
				{
					colors[getRowORCol(mouse.getY())][getRowORCol(mouse.getX())]=Color.GREEN;
				}	
				else if(!(canPlayHere(getRowORCol(mouse.getY()),getRowORCol(mouse.getX()),getCurrentColor())))
				{
					setGreensWhite();
				}
				
				repaint();
			}
		});
		
		
	}
	
	
	/**
	 * Method that paints all the necessary components
	 * @param g- Takes as a parameter a Graphic, g, which is the brush
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;		
		
		if(turn==1) //before first turn draw board and initial chips, and randomly select who starts
		{			
			drawBoard(g2);
			initialColors();
			setTurnColor();		
			turn++;
		}
		else
		{
			drawBoard(g2);
			drawChips(g2);
			
		}	
	}
	
	/**
	 * 	Method to fill initial colors array
	 */
	public void initialColors()
	{
		for(int i =0;i<8;i++)
		{
			for(int k=0;k<8;k++)
			{
				colors[i][k]=BLANK;
			}
		}
		
		colors[3][3]=PLAYER;
		colors[4][4]=PLAYER;
		colors[3][4]=AI;
		colors[4][3]=AI;
		
	}
	
	/**
	 * Method to draw board. Made up
	 * of rectangles.
	 * @param g2- 2D drawing brush
	 */
	public void drawBoard(Graphics2D g2)
	{
		
		
		for(int i=0,x=50;i<8;i++,x+=50)
		{			
			for(int k=0,y=50;k<8;k++,y+=50)
			{
							
				g2.draw(new Rectangle2D.Double(x,y,SQUARESIDE,SQUARESIDE));
			}			
		}		
	}
	
	/**
	 * Sets the the highlighted spots on the board to blank. 
	 */
	public void setGreensWhite()
	{
		for(int i =0;i<colors.length;i++)
		{
			for(int k=0;k<colors.length;k++)
			{
				if(colors[i][k].equals(HIGHLIGHT))
				{
					colors[i][k]=BLANK;
				}
			}
		}
	}

	/**
	 * Method to randomly set the start color
	 */
	public void setTurnColor()
	{
		if((int)(Math.random()*2)==0)
		{
			
			this.turnColor=PLAYER;
		}
		else
		{
			AIMove();
			this.turnColor=PLAYER;			
			
		}		
	}

	/**
	 * Method to draw initial chips on board.
	 * @param g2-paint brush which draws
	 * 
	 */
	public void drawChips(Graphics2D g2)
	{
		for(int i=0,y=60;i<8;i++,y+=50)
		{			
			for(int k=0,x=60;k<8;k++,x+=50)
			{
				g2.setColor(colors[i][k]);				
				Ellipse2D temp = new Ellipse2D.Double(x,y,CHIPSIZE,CHIPSIZE);
				g2.draw(temp);
				g2.fill(temp);
			}			
		}
		
		
	}
	
	/**
	 * Method that return the number of red chips on the board.
	 * @param array- 2D array of colors to be counted from
	 * @return- of type int
	 */
	public int getReds(Color[][] array)
	{
		int count=0;
		for(int i =0;i<array.length;i++)
		{
			for(int k=0;k<array.length;k++)
			{
				if(array[i][k].equals(PLAYER))
				{
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Method that returns the number of blue chips on the board.
	 *  @param array- 2D array of colors to be counted from
	 * @return-type int return.
	 */
	public int getBlues(Color[][] array)
	{
		int count=0;
		for(int i =0;i<array.length;i++)
		{
			for(int k=0;k<array.length;k++)
			{
				if(array[i][k].equals(AI))
				{
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Return the string representation of the winner of the game or if it is a draw.
	 * @param reds - int of reds on board
	 * @param blues - int of blues on board
	 * @return - String return
	 */
	public String getWinner(int reds, int blues)
	{
		if(reds>blues)
		{
			return("RED");
		}
		else if(blues>reds)
		{
			return("BLUE");
		}
		else
		{
			return("NO ONE!\nIT'S A DRAW");
		}
	}
	
	/**
	 * Method that takes in the coordinates of a MouseEvent and returns the corresponding
	 * row or column on the board. 
	 * @param coord - int of either the x coordinate or y coordinate given by MouseEvent method getX() or getY()
	 * @return- int return 
	 */
	public int getRowORCol(int coord)
	{
		
		if(coord>=50 && coord<100)
		{
			return 0;
		}
		else if(coord>=100 && coord<150)
		{
			return 1;
		}
		else if(coord>=150 && coord<200)
		{
			return 2;
		}
		else if(coord>=200 && coord<250)
		{
			return 3;
		}
		else if(coord>=250 && coord<300)
		{
			return 4;
		}
		else if(coord>=300 && coord<350)
		{
			return 5;
		}
		else if(coord>=350 && coord<400)
		{
			return 6;
		}
		else 
		{
			return 7;
		}
	}
	
	/**
	 * Method to see if a move is valid.
	 * @param row - int, row of where the click was made on the board
	 * @param col - int, column of where the click was made on the board
	 * @param turnColor - Color, color of the current turn.
	 * @return - returns
	 */
	public boolean moveIsValid(int row,int col, Color turnColor)
	{
		
		if(isEmpty(row,col) || colors[row][col].equals(HIGHLIGHT) )
		{
			if(validVertically(row,col,turnColor) ||  validHorizontally(row,col,turnColor) || validDiagonally(row,col,turnColor) )
			{
				if(validVertically(row,col,turnColor)){}
				
				if(validHorizontally(row,col,turnColor)){}
				
				if(validDiagonally(row,col,turnColor)){}
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 	Method that checks if a proposed move is valid horizontally,
	 *  that is the proposed move takes an opposing chip left or 
	 *  right of it or both.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, and also changes the chips that need to be changed)
	 * 
	 */
	public boolean validHorizontally(int row, int col, Color click)
	{
	    boolean answer =false;
	    
	    try // tries and check to the right
	    {
	    	 int clickCol = col;
	    	 Color oneRight = colors[row][clickCol+1];
	    	 int deltaCol =col+2;
	    	 Color oneMoreRight = colors[row][deltaCol];
	    	 
	    	 if( (!(oneRight.equals(click))) && (!(oneRight.equals(BLANK)))   )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreRight.equals(click))) && (!(oneMoreRight.equals(BLANK))) )
	    			 {
	    				 oneMoreRight=colors[row][deltaCol++];
	    			 }
	    			 else if(oneMoreRight.equals(click) )
	    			 {
	    				 switchColorsH(row,col,deltaCol-1,click);
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }

	    	

	    }catch(IndexOutOfBoundsException e){}
	    
	    try // tries and check to the left
	    {
	    	int clickCol=col; 
	    	Color oneLeft = colors[row][clickCol-1];
	    	 int deltaCol =col-2;
	    	 Color oneMoreLeft = colors[row][deltaCol];
	    	 
	    	 if( (!(oneLeft.equals(click))) && (!(oneLeft.equals(BLANK)))  )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreLeft.equals(click))) && (!(oneMoreLeft.equals(BLANK)))    )
	    			 {
	    				 deltaCol--;
	    				 oneMoreLeft=colors[row][deltaCol];
	    			 }
	    			 else if(oneMoreLeft.equals(click) )
	    			 {
	    				 switchColorsH(row,deltaCol,col,click);
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }

	    }catch(IndexOutOfBoundsException e){}
	    
	    
	    
	    return answer;
	}
	
	
	/**
	 * 	Method that checks if a proposed move is valid vertically,
	 *  that is the proposed move takes an opposing chip above or 
	 *  below it or both.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, and also changes the chips that need to be changed)
	 * 
	 */
	public boolean validVertically(int row, int col, Color click)
	{
		boolean answer = false;
		
		try // checks Up
		{
			int clickRow=row; 
			Color oneUp = colors[clickRow-1][col];
	    	 int deltaRow =row-2;
	    	 Color oneMoreUp = colors[deltaRow][col];
	    	 
	    	 if( (!(oneUp.equals(click))) && (   !(oneUp.equals(BLANK))   )  )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreUp.equals(click))) && (!(oneMoreUp.equals(BLANK))))
	    			 {
	    				 deltaRow--;
	    				 oneMoreUp=colors[deltaRow][col];
	    			 }
	    			 else if(oneMoreUp.equals(click))
	    			 {
	    				 switchColorsV(col,deltaRow,row,click);
	    				 
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }
		}catch(IndexOutOfBoundsException e){}
		
		try 
		{
			int clickRow = row; 
			Color oneDown = colors[clickRow+1][col];
	    	 int deltaRow =row+2;
	    	 Color oneMoreDown = colors[deltaRow][col];
	    	 
	    	 if( (!(oneDown.equals(click))) && (!(oneDown.equals(BLANK)) )  )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreDown.equals(click))) && (!(oneMoreDown.equals(BLANK))))
	    			 {
	    				 oneMoreDown=colors[deltaRow++][col];
	    			 }
	    			 else if(oneMoreDown.equals(click))
	    			 {
	    				 switchColorsV(col,row,deltaRow-1,click);
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }
		}catch(IndexOutOfBoundsException e){}
		
		return answer;
	}
	
	/**
	 * 	Method that checks if a proposed move is valid diagonally,
	 *  that is the proposed move takes an opposing chip in a diagonal direction.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, and also changes the chips that need to be changed)
	 * 
	 */
	public boolean validDiagonally(int row,int col, Color click)
	{
		boolean answer = false;
		
		try // try and check down and to the right
		{
			int clickRow =row+1;
			int clickCol=col+1;
			int DRrow=row+2;
			int DRcol=col+2;
			
			Color oneDR = colors[clickRow][clickCol];			
			Color twoDR = colors[DRrow][DRcol];
			
			if(  (!(oneDR.equals(click))) && (!(oneDR.equals(BLANK)))  )
			{
				while((!(twoDR.equals(click))) || ((twoDR.equals(BLANK))))
				{
					DRrow++;
					DRcol++;
					twoDR=colors[DRrow][DRcol];
				}
				
				if((twoDR.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					
					switchColorsDR(row,col,DRrow,DRcol,click);
					answer=true;
				}

			}
			
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check down and to the left
		{
			int clickRow =row+1;
			int clickCol=col-1;
			int DLrow=row+2;
			int DLcol=col-2;
			
			Color oneDL = colors[clickRow][clickCol];			
			Color twoDL = colors[DLrow][DLcol];
			
			if(  (!(oneDL.equals(click))) && (!(oneDL.equals(BLANK)))  )
			{
				while((!(twoDL.equals(click))) || ((twoDL.equals(BLANK))))
				{
					DLrow++;
					DLcol--;
					twoDL=colors[DLrow][DLcol];
				}
				
				if((twoDL.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					switchColorsUR(DLrow,DLcol,row,col,click);
					
					answer=true;
				}

			}
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check up and to the right
		{
			int clickRow =row-1;
			int clickCol=col+1;
			int URrow=row-2;
			int URcol=col+2;
			
			Color oneUR = colors[clickRow][clickCol];			
			Color twoUR = colors[URrow][URcol];
			
			if(  (!(oneUR.equals(click))) && (!(oneUR.equals(BLANK)))  )
			{
				while((!(twoUR.equals(click))) || ((twoUR.equals(BLANK))))
				{
					URrow--;
					URcol++;
					twoUR=colors[URrow][URcol];
				}
				
				if((twoUR.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					switchColorsUR(row,col,URrow,URcol,click);
					
					answer=true;
				}
				
			}
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check up and to the left 
		{
			int clickRow =row-1;
			int clickCol=col-1;
			int ULrow=row-2;
			int ULcol=col-2;
			
			Color oneUL = colors[clickRow][clickCol];			
			Color twoUL = colors[ULrow][ULcol];
			
			if(  (!(oneUL.equals(click))) && (!(oneUL.equals(BLANK)))  )
			{
				while((!(twoUL.equals(click))) && (!(twoUL.equals(BLANK))))
				{
					ULrow--;
					ULcol--;
					twoUL=colors[ULrow][ULcol];
				}
				
				if((twoUL.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					switchColorsDR(ULrow,ULcol,row,col,click);
					
					answer=true;
				}
				
			}
		}catch(IndexOutOfBoundsException e){}
		
		return answer;
	}
	
	/**
	 * Method that returns true if a selected spot is empty 
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @return - boolean return
	 */
	public boolean isEmpty(int row, int col)
	{
		if(colors[row][col].equals(BLANK) )
		{
			return true;
		}
		return false;
	}

	
	/**
	 * Method that switches colors horizontally
	 * @param row- int, row that colors will be switched in
	 * @param start- int, the start point of switching
	 * @param stop - int, the stop point of switching
	 * @param click - Color, color of the current turn
	 */
	public void switchColorsH(int row, int start, int stop, Color click)
	{
		for(int i=start;i<=stop;i++)
		{
			colors[row][i]=click;
		}
	}

	/**
	 * Method that switches colors vertically
	 * @param col- int, column that colors will be switched in
	 * @param start- int, the start point of switching
	 * @param stop - int, the stop point of switching
	 * @param click - Color, color of the current turn
	 */
	public void switchColorsV(int col, int start, int stop, Color click)
	{
		for(int i=start;i<=stop;i++)
		{
			colors[i][col]=click;
		}
	}
	
	/**
	 * Method that switched colors in the direction Down and Right
	 * So its used when a move is valid diagonally,down and right or up and left.
	 * @param startrow -int, start row of switching
	 * @param startcol-int, start column of switching
	 * @param endrow- int, end row of switching
	 * @param endcol- int, end column of switching
	 * @param click-Color, color of current turn
	 */
	public void switchColorsDR(int startrow, int startcol, int endrow, int endcol, Color click)
	{
		for(int r= startrow,c=startcol;r<=endrow;r++,c++)
		{
			colors[r][c]=click;
		}
	}
	
	/**
	 * Method that switched colors in the direction Up and Right
	 * So its used when a move is valid diagonally,down and left or up and right.
	 * @param startrow -int, start row of switching
	 * @param startcol-int, start column of switching
	 * @param endrow- int, end row of switching
	 * @param endcol- int, end column of switching
	 * @param click-Color, color of current turn
	 */
	public void switchColorsUR(int startrow, int startcol, int endrow, int endcol, Color click)
	{
		for(int r= startrow,c=startcol;r>=endrow;r--,c++)
		{
			colors[r][c]=click;
		}
	}
	
	/**
	 * Method that returns true if the board is full.
	 * @return- boolean return
	 */
	public boolean isBoardFull()
	{
		for(int i =0;i<colors.length;i++)
		{
			for(int k=0;k<colors.length;k++)
			{
				if(colors[i][k].equals(BLANK))
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Method that returns the current play color
	 * @return-Color return
	 */
	public Color getCurrentColor()
	{
		return turnColor;
	}

	/**
	 * Method that return if a certain color has valid moves 
	 * @param turnColor- checks if this given color has moves to make
	 * @return-boolean return.
	 */
	public boolean movesLeft(Color turnColor)// checks if given turn has moves
	{
		for(int i=0;i<colors.length;i++)
		{
			for(int k =0;k<colors.length;k++)
			{
				if(canPlayHere(i,k,turnColor))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Method that checks if there are any valid moves left to do by either player.
	 * @return- boolean return
	 */
	public boolean anyMovesToMake() 
	{
		for(int i=0;i<colors.length;i++)
		{
			for(int k =0;k<colors.length;k++)
			{
				if(canPlayHere(i,k,PLAYER) || canPlayHere(i,k,AI) )
				{
					return true;
				}
			}
		}		
		return false;
	}
	
	/**
	 *  Method that returns true if a move in a spot is valid, makes no switches
	 * @param row - int, row of spot being looked at
	 * @param col- int, column of spot being looked at
	 * @param click-Color, current turn color
	 * @return- boolean return
	 */	
public boolean canPlayHere(int row, int col, Color click)
	{
		if(isEmpty(row,col))
		{
			if((checkHorizontally(row,col,click) || checkVertically(row,col,click) || checkDiagonally(row,col,click)))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 	Method that checks if a proposed move is valid horizontally,
	 *  that is the proposed move takes an opposing chip left or 
	 *  right of it or both.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, but does not change the chips that need to be changed)
	 * 
	 */
	public boolean checkHorizontally(int row, int col, Color click)
	{
	    boolean answer =false;
	    
	    try // tries and check to the right
	    {
	    	 int clickCol = col;
	    	 Color oneRight = colors[row][clickCol+1];
	    	 int deltaCol =col+2;
	    	 Color oneMoreRight = colors[row][deltaCol];
	    	 
	    	 if( (!(oneRight.equals(click))) && (!(oneRight.equals(BLANK))) && !(oneRight.equals(HIGHLIGHT)) )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreRight.equals(click))) && (!(oneMoreRight.equals(BLANK))))
	    			 {
	    				 oneMoreRight=colors[row][deltaCol++];
	    			 }
	    			 else if(oneMoreRight.equals(click))
	    			 {
	    				 
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }

	    	

	    }catch(IndexOutOfBoundsException e){}
	    
	    try // tries and check to the left
	    {
	    	int clickCol=col; 
	    	Color oneLeft = colors[row][clickCol-1];
	    	 int deltaCol =col-2;
	    	 Color oneMoreLeft = colors[row][deltaCol];
	    	 
	    	 if( (!(oneLeft.equals(click))) && (!(oneLeft.equals(BLANK))) && !(oneLeft.equals(HIGHLIGHT)) )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreLeft.equals(click))) && (!(oneMoreLeft.equals(BLANK))))
	    			 {
	    				 deltaCol--;
	    				 oneMoreLeft=colors[row][deltaCol];
	    			 }
	    			 else if(oneMoreLeft.equals(click))
	    			 {
	    				 
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }

	    }catch(IndexOutOfBoundsException e){}
	    
	    
	    
	    return answer;
	}
	
	
	/**
	 * 	Method that checks if a proposed move is valid vertically,
	 *  that is the proposed move takes an opposing chip above or 
	 *  below it or both.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, but does not change the chips that need to be changed)
	 * 
	 */
	public boolean checkVertically(int row, int col, Color click)
	{
		boolean answer = false;
		
		try // checks Up
		{
			int clickRow=row; 
			Color oneUp = colors[clickRow-1][col];
	    	 int deltaRow =row-2;
	    	 Color oneMoreUp = colors[deltaRow][col];
	    	 
	    	 if( (!(oneUp.equals(click))) && (!(oneUp.equals(BLANK))) && !(oneUp.equals(HIGHLIGHT)) )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreUp.equals(click))) && (!(oneMoreUp.equals(BLANK))))
	    			 {
	    				 deltaRow--;
	    				 oneMoreUp=colors[deltaRow][col];
	    			 }
	    			 else if(oneMoreUp.equals(click))
	    			 {
	    				 
	    				 
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }
		}catch(IndexOutOfBoundsException e){}
		
		try // check down
		{
			int clickRow = row; 
			Color oneDown = colors[clickRow+1][col];
	    	 int deltaRow =row+2;
	    	 Color oneMoreDown = colors[deltaRow][col];
	    	 
	    	 if( (!(oneDown.equals(click))) && (!(oneDown.equals(BLANK))) && !(oneDown.equals(HIGHLIGHT)) )
	    	 {
	    		 for(int i =0;i<8;i++)
	    		 {
	    			 if( (!(oneMoreDown.equals(click))) && (!(oneMoreDown.equals(BLANK))))
	    			 {
	    				 oneMoreDown=colors[deltaRow++][col];
	    			 }
	    			 else if(oneMoreDown.equals(click))
	    			 {
	    				 
	    				 answer=true;
	    				 break;
	    			 }
	    		 }
	    	 }
		}catch(IndexOutOfBoundsException e){}
		
		return answer;
	}
	
	/**
	 * 	Method that checks if a proposed move is valid diagonally,
	 *  that is the proposed move takes an opposing chip in a diagonal direction.
	 *  
	 * @param row- row of chip to be clicked in
	 * @param col-column of chip to be clicked in
	 * @param turnColor- color of players whose turn it is
	 * @return-return true if the move proposed is valid(i.e. takes an opposing chip, but does not change the chips that need to be changed)
	 * 
	 */
	public boolean checkDiagonally(int row,int col, Color click)
	{
		boolean answer = false;
		
		try // try and check down and to the right
		{
			int clickRow =row+1;
			int clickCol=col+1;
			int DRrow=row+2;
			int DRcol=col+2;
			
			Color oneDR = colors[clickRow][clickCol];			
			Color twoDR = colors[DRrow][DRcol];
			
			if(  (!(oneDR.equals(click))) && (!(oneDR.equals(BLANK))) && !(oneDR.equals(HIGHLIGHT)) )
			{
				
				
					while((!(twoDR.equals(click))) && (!(twoDR.equals(BLANK))))
					{
						DRrow++;
						DRcol++;
						twoDR=colors[DRrow][DRcol];
						
					}
				
				if((twoDR.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					answer=true;
				}
				
				
			}
			
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check down and to the left
		{
			int clickRow =row+1;
			int clickCol=col-1;
			int DLrow=row+2;
			int DLcol=col-2;
			
			Color oneDL = colors[clickRow][clickCol];			
			Color twoDL = colors[DLrow][DLcol];
			
			if(  (!(oneDL.equals(click))) && (!(oneDL.equals(BLANK))) && !(oneDL.equals(HIGHLIGHT))  )
			{
				while((!(twoDL.equals(click))) && (!(twoDL.equals(BLANK))))
				{
					DLrow++;
					DLcol--;
					twoDL=colors[DLrow][DLcol];
				}
				
				if((twoDL.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					answer=true;
				}
				
				//answer=true;
			}
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check up and to the right
		{
			int clickRow =row-1;
			int clickCol=col+1;
			int URrow=row-2;
			int URcol=col+2;
			
			Color oneUR = colors[clickRow][clickCol];			
			Color twoUR = colors[URrow][URcol];
			
			if(  (!(oneUR.equals(click))) && (!(oneUR.equals(BLANK))) && !(oneUR.equals(HIGHLIGHT)) )
			{
				while((!(twoUR.equals(click))) && (!(twoUR.equals(BLANK))))
				{
					URrow--;
					URcol++;
					twoUR=colors[URrow][URcol];
				}
				
				if((twoUR.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					answer=true;
				}
				
				//answer=true;
			}
		}catch(IndexOutOfBoundsException e){}
		
		try // try and check up and to the left 
		{
			int clickRow =row-1;
			int clickCol=col-1;
			int ULrow=row-2;
			int ULcol=col-2;
			
			Color oneUL = colors[clickRow][clickCol];			
			Color twoUL = colors[ULrow][ULcol];
			
			if(  (!(oneUL.equals(click))) && (!(oneUL.equals(BLANK))) && !(oneUL.equals(HIGHLIGHT)) )
			{
				while((!(twoUL.equals(click))) && (!(twoUL.equals(BLANK))))
				{
					ULrow--;
					ULcol--;
					twoUL=colors[ULrow][ULcol];
				}
				
				if((twoUL.equals(BLANK)))
				{
					answer=false;
				}
				else
				{
					answer=true;
				}
				
			}
		}catch(IndexOutOfBoundsException e){}
		
		return answer;
	}
	
													/*AI STUFF*/
	/**
	 * Method that makes the AI's move. Most of the work is in other methods.
	 */
	public void AIMove()
	{
		
		if(movesLeft(AI))
		{
			getAIPossibleMoves();
			removeCornerAdjLocFromOpts();
			for(int i =0;i<possibleMoves.size();i++)
			{
				
				
					if(canAIPlayCorners())
					{
						int [] corner = getCorner();
						colors[corner[0]][corner[1]]=AI;
					}
					else  
					{
						int [] choice=chooseAIMove();
						System.out.println("AI Moved\n{"+choice[0]+","+choice[1]+"}");
						moveIsValid(choice[0],choice[1], AI);
						possibleMoves.clear();
						break;
					}

			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"PASS\nBlue has no moves.","PASS",JOptionPane.WARNING_MESSAGE);
		}
		repaint();
	}
	
	
/**
 * Goes through all blank spots and determines whether any of them are possible AI moves.
 * Adds possible moves to possibleMoves ArrayList	
 */
public void getAIPossibleMoves()
	{
		for(int i=0;i<colors.length;i++)
		{
			for(int k =0;k<colors.length;k++)
			{
				 
				if((canPlayHere(i,k,AI)))
				{
					int [] coords ={i,k};
					System.out.println("AI MOVES\n{"+i+" "+k+"}");
					possibleMoves.add(coords);
					
				}
			}
		}
	}
	

	
/** 
 * Method that returns a corner the AI can play in.
* @return- returns an int[] which holds the coordinates of the corner the AI can play in. Holds row and then column
* 	
*/
public int[] getCorner()
	{
		int [] coords={0,0};
		if((canPlayHere(0,7,AI)))
		{
			coords[0]=0;
			coords[1]=7;
		}
		else if((canPlayHere(7,0,AI)))
		{
			coords[0]=7;
			coords[1]=0;
		}
		else if((canPlayHere(7,7,AI)))
		{
			coords[0]=7;
			coords[1]=7;
		}
		
		return coords;
	}
	

/**
 * Method that returns true if the AI can play one of ther corners
 * @return- boolean return
 */
public boolean canAIPlayCorners()
	{
		if((canPlayHere(0,0,AI)) ||(canPlayHere(0,7,AI))||(canPlayHere(7,0,AI))||(canPlayHere(7,7,AI)) )
		{
			return true;
		}
		return false;
	}

/**
 * Method that chooses from a list of moves the AI move that takes away the least amount of opponent chips
 * @return returns an int[] which holds the coordinates of the "choice" the AI will play. Holds row and then column
 */
public int[] chooseAIMove()
{
	Color[][] temp = copyBoard(colors);	
	int blues=0;

	
	int rowTemp= possibleMoves.get(0)[0];
	int colTemp= possibleMoves.get(0)[1];
	moveIsValid(rowTemp,colTemp,AI);
	int lowestBlues=getBlues(colors);
	
	int index=0;
	for(int i =0;i<possibleMoves.size();i++)
	{
		rowTemp= possibleMoves.get(i)[0];
		colTemp= possibleMoves.get(i)[1];
		moveIsValid(rowTemp,colTemp,AI);
		blues=getBlues(colors);
		colors=copyBoard(temp);
		if(blues<lowestBlues)
		{
			index=i;
			lowestBlues=blues;
		}
		
	}
	
	
	colors=copyBoard(temp);
	return(possibleMoves.get(index));
	

}


/**
 * Method which copies Color 2D arrays
 * @param board- array to be copied
 * @return- Color[][] returned with a deep copy of the array to be copied
 */
public Color[][] copyBoard(Color[][] board)
{
	Color[][] temp = new Color[8][8];
	for(int i=0;i<board.length;i++)
	{
		for(int k=0;k<board.length;k++)
		{
			temp[i][k]=board[i][k];
		}
	}
	return temp;
}


/**
 * Method which removes moves that are adjacent to free corners.
 */
public void removeCornerAdjLocFromOpts()
{
	if(colors[0][0].equals(BLANK)) // first corner
	{
		
		for(int i=0;i<possibleMoves.size();i++)
		{
			if((possibleMoves.get(i)[0]==0 && possibleMoves.get(i)[1]==1 ) || (possibleMoves.get(i)[0]==1 && possibleMoves.get(i)[1]==1 ) || (possibleMoves.get(i)[0]==1 && possibleMoves.get(i)[1]==0 ))
			{
				possibleMoves.remove(i);
			}
		}
	}
	
	if(colors[0][7].equals(BLANK)) // second corner
	{
		for(int i=0;i<possibleMoves.size();i++)
		{
			if((possibleMoves.get(i)[0]==0 && possibleMoves.get(i)[1]==6 ) || (possibleMoves.get(i)[0]==1 && possibleMoves.get(i)[1]==6 ) || (possibleMoves.get(i)[0]==1 && possibleMoves.get(i)[1]==7 ))
			{
				possibleMoves.remove(i);
			}
		}
	}
	
	if(colors[7][0].equals(BLANK)) // third corner
	{
		for(int i=0;i<possibleMoves.size();i++)
		{
			if((possibleMoves.get(i)[0]==6 && possibleMoves.get(i)[1]==0 ) || (possibleMoves.get(i)[0]==6 && possibleMoves.get(i)[1]==1 ) || (possibleMoves.get(i)[0]==7 && possibleMoves.get(i)[1]==1 ))
			{
				possibleMoves.remove(i);
			}
		}
	}
	
	
	if(colors[7][7].equals(BLANK)) // fourth corner
	{
		for(int i=0;i<possibleMoves.size();i++)
		{
			if((possibleMoves.get(i)[0]==6 && possibleMoves.get(i)[1]==6 ) || (possibleMoves.get(i)[0]==6 && possibleMoves.get(i)[1]==7 ) || (possibleMoves.get(i)[0]==7 && possibleMoves.get(i)[1]==6 ))
			{
				possibleMoves.remove(i);
			}
		}
	}
	
	
}




} // end of board class
