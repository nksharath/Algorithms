import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @Qsort.java
 * @author Rahul Nuggehalli Gopinathan - rnn4511@cs.rit.edu
 * @author Sharath Navalpakkam Krishnan - sxn9447@cs.rit.edu
 */

public class Qsort {

	// input scanner and element array
	Random rr = new Random(System.currentTimeMillis());
	Scanner inputScanner;
	int elementArray[];

	/**
	 * The partition maker
	 * 
	 * @param elementArray - The element array
	 * @param left - The index of the leftmost element
	 * @param right - The index of the rightmost element
	 * @param pivot - The index of the pivot
	 * @return int - The index of the pivot element after sorting
	 */
	int partitionMaker(int[] elementArray, int left, int right, int pivot) {

		// The pivot element
		int pivotElement = elementArray[pivot];

		//Moving the pivot to the end
		elementArray[pivot] = elementArray[right];
		elementArray[right] = pivotElement;

		// starting from the leftmost element
		int returnIndex = left;

		//left to right
		for (int i = left; i < right; i++) {
			
			//If less than pivot element, swap with 'returnIndex' position
			if (elementArray[i] < pivotElement) {
				int temp = elementArray[i];
				elementArray[i] = elementArray[returnIndex];
				elementArray[returnIndex] = temp;
				++returnIndex;
			}
		}

		// Place the pivot in the right position
		int temp = elementArray[returnIndex];
		elementArray[returnIndex] = elementArray[right];
		elementArray[right] = temp;

		//Return the new pivot index
		return returnIndex;

	}

	/**
	 * The quick sort function
	 * 
	 * @param array - array
	 * @param left - leftmost position
	 * @param right - right most position
	 */
	void quickSort(int[] array, int left, int right) {

		if (left < right) {
			//Random pivot
			int pivot = rr.nextInt(right - left) + left;
			int newPivot = partitionMaker(array, left, right, pivot);
			quickSort(array, left, newPivot - 1);
			quickSort(array, newPivot + 1, right);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Qsort obj = new Qsort();
		int size;
		obj.inputScanner = new Scanner(System.in);
		size = obj.inputScanner.nextInt();
		obj.elementArray = new int[size];
		int arrayQ[] = new int[size];
		
		// get input
		for (int i = 0; i < size; i++) {
			obj.elementArray[i] = arrayQ[i] = obj.inputScanner.nextInt();
		}

//		double start = System.nanoTime();
		obj.quickSort(arrayQ, 0, arrayQ.length - 1);
//		double stop = System.nanoTime();
		
		for (int i : arrayQ) {
			System.out.println(i);
		}

//		System.out.println("QSort Time (msec): " + (stop - start) / 1000000);
	}
}
