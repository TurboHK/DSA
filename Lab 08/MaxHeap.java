/* Requirement:
	(1) UML of MaxHeap:
		|-----------------------------------------------|
		|                    MaxHeap                    |
		|-----------------------------------------------|
		|   - A: int[]                                  |
		|   - size: int                                 |
		|-----------------------------------------------|
		|   + MaxHeap(int A[])                          |
		|   + insert(int x): boolean                    |
		|   + deleteMax(): int                          |
		|   + heapSort(int A[]): static void            |
		|   + main(): static void                       |
		|-----------------------------------------------|
	* Note: Underline is always used to show methods or variables which are static in UML. But the
	underline cannot be typed out in code editor, so we use another way to tell you about that.

	(2) You are NOT allowed to modify the code originally given in MaxHeap.java
	(3) You are NOT allowed to modify the filename of MaxHeap.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5) The class name, variable names and method names should STRICTLY follow the UML above
	(6)	You should add some comments and indentations to make the codes user friendly

	*/
import java.util.*;

public class MaxHeap {
	int[] A;
	int size;
	
	public MaxHeap(int[] A) {
		this.A = A;
		this.size = A.length; //The size of A
	}
	
	public boolean insert(int x) {
		if (size == A.length){
			return false; //The heap is full
		}
		else{
			A[size] = x;
			size++;
			int insertedIndex = size -1; //The index of the inserted element
			while((A[insertedIndex] > A[((insertedIndex - 1)/2)]) && (insertedIndex != 0)){ //(insertedIndex - 1)/2) is the index of the parent element of the inserted element
				//Swap and update the index
				int temp = A[insertedIndex];
				A[insertedIndex] = A[((insertedIndex - 1)/2)];
				A[((insertedIndex - 1)/2)] = temp;
				insertedIndex = (insertedIndex - 1)/2;
			}
			return true;
		}
	}
	
	public int deleteMax() {
		if (size <= 0) {
			return -1; //The heap is empty
		}
		else if (size == 1) {
			size--;
			return A[0]; //The only element
		}

		int max = A[0];
		A[0] = A[size - 1]; //Move the last element to the top
		size--;
		heapSort(A);
		return max;
	}
	
	public static void heapSort(int A[]) {
		MaxHeap maxHeap = new MaxHeap(A);
		for (int i = maxHeap.size - 1; i > 0; i--) {
			//Exchange the last and the top elements
			int temp1 = A[0];
			A[0] = A[i];
			A[i] = temp1;
			maxHeap.size--; //Reduce the size
			int j = 0;
			while (true) {
				int largest = j; //Assume the current element is the largest
				int left = 2 * j + 1; //Left child index
				int right = 2 * j + 2; //Right child index

				if (left < maxHeap.size && maxHeap.A[left] > maxHeap.A[largest]) {
					largest = left;
				}

				else if (right < maxHeap.size && maxHeap.A[right] > maxHeap.A[largest]) {
					largest = right;
				}

				//If the current element is not the largest one then continues adjusting
				if (largest != j) {
					int temp2 = A[j];
					A[j] = A[largest];
					A[largest] = temp2;
					j = largest;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*YOUR CODE HERE, 
		- Generate an array A consisting of 10^5 random integers which are in range [0, 999]
		- Sort A using heapSort
		- Print the elapsed time in milliseconds during which the sort function runs
.*/
		Random rand = new Random();
		int[] A = new int[100000];
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(1000);
		}

		long startTime = System.currentTimeMillis();
		heapSort(A);
		long endTime = System.currentTimeMillis();

		System.out.println("Sorting completed in " + (endTime - startTime) + " milliseconds.");
	}

}
