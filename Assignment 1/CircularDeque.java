import java.util.Deque;
import java.util.LinkedList;

public class CircularDeque {
    private Deque<Integer> deque; //Initializes the deque with a maximum size of size
    private int capacity;  //Initializes the capacity of th deque

    public CircularDeque(int size) {
        this.capacity = size;
        this.deque = new LinkedList<>();
    }

    public Integer insertFront(int value) {
        if (isFull()) {
            return null; //The deque is full so no value can be added
        }
        else{
            deque.addFirst(value); //Add the value to the front
            return value;
        }
    }

    public Integer insertLast(int value) {
        if (isFull()) {
            return null; //The deque is full so no value can be added
        }
        else{
            deque.addLast(value); //Add the value to the last
            return value;
        }
    }

    public Integer deleteFront() {
        if (isEmpty()) {
            return null; //The deque is empty so no value can be deleted
        }
        else{
            return deque.removeFirst();
        }
    }

    public Integer deleteLast() {
        if (isEmpty()) {
            return null; //The deque is empty so no value can be deleted
        }
        else{
            return deque.removeLast();
        }
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == capacity;
    }

    public void displayCircularDeque() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
        } else {
            System.out.println(deque);
        }
    }

    public static void main(String[] args) {
        CircularDeque deque = new CircularDeque(5);
        System.out.println("Expected output: Deque is empty");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.insertLast(114);
        deque.insertLast(514);
        System.out.println("Expected output: [114, 514]");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.insertFront(810);
        deque.insertFront(19);
        deque.insertFront(19);
        System.out.println("Expected output: [19, 19, 810, 114, 514]");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.insertFront(64);
        System.out.println("Expected output: [19, 19, 810, 114, 514]");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.insertLast(89);
        System.out.println("Expected output: [19, 19, 810, 114, 514]");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.deleteFront();
        System.out.println("Expected output: [19, 810, 114, 514]");
        deque.displayCircularDeque();
        System.out.println("===================================================");

        deque.deleteLast();
        System.out.println("Expected output: [19, 810, 114]");
        deque.displayCircularDeque();
        System.out.println("===================================================");
    }
}
