import java.util.Scanner;

/**
 * 
 * @Triangle.java
 * @author Rahul Nuggehalli Gopinathan - rnn4511@cs.rit.edu
 */

/**
 * @author Rahul Nuggehalli Gopinathan - rnn4511@cs.rit.edu
 * @author Sharath Navalpakkam Krishnan - sxn9447@cs.rit.edu
 *
 */
public class Triangle {
	
	// The states
	double[][] matrix;
	int nValue;
	double[] xValues;
	double[] yValues;
	
	/**
	 * A recursive way of breaking down the problem to sub-triangles 
	 * 
	 * @param i - The start vertex
	 * @param j
	 * @return
	 */
	double triangle(int i, int j){
		
		// If the vertex is the same return 0
		if(i == j)
			return 0;
		
		// If the vertes has a value, return the value, no need to calculate again
		if(matrix[i][j] != -1)
			return matrix[i][j];
		
		double min = Double.POSITIVE_INFINITY;
		
		// Else break the problem down and calculate the min value for each type
		for(int k = i; k < j; k++){
			
			double x = triangle(i, k) + triangle((k+1), j);
			double dx = (xValues[i] - xValues[j]) * (xValues[i] - xValues[j]);
			double dy = (yValues[i] - yValues[j]) * (yValues[i] - yValues[j]);
			
			double dist = Math.sqrt(dx + dy);
			x = x + dist;
			if(x < min)
				min = x;
		}
		
		matrix[i][j] = min;
		
		// Return the min value
		return min;
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Triangle obj = new Triangle();
		
		obj.nValue = input.nextInt();
		
		obj.xValues = new double[obj.nValue];
		obj.yValues = new double[obj.nValue];
		
		for(int i = 0; i < obj.nValue; i++){
			obj.xValues[i] = input.nextDouble();
			obj.yValues[i] = input.nextDouble();
		}
		
		obj.matrix = new double[obj.nValue][obj.nValue];
		
		for(int i = 0; i < obj.nValue; i++){
			for(int j = 0; j < obj.nValue; j++)
				obj.matrix[i][j] = -1;
		}
		
		
		
		double minWeight = obj.triangle(0, obj.nValue-1);
		
		System.out.println(minWeight);

	}

}
