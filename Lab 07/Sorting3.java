/* Requirement:	
	(1) Complete the following codes, and auxiliary methods may be defined.
	(2) You are NOT allowed to modify the code originally given in Sorting3.java
	(3) You are NOT allowed to modify the filename of Sorting3.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
		
	*/
import java.util.*;

public class Sorting3 { /*Comparison of 3 sorting algorithms*/
	public static void insertionSort(int[] A) {
		insertionSort(A, 0, A.length - 1);
	}
	
	private static void insertionSort(int[] A, int left, int right) {
		// This insertionSort is called by quickSort when the sub-array size is small
		for(int p=left + 1; p<=right; p++) {
			int key = A[p];
			int i = p-1;
			while(i>=0 && A[i]>key) {
				A[i+1] = A[i];
				i--;
			}
			A[i+1] = key;
		}
	}
	
	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int left, int right) {
		if(left >= right)
			return;
		int center = (left + right) / 2;
		mergeSort(A, left, center);
		mergeSort(A, center + 1, right);
		merge(A, left, center, right);
	}
	
	private static void merge(int[] A, int left, int center, int right) {
		int i1 = left, i2 = center + 1, i = 0;
		int B[] = new int[right - left + 1];
		while(i1<=center && i2 <= right)
			if(A[i1] < A[i2])
				B[i++] = A[i1++];
			else
				B[i++] = A[i2++];
		while(i1<=center)
			B[i++] = A[i1++];
		while(i2<=right)
			B[i++] = A[i2++];
		for(i=0; i<B.length; i++)
			A[left + i] = B[i];
	}	
	
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}	

	private static void quickSort(int[] A, int left, int right) {
		if (left + 10 <= right) { // Switch to insertionSort if the sub-array size is <= 10
			median3(A, left, right);
			int pivot = partition(A, left, right);
			quickSort(A, left, pivot - 1);
			quickSort(A, pivot + 1, right);
		} else {
			insertionSort(A, left, right);
		}
	}

	private static int partition(int[] A, int left, int right) {
		int pivot = A[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (A[j] <= pivot) {
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, right);
		return i + 1;
	}

	private static void median3(int[] A, int left, int right) {
		int center = (left + right) / 2;
		if (A[left] > A[center])
			swap(A, left, center);
		if (A[left] > A[right])
			swap(A, left, right);
		if (A[center] > A[right])
			swap(A, center, right);
		swap(A, center, right - 1); // Place pivot at position right - 1
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		// Generate an array A1 consisting of 10^5 random integers in range [0, 999]
		int size = 100000;
		int[] A1 = new int[size];
		Random rand = new Random();
		for (int i = 0; i < size; i++) {
			A1[i] = rand.nextInt(1000);
		}

		// Generate arrays A2, A3 which are identical to A1
		int[] A2 = Arrays.copyOf(A1, A1.length);
		int[] A3 = Arrays.copyOf(A1, A1.length);

		// Sort A1 using insertionSort and record the elapsed time
		long startTime = System.currentTimeMillis();
		insertionSort(A1);
		long endTime = System.currentTimeMillis();
		System.out.println("============ ELAPSED TIME ============");
		System.out.println("InsertionSort: " + (endTime - startTime) + " ms");

		// Sort A2 using mergeSort and record the elapsed time
		startTime = System.currentTimeMillis();
		mergeSort(A2);
		endTime = System.currentTimeMillis();
		System.out.println("MergeSort: " + (endTime - startTime) + " ms");

		// Sort A3 using quickSort and record the elapsed time
		startTime = System.currentTimeMillis();
		quickSort(A3);
		endTime = System.currentTimeMillis();
		System.out.println("QuickSort: " + (endTime - startTime) + " ms");
	}

}
