import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @Isort.java
 * @author Rahul Nuggehalli Gopinathan - rnn4511@cs.rit.edu
 * @author Sharath Navalpakkam Krishnan - sxn9447@cs.rit.edu
 * 
 */

public class Isort {

	Scanner inputScanner;

	/**
	 * Insertion sort
	 * 
	 * @param array
	 *            - array
	 */
	void insertionSort(int[] array) {

		// Basically, same as quick sort with all pivot being the leftmost index
		// always
		for (int i = 1; i < array.length; i++) {
			int insertValue = array[i];
			int index = i;

			while (index > 0 && insertValue < array[index - 1]) {
				array[index] = array[index - 1];
				--index;
			}

			array[index] = insertValue;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Isort obj = new Isort();
		int size;
		obj.inputScanner = new Scanner(System.in);
		size = obj.inputScanner.nextInt();
		int array[] = new int[size];

		// get input
		for (int i = 0; i < size; i++) {
			array[i] = obj.inputScanner.nextInt();
		}

		// double start = System.nanoTime();
		obj.insertionSort(array);
		// double stop = System.nanoTime();

		for (int i : array) {
			System.out.println(i);
		}

		// System.out.println("Insertion Sort Time (msec): " + (stop - start) /
		// 1000000);
	}
}
