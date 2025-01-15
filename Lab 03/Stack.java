/* Requirement:
	(1) UML of Stack:
		|-----------------------------------------------|
		|                    Stack                      |
		|-----------------------------------------------|
		|   - values: Double[]                          |
		|   - top: int                                  |
		|-----------------------------------------------|
		|   + Stack(int size)                           |
		|   + isEmpty(): boolean                        |
		|   + isFull(): boolean                         |
		|   + top(): Double                             |
		|   + push(double x): Double                    |
		|   + pop(): Double                             |
		|   + displayStack(): void                      |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in Stack.java
	(3) You are NOT allowed to modify the filename of Stack.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in Stack.java:
	
		true
		The stack has 2 items:
		top -->	|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The stack has 4 items:
		top -->	|	  2.0000	|
				|	  1.0000	|
				|	  5.0000	|
				|	 -3.0000	|
				+---------------+
		The top is: 2.0
		true
		The stack is empty:
		top -->	+---------------+
		
	*/
public class Stack {
	/*YOUR CODE HERE*/
	private Double[] values;
	private int top;

	public Stack(int size){
		values = new Double[size]; //Store stack elements
		top = -1; //The stack is empty
	}
	
	public boolean isEmpty(){
		return top == -1; // If the top index is -1 then the stack is empty
	}
	
	public boolean isFull(){
		return top == values.length - 1; //If the top index = array length - 1 then the stack is full
	}

	public Double top(){
		if (isEmpty()){
			return null; //The stack is empty
		}
		else{
			return values[top]; //Return the top element
		}
	}

	public Double push(double x) {
		if(isFull())
			return null;
		values[++top] = Double.valueOf(x);
		return top();
	}

	public Double pop(){
		if (isEmpty()){
			return null; //The stack is empty
		}
		else{
			return values[top--]; // Return the top element and decrement the top index
		}
	}

	public void displayStack(){
		System.out.print("top -->");

		if (isEmpty()){
			System.out.println("\t\t+---------------+"); //The stack is empty so directly print the end
		}

		else{
			if (values[top] < 0) {
				System.out.println(String.format("\t|\t %.4f\t|", values[top])); //Add only one space after \t as a negative number begins with a -
				//format() can display four decimal places by using %.4f
			}
			else{
				//System.out.println("\t\t|\t  " + values[i] + "\t|");
				System.out.println(String.format("\t|\t  %.4f\t|", values[top])); //Add 2 spaces after \t to align
			}

			if ((top - 1) >= 0){ //Check if the index exists
				for (int i = top - 1; i >= 0; i--){
					if (values[i] < 0) {
						System.out.println(String.format("\t\t|\t %.4f\t|", values[i])); //Add only one space after \t as a negative number begins with a -
					}
					else{
						//System.out.println("\t\t|\t  " + values[i] + "\t|");
						System.out.println(String.format("\t\t|\t  %.4f\t|", values[i])); //Add 2 spaces after \t to align
					}
				}
			}


			System.out.println("\t\t+---------------+");
		}
	}

	public static void main(String[] args) {
		Stack myStack = new Stack(4);
		System.out.println(myStack.isEmpty());
		myStack.push(-3);
		myStack.push(5);
		System.out.println("The stack has 2 items:");
		myStack.displayStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(-1);
		System.out.println("The stack has 4 items:");
		myStack.displayStack();
		System.out.println("The top is: " + myStack.top());
		System.out.println(myStack.isFull());
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		System.out.println("The stack is empty:");
		myStack.displayStack();
	}
	
}
