package arrayVSLinked;

import java.util.Random;

public class LinkedListVsArrayDemo {

	public static void main(String[] args) {

		// construction of objects
		LinkedListDS linked = new LinkedListDS();
		ArrayDS array = new ArrayDS();
		Random rand = new Random();

		// populate array with random integers of length n
		int n = 10000;
		int[] randomInts = new int[n];
		for (int i = 0; i < randomInts.length; i++) {
			randomInts[i] = rand.nextInt();
		}

		// time length of addLast for n elements for a linked list
		long start = System.nanoTime();
		for (int i = 0; i < randomInts.length; i++) {
			linked.addLast(randomInts[i]);
		}
		long end = System.nanoTime();
		long linkedLastElapsed = end - start;

		// System.out.println("addLastLinkedComplete");

		// time length of addLast for n elements for an array
		start = System.nanoTime();
		for (int i = 0; i < randomInts.length; i++) {
			array.addLast(randomInts[i]);
		}
		end = System.nanoTime();
		long arrayLastElapsed = end - start;

		// System.out.println("addLastArrayComplete");

		// clear the array and list
		linked.clear();
		array.clear();

		// time length of addFirst for n elements for a linked list
		start = System.nanoTime();
		for (int i = 0; i < randomInts.length; i++) {
			linked.addFirst(randomInts[i]);
		}
		end = System.nanoTime();
		long linkedFirstElapsed = end - start;

		// System.out.println("addFirstLinkedComplete");

		// time length of addFirst for n elements for an array
		start = System.nanoTime();
		for (int i = 0; i < randomInts.length; i++) {
			array.addFirst(randomInts[i]);
		}
		end = System.nanoTime();
		long arrayFirstElapsed = end - start;

		// System.out.println("addFirstArrayComplete");

		// time for getNth for n elements for a linked list
		start = System.nanoTime();
		linked.getNth(n - 1);
		end = System.nanoTime();
		long linkedGetNthElapsed = end - start;

		// time for getNth for n elements for an array
		start = System.nanoTime();
		array.getNth(n - 1);
		end = System.nanoTime();
		long arrayGetNthElapsed = end - start;

		// print results
		System.out.printf("n:\t%d\n\n", n);
		System.out.printf("Array:\naddLast:\t%d micros\naddFirst:\t%d micros\ngetNth:\t\t%d micros\n\n",
				arrayLastElapsed / 1000, arrayFirstElapsed / 1000, arrayGetNthElapsed / 1000);
		System.out.printf("LinkedList:\naddLast:\t%d micros\naddFirst:\t%d micros\ngetNth:\t\t%d micros\n\n",
				linkedLastElapsed / 1000, linkedFirstElapsed / 1000, linkedGetNthElapsed / 1000);
		System.out.println(
				"Arrays:\t\taddLast and addFirst both have time complexity on the order of O(n^2) while getNth seems to have a time complexity on the order of O(logn)");
		System.out.println(
				"Linked Lists:\taddLast and addFirst both have a time complexity on the order of O(n^2) but appears to be on the order of O(n) for n ~< 1million and a time complexity that appears to be on the order of O(n) for getNth.");
	}
}
