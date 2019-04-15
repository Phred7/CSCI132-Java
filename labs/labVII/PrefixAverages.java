package labs.labVII;

import java.util.Random;

public class PrefixAverages {

	/** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
	public static double[] prefixAverage1 (double[] x) {
		int n = x.length;
		double[] a = new double[n];
		for (int j = 0; j < n; j++) {
			double total = 0;
			for (int i = 0; i <= j; i++)
				total += x[i];
			a[j] = total / (j + 1);

		}
		return a;
	}
	
	/** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
	public static double[] prefixAverage2(double[] x) {
		int n = x.length;
		double[] a = new double[n];
		double total = 0;
		for (int j = 0; j < n; j++) {
			total += x[j];
			a[j] = total / (j + 1);
		}
		return a;
	}
	
	public static double[] fillArray(double[] array) {
		Random rand = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = (double)rand.nextInt(100);
		}
		return array;
	}

	public static void main(String[] args) {
		int n = 10;
		double[] alg1_1 = new double[n];
		fillArray(alg1_1);
		long start = System.nanoTime();
		prefixAverage1(alg1_1);
		long end = System.nanoTime();
		long elapsed = end - start;
		System.out.printf("n = %d     alg1 time: %d.\n", n, elapsed);
		
		n = 100;
		double[] alg1_2 = new double[n];
		fillArray(alg1_2);
		start = System.nanoTime();
		prefixAverage1(alg1_2);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg1 time: %d.\n", n, elapsed);
		
		n = 1000;
		double[] alg1_3 = new double[n];
		fillArray(alg1_3);
		start = System.nanoTime();
		prefixAverage1(alg1_3);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg1 time: %d.\n", n, elapsed);

		n = 10000;
		double[] alg1_4 = new double[n];
		fillArray(alg1_4);
		start = System.nanoTime();
		prefixAverage1(alg1_4);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg1 time: %d.\n", n, elapsed);
		
		n = 100000;
		double[] alg1_5 = new double[n];
		fillArray(alg1_5);
		start = System.nanoTime();
		prefixAverage1(alg1_5);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg1 time: %d.\n\n", n, elapsed);
		
//		n = 50000;
//		double[] alg1_6 = new double[n];
//		fillArray(alg1_6);
//		start = System.nanoTime();
//		prefixAverage1(alg1_6);
//		end = System.nanoTime();
//		elapsed = end - start;
//		System.out.printf("n = %d     alg1 time: %d.\n\n", n, elapsed);
//		
//		n = 200000;
//		double[] alg1_7 = new double[n];
//		fillArray(alg1_7);
//		start = System.nanoTime();
//		prefixAverage1(alg1_7);
//		end = System.nanoTime();
//		elapsed = end - start;
//		System.out.printf("n = %d     alg1 time: %d.\n\n", n, elapsed);
		
		//START ALG2
		n = 10;
		double[] alg2_1 = new double[n];
		fillArray(alg2_1);
		start = System.nanoTime();
		prefixAverage2(alg2_1);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg2 time: %d.\n", n, elapsed);
		
		n = 100;
		double[] alg2_2 = new double[n];
		fillArray(alg2_2);
		start = System.nanoTime();
		prefixAverage2(alg2_2);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg2 time: %d.\n", n, elapsed);
		
		n = 1000;
		double[] alg2_3 = new double[n];
		fillArray(alg2_3);
		start = System.nanoTime();
		prefixAverage2(alg2_3);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg2 time: %d.\n", n, elapsed);

		n = 10000;
		double[] alg2_4 = new double[n];
		fillArray(alg2_4);
		start = System.nanoTime();
		prefixAverage2(alg2_4);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg2 time: %d.\n", n, elapsed);
		
		n = 100000;
		double[] alg2_5 = new double[n];
		fillArray(alg2_5);
		start = System.nanoTime();
		prefixAverage2(alg2_5);
		end = System.nanoTime();
		elapsed = end - start;
		System.out.printf("n = %d     alg2 time: %d.\n\n", n, elapsed);
		
		System.out.println("These results indicate the growth function of first algorithm is Quadradic, and second algorithm is Linear.");

	}

}
