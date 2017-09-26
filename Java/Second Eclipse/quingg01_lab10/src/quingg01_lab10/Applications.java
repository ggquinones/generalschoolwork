package quingg01_lab10;
/*
 * <Gabriel Quiñones>
 * CS160-01 Fall 2014
 * Lab 10
 */
import java.util.Random;
// Class where the project runs
public class Applications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size =10;
		String[] names={"Joe","Paul","John","Gabe","Tom","Mack","Matt","Yoe","Lop","Pol"};
		boolean[] values= new boolean[size];
		Random rd = new Random();
		
		for(int i=0;i<values.length;i++)
		{
			int choice=rd.nextInt(2);
			if(choice==1)
			{
				values[i]=true;
			}
			else
			{
				values[i]=false;
			}
		}
		Letter[] lts = new Letter[size];
		for(int i =0;i<lts.length;i++)
		{
			lts[i]=new Letter(names[i],values[i]);
		}
		POBox box =new POBox(lts,rd.nextInt(8999)+1001);
		POBox boxClone= new POBox(box);
		Letter[] temp1=box.getLetters();
		Letter[] temp2=boxClone.getLetters();
		boolean truth = temp1[0]==temp2[0];
		System.out.println("Check if the copy is deep!\n"
				+ "Apply operator == to the 0 index entries"
				+ " of the letters array and its clone:\n"+truth);
		System.out.println("box:");
		System.out.println(box.toString());
		System.out.println(boxClone
				.toString());
		
		boolean tru = box.equals(boxClone);
		System.out.println("box and its copy tested for equality: "+tru);
	}

}
