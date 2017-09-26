package gabriel_quinones_HW3;



public class Application {

	public static void main(String[] args) 
	{
		
		String [] arr1 = {"Bob","Tom","Hat","Tool","Yeah","Bob"};
		String [] arr2 = {"Joy","Boy","Word","String","Nope","Pool"};
		
		ArrayBag arrBag1 = new ArrayBag(arr1);
		ArrayBag arrBag2 = new ArrayBag(arr2);
		
		System.out.println("This is ArrayBag 1 printed out using the toString() method:\n"+arrBag1.toString()+"\n");
		System.out.println("This is ArrayBag 2 printed out using the toString() method:\n"+arrBag2.toString());
		
		arrBag1.add("New Word");
		System.out.println("This is ArrayBag 1 printed out after adding a new word using the add() method:\n"+arrBag1.toString()+"\n");
		
		arrBag1.addAll(arrBag2);
		System.out.println("This is ArrayBag 1 printed out after adding ArrayBag 2 using the addAll() method:\n"+arrBag1.toString()+"\n");
		
		String [] newWords = {"A","new","bunch"};
		arrBag2.addMany(newWords);
		System.out.println("This is ArrayBag 2 printed out after adding an array of Strings to it using the addMany() method:\n"+arrBag2.toString()+"\n");
		
		ArrayBag arrBag3 = arrBag1.clone(); // not the third array required as part of step three for the homework I will
											// instantiate another array using the constructor with the int type parameter later in my code
		System.out.println("This is ArrayBag 3, a clone of ArrayBag 1, which was cloned using the clone() method:\n"+arrBag1.toString()+"\n");
		
		System.out.println("This is the number of times the word \"Bob\" is in ArrayBag 1, using the countOccurences() method: "+arrBag1.countOccurrences("Bob")+"\n");
		
		arrBag1.remove("Tom");
		System.out.println("This is ArrayBag 1 printed out after removing the word \"Tom\" using the remove() method:\n"+arrBag1+"\n");
		
		System.out.println("This is the product of the method union using ArrayBag 1 and ArrayBag 3 as parameters :\n"+ArrayBag.union(arrBag1,arrBag3 )+"\n");
		
		arrBag1.removeAll("Bob");
		System.out.println("This is Array Bag 1 printed out after removing the all instances of the word Bob from it using the removeAll() method :\n"+arrBag1+"\n");
		
		// Array using the constructor with the int type parameter
		ArrayBag arrBag4 = new ArrayBag(2);
		String [] wordsForArrBag4 = {"Few","Words"};
		arrBag4.setData(wordsForArrBag4);
		System.out.println("A new ArrayBag, ArrayBag 4 was created, it takes an int type parameter and will be printed out below by using the getData() method");
		for(int i=0;i<arrBag4.getCapacity();i++)
		{
			System.out.print(arrBag4.getData()[i]+"\t");
		}
		System.out.println();
		
		arrBag4.setData(1,"RAAAWR");
		System.out.println("This is ArrayBag 4 after using the setData(int index,T element) and then print out that new word by using the getData(int index): "+arrBag4.getData(1));
	}

}
