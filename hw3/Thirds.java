import java.util.Scanner;

/**
 * 
 * @Thirds.java
 */

/**
 * @author Rahul Nuggehalli Gopinathan - rnn4511@cs.rit.edu
 * @author Sharath Navalpakkam Krishnan - sxn9447@cs.rit.edu
 * 
 */

public class Thirds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int dist1, dist2, dist3;
		int val1, val2, val3;
		int count1, count2, count3;
		boolean one, two, three;

		dist1 = dist2 = dist3 = 0;
		val1 = val2 = val3 = 0;
		count1 = count2 = count3 = 0;
		one = two = three = false;

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}

		/**
		 * Running Time: O(n)
		 */
		for (int i = 0; i < n; i++) {

			//1. Maintaining at-most three distinct keys.
			//2. When all distinct values are non-zero, we decrement the counters
			// on the next element read.
			//3.Before the next iteration, we eliminate zero-value elements
			if (!one) {
				dist1 = array[i];
				++val1;
				one = true;
			} else if (one && array[i] == dist1) {
				++val1;
			} else if (!two) {
				dist2 = array[i];
				++val2;
				two = true;
			} else if (two && array[i] == dist2) {
				++val2;
			} else if (!three) {
				dist3 = array[i];
				++val3;
				three = true;
			} else if (three && array[i] == dist3) {
				++val3;
			} else {
				--val1;
				--val2;
				--val3;
			}

			// Eliminating zero values
			if (val1 == 0) {
				one = false;
			}

			if (val2 == 0) {
				two = false;
			}

			if (val3 == 0) {
				three = false;
			}
		}

		/**
		 * Running Time: O(n)
		 */
		if (one || two || three) {
			for (int i = 0; i < n; i++) {
				if (one && array[i] == dist1) {
					++count1;
				} else if (two && array[i] == dist2) {
					++count2;
				} else if (three && array[i] == dist3) {
					++count3;
				}
			}
		}

		if ((count1 > (n / 3)) || (count2 > (n / 3)) || (count3 > (n / 3))) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		input.close();

	}

}
