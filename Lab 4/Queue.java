/* Requirement:
	(1) UML of Queue:
		|-----------------------------------------------|
		|                    Queue                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - front: int                                |
		|   - rear: int                                 |
		|   - counter: int                              |
		|-----------------------------------------------|
		|   + Queue(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + enqueue(double x): Double                 |
		|   + dequeue(): Double                         |
		|   + displayQueue(): void                      |
		|-----------------------------------------------|

	(2) You are NOT allowed to modify the code originally given in Queue.java
	(3) You are NOT allowed to modify the filename of Queue.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Queue.java:

		true
		The queue has 3 items: -2, 3, 1
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|<-rear
		The queue has 4 items: -2, 3, 1, 8
		true
		front->	|	 -2.0000	|
			    |	  3.0000	|
			    |	  1.0000	|
			    |	  8.0000	|<-rear
		The queue has 2 items: 1, 8
		front->	|	  1.0000	|
			    |	  8.0000	|<-rear
		The queue is empty:
		Empty queue!

	*/
public class Queue {
	private Double[] values;
	private int front;
	private int rear;
	private int counter;

	public Queue(int size) {
		values = new Double[size];
		front = 0;
		rear = -1;
		counter = 0;
	}

	public boolean isEmpty(){
		return counter == 0; //Check if the queue is empty
	}

	public boolean isFull(){
		return counter == values.length; //Check if the queue is full
	}

	public Double enqueue(double x) {
		if(isFull())
			return null;
		rear = (rear + 1) % values.length;
		values[rear] = Double.valueOf(x);
		counter ++;
		return values[rear];
	}

	public Double dequeue() {
		if (isEmpty()){
			return null; //The queue is empty so there is no need to dequeue
		}
		else{
			Double item = values[front]; //Get the front element
			front = (front + 1) % values.length; //Move front
			counter --;
			return item;
		}
	}

	public void displayQueue() {
		if (isEmpty()) {
			System.out.println("Empty queue!"); //The queue is empty
			return;
		}

		System.out.print("front->");
		for (int i = 0; i < counter; i++) {
			if (i == 0) {
				if (values[(front + i) % values.length] < 0) {
					System.out.printf(" |    %.4f    |", values[(front + i) % values.length]); //Add 4 blanks in front of the number to align as - will take one
				}
				else{
					System.out.printf(" |     %.4f    |", values[(front + i) % values.length]); //Add 5 blanks in front of the number to align
				}
			}
			else {
				if (values[(front + i) % values.length] < 0) {
					System.out.printf("\n        |    %.4f    |", values[(front + i) % values.length]); //Add 4 blanks in front of the number to align as - will take one
				}
				else{
					System.out.printf("\n        |     %.4f    |", values[(front + i) % values.length]); //Add 5 blanks in front of the number to align
				}
			}
		}
		System.out.print("<-rear");
		System.out.println();
	}

	public static void main(String[] args) {
		Queue myQueue = new Queue(4);
		System.out.println(myQueue.isEmpty());
		myQueue.enqueue(-2);
		myQueue.enqueue(3);
		myQueue.enqueue(1);
		System.out.println("The queue has 3 items: -2, 3, 1");
		myQueue.displayQueue();
		myQueue.enqueue(8);
		myQueue.enqueue(6);
		System.out.println("The queue has 4 items: -2, 3, 1, 8");
		System.out.println(myQueue.isFull());
		myQueue.displayQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue has 2 items: 1, 8");
		myQueue.displayQueue();
		myQueue.dequeue();
		myQueue.dequeue();
		myQueue.dequeue();
		System.out.println("The queue is empty:");
		myQueue.displayQueue();

	}
}
