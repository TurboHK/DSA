/*
Output the reverse order form of an integer.
Recursion should be used, and your input should be a positive integer.
The signature of the recursive function should be:
public static int reverseForm (int n);

For example:
Input: 2783; output: 3872
Input: 598; output: 895
Input: 3; output: 3
*/

package Lab1;
import java.util.Scanner;

public class Q1 {
	public static int reverseForm(int n) {
		if (n < 10) {
			return n;
		}
		else {
			int numDigits = (int) Math.log10(n);
	        return (n % 10) * (int) Math.pow(10, numDigits) + reverseForm(n / 10);
		}
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int result = reverseForm(number);
            System.out.println("Reverse of " + number + " is: " + result);
        }

        scanner.close();
    }
}
