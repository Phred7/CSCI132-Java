package weekII;

import java.util.Scanner;

public class ForLoopsandArrays {
	
	public static void main(String[] args) {
		
		String[] groceryList= {"apples", "string cheese", "ramen"};
		
		//System.out.println(groceryList[0]);
		
		for(int i = 0; i < groceryList.length; i++) {
			if(i == groceryList.length - 1) {
				System.out.println(groceryList[i]);
			}else {
				System.out.print(groceryList[i] + ", ");
			}
		}
		
		/*double[][] matrix = new double[6][4]; //2D array
		
		for(int j = 1; j < 6; j++) {
			System.out.println();
			for(int k = 1; k < 4; k++) {
				matrix[j][k] = j * k;
				System.out.println(matrix[j][k] + "\t");
			}
		}*/
		
		//int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number to multiplie to: ");
		int maxFactor = input.nextInt();
		
		int[] ints = new int[maxFactor];
		
		for(int kk = 0; kk < maxFactor; kk++) {
			ints[kk] = kk + 1;
		}
		
		for(int ii = 0; ii < ints.length; ii++) {
			for(int jj = 0; jj < ints.length; jj++) {
				System.out.print(ints[ii] * ints[jj] + "\t");
			}
			System.out.println();
		}
		
		input.close();
	}

}
