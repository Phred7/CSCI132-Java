package labs;

import java.util.Arrays;
import java.util.Random;

public class Recursion {
	
	static int n = 3000;
	static int target = 2906;
	static int checks = 0;
	static int[] array = new int[n];
	
	static Random rand = new Random();

	public static void main(String[] args) {
		
		for(int i = 0; i < n; i++) {
			array[i] = rand.nextInt(n);
		}
		
		Arrays.sort(array);
		//System.out.println(Arrays.toString(array));
		System.out.printf("Binary Search\nTarget %d found at index %d for size %d\n%d searches required\n\n", target, binarySearch(array, target, array[n-1], array[0]), n, checks);
		checks = 0;
		System.out.printf("Linear Search\nTarget %d found at index %d for size %d\n%d searches required",target, linearSearch(array, target, n-1), n, checks);

	}
	
	public static int binarySearch(int[] data, int target, int high, int low) {
		checks += 1;
		if(low > high) {
			//System.out.println("low>high");
			return -1;
		}else {
			int mid = (high + low)/2;
			if(target == data[mid]) {
				//System.out.println("target==mid");
				return mid;
			}else if(target < data[mid]) {
				//System.out.println("target<mid");
				return binarySearch(data, target, mid - 1, low);
			}else {
				//System.out.println("target>mid");
				return binarySearch(data, target, high, mid + 1);
			}
		}
	}
	
	public static int linearSearch(int[] data, int target, int size) { //isn't size kind of redundant since data holds the size?
		checks += 1;
		if(data[size] == target) {
			return size;
		}else if(size - 1 == -1){
			return -1;
		}else {
			return linearSearch(data, target, size - 1);
		}
	}

}
