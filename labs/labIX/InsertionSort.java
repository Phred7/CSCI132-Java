package labs.labIX;

public class InsertionSort {
	
	public InsertionSort() {
	}
	
	public InsertionSort(int capacity) {
	}
	
	public static int[] insertionSortAscending(int[] data) {
		int n = data.length;
		for(int k = 1; k < n; k++) {
			int cur = data[k];
			int j = k;
			while(j > 0 && data[j-1] > cur) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
		return data;
	}
	
	public static int[] insertionSortDescending(int[] data) {
		int n = data.length;
		for(int k = 1; k < n; k++) {
			int cur = data[k];
			int j = k;
			while(j > 0 && data[j-1] < cur) {
				data[j] = data[j-1];
				j--;
			}
			data[j] = cur;
		}
		return data;
	}

}
