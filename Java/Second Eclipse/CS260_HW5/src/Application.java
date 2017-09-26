import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Application 
{
 /*Gabriel Quinones
  * CS260
  * HW 5
  *  COMMENT FOR GRADER !!!!
  *  For some reason a bunch of empty lines are printed at the end of the output so scroll up and the sorted list is there!
  *  I swear!
  */
	public static void main(String[] args) throws IOException
	{
		
		LinkedListStack<?> stack = new LinkedListStack<Object>();
		
		Scanner reader = new Scanner(new File("Numbers.txt"));
		while(reader.hasNext())
		{
			int next = reader.nextInt();
			stack.addAfter(next);	
			
		}
		
		System.out.println(sort(stack).displayStack());
		reader.close();
	}

	 public static LinkedListStack<?> sort(LinkedListStack<?> stack1)
	 {
		 LinkedListStack<?> stack2=new LinkedListStack<Integer>();
		
		while(!stack1.isEmpty())
		{
			int temp = stack1.pop();
			while(!stack2.isEmpty() && (Integer)stack2.peek()>temp)
			{
				stack1.push(stack2.pop());
			}
			stack2.push(temp);
		}
		 
		return stack2;	 
		 
	 }
}
 /*	Analysis and Design:
  * a) The class will work by making a stack using a linked list. As part of that class the method addAfter() will be crucial for setting up the stack
  *    The class methods, pop, push, peek and isEmpty will also be crucial to the implementation of the program.
  *    The general design will be simple. First the stack will be loaded with numbers from a file using the addAfter method.
  *    Then using a static sort method in the Application class, the stack will be sorted using a temporary
  *    stack and then the sorted stack will be printed out.
  *    In the stack method we will need the LinkedListStack methods push, pop, peek, and isEmpty.
  *    
  *    Pseudocode:
  *    -Declare LinkedListStack and Scanner 
  *    -while(reader.hasNext()) stack.addAfter(readInNumber)
  *    -sort stack
  *    	i)make temp stack
  *    	ii) while(stack1 not empty) loop and pop top of stack1 into a temp int
  *     iii) while stack2 isnt empty and top of stack2 is greater than temp, push the top
  *      of stack2 onto stack1,when false push temp on stack2. Then return sorted array.
  *    - Use displayStack() method to printout stack  
  *    
  *    Big Oh: O(n^2)
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  * 
  */
