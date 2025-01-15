/* Requirement:	
	(1) Complete the following codes, and auxiliary methods may be defined.
	(2) You are NOT allowed to modify the code originally given in Sorting2.java
	(3) You are NOT allowed to modify the filename of Sorting2.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
		
	*/

import java.util.*;

public class Sorting2 { /*Comparison of 2 sorting algorithms*/
	public static void insertionSort(int[] A) {
		int StartIndex = -1; //Indicate an index that not exist
		for (int i = 0; i < A.length; i++){
			if (A[i] > A[i + 1]){
				StartIndex = i + 1; //Indicate where the subarray that has not been sorted starts
				break;
			}
		}

		for (int i = StartIndex; i < (A.length); i++){
			int j = i;
			while(j > 0 && (A[j] < A[j-1])){ //Sort one by one
				int temp = A[j]; //Exchange the value
				A[j] = A[j-1];
				A[j-1] = temp;
				j--;
			}
		}
	}
	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] A, int left, int right) {

		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(A, left, center); //Sort the left side
			mergeSort(A, center + 1, right); //Sort the right side
			merge(A, left, center, right); //Merge the sorted sides
		}
	}
	
	private static void merge(int[] A, int left, int center, int right) {
		/*YOUR CODE HERE*/
		int leftLength = center - left + 1; //The length of the left subarray
		int rightLength = right - center; //The length of the right subarray
		int[] leftArray = new int[leftLength]; //Create a temporary array to store the left subarray
		int[] rightArray = new int[rightLength]; //Create a temporary array to store the right subarray
		for (int i = 0; i < leftLength; i++) //Fill the left subarray
			leftArray[i] = A[left + i];
		for (int j = 0; j < rightLength; j++) //Fill the right subarray
			rightArray[j] = A[center + 1 + j];

		int leftIndex = 0, rightIndex = 0;
		int mergedIndex = left; //Where the merging process begins
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				A[mergedIndex] = leftArray[leftIndex]; //Fill the smaller element into A
				leftIndex++; //Increment the index
			} else {
				A[mergedIndex] = rightArray[rightIndex]; //Fill the smaller element into A
				rightIndex++; //Increment the index
			}
			mergedIndex++; //Increment the index
		}

		while (leftIndex < leftLength) { //Copy the remaining element in the left subarray
			A[mergedIndex] = leftArray[leftIndex];
			leftIndex++;
			mergedIndex++;
		}
		while (rightIndex < rightLength) { //Copy the remaining element in the right subarray
			A[mergedIndex] = rightArray[rightIndex];
			rightIndex++;
			mergedIndex++;
		}
	}	
	
	public static void main(String[] args) {
		/*YOUR CODE HERE, 
		1. GeneratGenerate an array A1 consisting of 10^5 random integers which are in range [0, 999]
		2. Generate another array A2 which is identical to A1
		3. Sort A1 using insertionSort and A2 using mergeSort
		4. Print the elapsed time in milliseconds during which both search functions run, respectively*/

		Random rand = new Random();
		int size = 10000;
		int[] A1 = new int[size];
		for (int i = 0; i < size; i++) {
			A1[i] = rand.nextInt(1000);
		}

		int[] A2 = A1.clone();

		long startTime = System.currentTimeMillis();
		insertionSort(A1);
		long elapsedTimeInsertion = System.currentTimeMillis() - startTime;

		startTime = System.currentTimeMillis();
		mergeSort(A2);
		long elapsedTimeMerge = System.currentTimeMillis() - startTime;

		System.out.println("Elapsed time using Insertion Sort: " + elapsedTimeInsertion + " ms");
		System.out.println("Elapsed time using Merge Sort: " + elapsedTimeMerge + " ms");
	}

}
