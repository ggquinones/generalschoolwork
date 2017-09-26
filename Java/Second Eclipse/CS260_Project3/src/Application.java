/**
Gabriel Quinones-Sanchez
Project 3
Sorts of all sorts (HAAAAAAAAAAAAAAAAA! :D )
*/

// This is where the main method is. Read comments to figure out how to work it.
public class Application {
	private static int[] data;
	private static Node head;
	private static final int TOP = 12000000;

	public static void main(String[] args) {
		
		// Here change this variable to change the input size!
		int  size = 100000;
		randomData(size);
		// UNCOMMENT SORT YOU WANT TO RUN IT< DONT FORGET TO CHANGE INPUT SIZE ABOVE
		
		//INSERTION SORT 
		/*
		long start = System.currentTimeMillis();
		System.out.println("=========insertionSort with array=========");
		System.out.println("Before array Sort: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		Sorting.insertionSort(data);
		System.out.println("\nFirst 50 elements after array Sort: ");
		displayArray(1);
		long time = System.currentTimeMillis() - start;
		System.out.println("The time it took to perform this operation was: "
				+ time + " milliseconds.");
		*/
		
		//INSERTION SORT WITH NODE
		/*
		long start = System.currentTimeMillis();
		System.out.println("\n=========insertionSort with Node=========");
		System.out.println("Before: " + head.toString());
		Sorting.insertionSort(head);
		displayList(2);
		long time = System.currentTimeMillis() - start;
		System.out.println("The time it took to perform this operation was: "
				+ time + " milliseconds.");
		*/
		
		// MERGE SORT WITH ARRAY
		/*
		long start = System.currentTimeMillis();
		System.out.println("\n=========mergeSort with array=========");
		System.out.println("Before array Sort: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		Sorting.mergeSort(data);
		System.out.println("\nFirst 50 elements after array Sort: ");
		displayArray(3);
		long time = System.currentTimeMillis() - start;
		System.out.println("The time it took to perform this operation was: "
				+ time + " milliseconds.");
		*/
		
		// MERGE SORT WITH NODE
		/*
		long start = System.currentTimeMillis();
		System.out.println("\n=========mergeSort with Node=========");
		System.out.println("Before: " + head.toString());
		Sorting.mergeSort(head);
		displayList(4);
		long time = System.currentTimeMillis() - start;
		System.out.println("The time it took to perform this operation was: "
				+ time + " milliseconds.");
		*/
		
		// HEAP SORT
		/*
		long start = System.currentTimeMillis();
		System.out.println("\n=========heapSort with array=========");
		System.out.println("Before array Sort: ");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		Sorting.heapSort(data);
		System.out.println("\nAfter array Sort; first 50 elements: ");
		displayArray(5);
		long time = System.currentTimeMillis() - start;
		System.out.println("The time it took to perform this operation was: "
				+ time + " milliseconds.");
		*/
		
	}

	
	public static void randomData(int lengthData) {

		data = new int[lengthData];
		head = new Node(data[0], null);

		for (int i = 0; i < lengthData; i++) {
			int randomNum = (int) (Math.random() * TOP);
			data[i] = randomNum;
			head.addNodeAfter(data[i]);
		} 
	}

	public static void displayArray(int type) {
		switch (type) {
		case 1:
			for (int i = 0; i < 50; i++) {
				try {
					System.out.print(data[i] + ", ");
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
					System.out.println("");
				}
			}
			break;
		case 3:
			for (int i = 0; i < 50; i++) {
				try {
					System.out.print(data[i] + ", ");
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
					System.out.println("");
				}
			}
			break;
		case 5:
			for (int i = 0; i < 50; i++) {
				try {
					System.out.print(data[i] + ", ");
				} catch (ArrayIndexOutOfBoundsException e) {
				}
				if (i == 9 || i == 19 || i == 29 || i == 39 || i == 49) {
					System.out.println("");
				}
			}
			break;
		default:
			throw new IllegalArgumentException("Errors happened, peace out yo!");
		}
	}

	public static void displayList(int type) {
		switch (type) {
		case 2:
			System.out.println("After, only first 50: " + head.toString(50));
			break;
		case 4:
			System.out.println("After, only first 50: " + head.toString(50));
			break;
		}
	}

	

	
}