/*
 * Cell class used to represents the cells in the maze for project 2.
 * Instance Fields:
 * 	int row,column (position in maze)
	Cell nLink, eLink, sLink, wLink, backLink (whether the Cell is passable in each cardinal direction, and a link to the previous Cell)
	boolean visited (Tells whether the Cell has been visited during traversal)
	Methods:
	public Cell(int row, int column)
	public static boolean linked(Cell current,Cell other)
	public String toString()
	public boolean equals(Cell other)
	public int sum()
	Specifications for methods given below.
 */
public class Cell 
{
	int row,column;
	Cell nLink, eLink, sLink, wLink, backLink ;
	boolean visited;
	
	/*
	 * Cell constructor
	 * Parameters: int row, int column (denote location of cell in maze)
	 * PreC: no cell
	 * PostC: Cell object made with location in the maze of (row,column) 
	 */
	public Cell(int row, int column)
	{
		this.row=row;
		this.column=column;
		visited=false;
		
	}
	/*
	 * Checks if one Cell is neighbored by another
	 */
	public static boolean linked(Cell thisOne,Cell thatOne)
	{
		boolean answer=false;
		
		
		try{
			if(thisOne.nLink.equals(thatOne))
				answer=true;
		}catch(NullPointerException e){}
		
		try{
			if(thisOne.sLink.equals(thatOne))
				answer=true;
		}catch(NullPointerException e){}
		
		try{
			if(thisOne.eLink.equals(thatOne))
				answer=true;
		}catch(NullPointerException e){}
		
		try{
			if(thisOne.wLink.equals(thatOne))
				answer=true;
		}catch(NullPointerException e){}
		
		return answer;
	}
	// class toString method
	public String toString()
	{
		return("("+row+","+column+")");
	}
	// checks if to cells are equal
	public boolean equals(Cell other)
	{
		if(this.row==other.row && this.column==other.column)
		{
			return true;
		}
		return false;
	}
	// gives sum of row + column
	public int sum()
	{
		return (row+column);
	}
	// mutator method for backLink
	public void setBLink(Cell bLink)
	{
		this.backLink=bLink;
	}
}
