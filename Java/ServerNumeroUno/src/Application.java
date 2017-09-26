import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Server Side for Java Server Research
public class Application 
{
	public static void main(String[] args)
	{
		try{
			ServerSocket server = new ServerSocket(8888);
			Socket connectionToTheClient = server.accept();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
}
