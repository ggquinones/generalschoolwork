import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Application {
	public static void main(String[] args) throws FileNotFoundException {
		String [] words=new String[101];
		Scanner fr = new Scanner(new File("words.txt"));
		int i=0;
		while(fr.hasNext())
		{
			words[i]=fr.next();
			i++;
		}
		BinaryHeap maxHeap = new BinaryHeap(101);		
		maxHeap.heapFactory(words);
		maxHeap.trim();
		System.out.println(maxHeap);
	}

}
