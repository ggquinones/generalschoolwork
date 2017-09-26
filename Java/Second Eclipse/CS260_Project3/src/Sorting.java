/*
 * This class contains all the sorting methods.
 */
public class Sorting {

	// Array based insertion sort
	public static void insertionSort(int[] data) {
		// temp swapping
		for (int i = 1; i < data.length; i++) {
			int k, temp = data[i];
			for (k = i - 1; k >= 0 && temp < data[k]; k--) {
				data[k + 1] = data[k];
			}
			data[k + 1] = temp;
		}
	}

	//Linked list based insertion sort
	public static Node insertionSort(Node node) {
		// returns null if node parameter is null
		if (node == null) {
			return null;
		}

		Node toSort = node;
		node = node.link;
		toSort.link = null;

		while (node != null) {
			// current node
			Node current = node;
			node = node.link;

			if (current.data < toSort.data) {
				current.link = toSort;
				toSort = current;
			} else {
				Node findPos = toSort;
				while (findPos.link != null && current.data > findPos.link.data) {
					findPos = findPos.link;
				}
				current.link = findPos.link;
				findPos.link = current;
			}
		}
		return toSort;
	}

	// Next two methods are the merge sort implementation for arrays
	public static void mergeSort(int[] nums) {
		// temp array for holding
		int[] temp = new int[nums.length];
		// sorting method
		mergeSort(nums, temp, 0, nums.length - 1);
	}

	private static void mergeSort(int[] data, int[] temp, int left, int right) {

		if (left < right) {
			int center = (left + right) / 2;
			// merges the left side
			mergeSort(data, temp, left, center);
			// meges the right side
			mergeSort(data, temp, center + 1, right);
			// merges the whole array
			merge(data, temp, left, center + 1, right);
		}

	}
   // private helper method merge used at the end of a merge sort
	private static void merge(int[] data, int[] temp, int left, int right,
			int rightEnd) {

		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (data[left] >= data[right]) {
				temp[k++] = data[right++];
			} else {
				temp[k++] = data[left++];
			}
		}

		while (left <= leftEnd) {
			temp[k++] = data[left++];
		}
		while (right <= rightEnd) {
			temp[k++] = data[right++];
		}
		for (int i = 0; i < num; i++, rightEnd--) {
			data[rightEnd] = temp[rightEnd];
		}

	}

	// Linked list based merge sort
	public static Node mergeSort(Node head) {
		if (head == null || head.link == null) {
			return head;
		}
		Node middle = getMiddle(head);
		Node sHalf = middle.link;
		middle.link = null;
		return merge(mergeSort(head), mergeSort(sHalf));
	}
	
	// private helper method merge used at the end of a merge sort
	private static Node merge(Node node1, Node node2) {
		Node dummyHead, current;
		dummyHead = new Node();
		current = dummyHead;
		while (node1 != null && node2 != null) {
			if (node1.data <= node2.data) {
				current.link = node1;
				node1 = node1.link;
			} else {
				current.link = node2;
				node2 = node2.link;
			}
			current = current.link;
		}
		if (node1 == null) {
			current.link = node2;
		} else {
			current.link = node1;
		}
		return dummyHead.link;
	}

	// helper method for insertion sort
	private static Node getMiddle(Node head) {
		// when head is null finished
		if (head == null) {
			return head;
		}
		// first and last place in the list
		Node first, last;
		first = last = head;
		while (last.link != null && last.link.link != null) {
			first = first.link;
			last = last.link.link;
		}
		return first;
	}

	private static int num;

	// heap sort
	public static void heapSort(int[] data) {
		heapify(data);
		for (int i = num; i > 0; i--) {
			swap(data, 0, i);
			num = num - 1;
			maxheap(data, 0);
		}
	}

	// helper method to "heapify"
	private static void heapify(int arr[]) {
		num = arr.length - 1;
		for (int i = num / 2; i >= 0; i--)
			maxheap(arr, i);
	}

	// helper max heap method
	private static void maxheap(int arr[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= num && arr[left] > arr[i]) {
			max = left;
		}
		if (right <= num && arr[right] > arr[max]) {
			max = right;
		}
		if (max != i) {
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}

	// helper swap method for code clarity
	private static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}