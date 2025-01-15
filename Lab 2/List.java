/* Requirement:
	(1) UML of List:
		|-----------------------------------------------|
		|					 List                       |
		|-----------------------------------------------|
		|   - head: Node                                |
		|-----------------------------------------------|
		|   + List()                                    |
		|   + isEmpty(): boolean                        |
		|   + insertNode(int index, double x): Node     |
		|   + findNode(double x): Node                  |
		|   + removeNode(double x): Node                |
		|   + displayList(): void                       |
		|-----------------------------------------------|
	
	(2) You are NOT allowed to modify the code originally given in List.java, Node.java
	(3) You are NOT allowed to modify the filename of List.java, Node.java
	(4) You are NOT allowed to use Chinese characters in codes or comments
	(5)	You should add some comments and indentations to make the codes user friendly
	(6) Following is sample output after running main() in List.java:
	
		true
		Data of head: 1.0
		1.0
		1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		3.0 -> 1.0 -> 2.0
		2.0
		3.0 -> 2.0
		3.0 -> 2.0
		
	*/
public class List {
	private Node head;

	public List(){
		this.head = null;
	}

	public boolean isEmpty(){
		return this.head == null; //Check if the list is empty
	}

	public Node insertNode(int index, double x) {
		if(index < 0)
			return null;
		int currIndex = 1;
		Node currNode = this.head;
		while(currNode != null && index > currIndex) {
			currNode = currNode.getNext();
			currIndex ++;
		}
		if(index > 0 && currNode == null)
			return null;

		Node newNode = new Node(x);
		if(index == 0) {
			newNode.setNext(this.head);
			this.head = newNode;
		}
		else {
			newNode.setNext(currNode.getNext());
			currNode.setNext(newNode);
		}
		return newNode;
	}



	public Node findNode(double x){
		Node currNode = this.head; //Initialize the index

		while(currNode != null) {
			if (currNode.getData() == x) {
				return currNode;
			}
				currNode = currNode.getNext(); //If not found then move to the next node
		}

		return null; //Node not found
	}

	public Node removeNode(double x){
		Node currNode = this.head; //Initialize the index

		if (currNode == null) {
			return null; //Nothing to remove because it's already empty
		}

		else if (currNode.getData() == x){ //Check the head
			Node removedNode = currNode; //Store the removed node for returning
			head = head.getNext(); //Adjust the head to the next node
			return removedNode;
		}

		while(currNode.getNext() != null){
			if(currNode.getNext().getData() == x){
				Node removedNode = currNode.getNext(); //Store the removed node for returning
				currNode.setNext(removedNode.getNext()); //Adjust the pointer to the next node of the removed node
				return removedNode;
			}
			currNode = currNode.getNext(); //Adjust the pointer to the next node
		}

		return null; //Node not found
	}

	public void displayList(){
		Node currNode = this.head; //Initialize the index

		if (currNode == null) { //The head is null
			System.out.println("List is empty");
			return;
		}

		else{
			while (currNode != null) {
				System.out.print(currNode.getData());

				if (currNode.getNext() != null) {
					System.out.print(" -> "); //Add -> between two nodes
				}

				currNode = currNode.getNext(); //Adjust the pointer to the next node
			}
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		List myList  = new List();
		System.out.println(myList.isEmpty());
		myList.insertNode(0, 1);
		System.out.println("Data of head: " + myList.head.getData());
		myList.displayList();
		myList.insertNode(1, 2);
		myList.displayList();
		myList.insertNode(0, 3);
		myList.displayList();
		myList.insertNode(4, 4);
		myList.displayList();
		myList.insertNode(-4, 5);
		myList.displayList();
		System.out.println(myList.findNode(2).getData());
		myList.removeNode(1);
		myList.displayList();
		myList.removeNode(4);
		myList.displayList();
	}

}
