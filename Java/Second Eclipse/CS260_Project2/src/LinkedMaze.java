import java.util.Scanner;

/*	Class Specification:
 *  LinkedMaze is a class which is used to represent a maze of Cell objects.
 * 	The class builds a maze, and finds a path, if possible to traverse it. If
 *  it cannot find one it will display the path it has found. It will also 
 *  print out the Manhattan distance of the path that is found. The class
 *  utilizes a Queue data structure and a breadth first algorithm to find
 *  the path through the maze.
 * 
 * 	Class Instance Fields:
 * 	Queue pathfinder: data structure used in the path finding algorithm. 
 * 
	Cell entry, exit, maxCell: store the first Cell in the maze, top left corner by definition, the last Cell in the maze, bottom right corner by definition
	and the Cell where the maxDistance was found, respectively.
	
	Cell cells [][]: two dimensional array of Cell objects used to represent the maze.
	
	int length, width, maxDistance : store the length of the two dimensional array cells, the width of the two dimensional array cells, and the max distance
	or Manhattan distance from the last step in the path found to the Cell entry, explicitly defined as row + column of the two dimensional array cells,
	 respectively
 * 	
 *  Class Methods:
 *  
 * 	LinkedMaze()
 *  Class constructor 
 *  Parameters: grid dimensions and a Queue reference to initialize those fields.
 *  PostCondition:
 *  Instantiates the cells array to the given dimensions.
 *  Populates the array with Cell objects.
 *  Assigns entry the cells[0][0] element and exit the lower right corner element of the array
		
	connectMaze() 
	Method uses two input files to construct the maze by assigning the appropriate values to each cells directional links.
	Return: void
	Parameters:two Scanner objects to read the files characterizing the north-south walls, and the other file having the east-west walls.
	PreCondition: Cells objects in cells have all their directional links set to null
	PostCondition: Assigns correct values to the directional links of each cell based on input files
	
	findPath()
	Method uses a breadth first algorithm to attempt to solve the maze.
	Returns: boolean, true if solution found false otherwise
	Precondition: No path through maze exists
	PostCondition: Uses breadth first algorithm to find either solution for maze, or the farthest it can go
	Also calculates Manhattan Distance,updating maxDistance, and updates maxCell.
	
	reversePath () 
	Given a cell current on a path, the method uses the backLinks which create a linked list such that current is the head and entry is the tail to make
	a new list by reversing the links and making entry the head and current the tail.  
	Returns:Cell object, new head of linked list path of backLinks.
	Parameters: Cell object,last cell in path 
	
	displayPath ( ) 
	Method displays the coordinates of the Cells in the path.
	No parameters.
	Void Method
	Post Condition:	prints the coordinates of the cells along a path, starting at the entry cell 

 */
public class LinkedMaze 
{
	Queue pathfinder;
	Cell entry, exit, maxCell;
	Cell cells [][];
	int length, width, maxDistance=0;

	public LinkedMaze(int length,int width, Queue pathfinder)
	{
		this.length=length;
		this.width=width;
		this.pathfinder=pathfinder;
		cells=new Cell[length][width];
		for(int i=0; i<cells.length;i++)
		{
			for(int k=0;k<cells[i].length;k++)
			{
				cells[i][k]=new Cell(i,k);
			}
		}
		
		entry=cells[0][0];
		exit=cells[length-1][width-1];
	}
	
		public void connectMaze(Scanner NSReader, Scanner EWReader)
		{
			int NS,EW;
			for(int i=0; i<cells.length;i++)
			{
				
				for(int k=0;k<cells[i].length;k++)
				{
					
					
					if(NSReader.hasNext() && EWReader.hasNext())
					{
						NS=NSReader.nextInt(); //what is read in from NS file
						EW=EWReader.nextInt(); //what is read in from EW file
						
						if(NS==0)
						{
							try{
								if(i+1 != length)
									cells[i][k].sLink=cells[i+1][k];
								
								if(Cell.linked(cells[i][k],cells[i-1][k]))
								{
									cells[i][k].nLink=cells[i-1][k];
								}
								
							}catch(IndexOutOfBoundsException ex){}catch(NullPointerException e){}
						}
						
						if(EW==0)
						{
							try{
								if(k+1 != length)
									cells[i][k].wLink=cells[i][k+1];
								
								if(Cell.linked(cells[i][k],cells[i][k-1]))
								{
									cells[i][k].eLink=cells[i][k-1];
								}
								
							}catch(IndexOutOfBoundsException ex){}catch(NullPointerException e){}
						}
					}
				}
			}
		}
		
		
		public boolean findPath() 
		{
			boolean answer =false;
			Cell current=null;
			entry.visited=true;
			pathfinder.enqueue(entry);
			while(!(pathfinder.isEmpty()))
			{
				current = pathfinder.dequeue();
				if(Cell.linked(current,exit))
				{
					exit.setBLink(current);
					reversePath(exit);
					return true;
					
				}
				else
				{
					if(current.nLink != null) // checks of nLink of current is NOT null
					{
						current.nLink.setBLink(current); // sets the backLink of current's nLink to current
						current.nLink.visited=true;    // sets the nLink of current as visited
						pathfinder.enqueue(current.nLink); // enqueues the nLink of current
					}
					
					if(current.sLink != null) // checks of sLink of current is NOT null
					{
						current.sLink.setBLink(current); // sets the backLink of current's sLink to current
						current.sLink.visited=true;    // sets the sLink of current as visited
						pathfinder.enqueue(current.sLink); // enqueues the sLink of current
						if(current.sLink.row+current.sLink.column>maxDistance) // checks if currents sLink is the new Max Distance, if so it updates maxCell and maxDistance
						{
							maxDistance=current.sLink.row+current.sLink.column;
							maxCell=current.sLink;
						}
					}
					
					if(current.eLink != null) // checks of eLink of current is NOT null
					{
						current.eLink.setBLink(current); // sets the backLink of current's eLink to current
						current.eLink.visited=true;    // sets the eLink of current as visited
						pathfinder.enqueue(current.eLink); // enqueues the eLink of current
						
						if(current.eLink.row+current.eLink.column>maxDistance) // checks if currents eLink is the new Max Distance, if so it updates maxCell and maxDistance
						{
							maxDistance=current.eLink.row+current.eLink.column;
							maxCell=current.eLink;
						}
					}
					
					if(current.wLink != null) // checks of wLink of current is NOT null
					{
						current.wLink.setBLink(current); // sets the backLink of current's wLink to current
						current.wLink.visited=true;    // sets the wLink of current as visited
						pathfinder.enqueue(current.wLink); // enqueues the wLink of current
					}
					
				}
					
					
				
				
			}
			
			
			
			
			reversePath(current);
			
			return answer;
		}
		
		
		
		public Cell reversePath(Cell current)
		{
			int count =0;
			Cell temp1,temp2;
			while(current!=null)
			{
				 
				if(count == 0)
				{
					System.out.println(current);
					temp1=current.backLink.backLink; // save bLink for next loop
					temp2=current.backLink;
					
					current.backLink.setBLink(current);
					current.setBLink(null);
					current=temp1;
					count++;
					
				}
				else
				{
					temp1=current.backLink.backLink; // save bLink for next loop
					temp2=current.backLink;
					current.backLink.setBLink(current);
					current=temp1;
					
				}
				
			}
			
			
			System.out.println("reverse done");
			return current;
		}
		
		public void displayPath()
		{
			Cell current =entry;
			while(current.backLink != null)
			{
				System.out.print(current.toString()+"\t");
				current=current.backLink;
			}
			System.out.print(current.toString()); // gets the last one in the path whose bLink should be null
		}
}






