/*
Output the binary form of a decimal integer.
Recursion should be used, and your input should be a positive integer.
The signature of the recursive function should be:
public static String binaryForm (int n);

For example:
Input: 27; output: 11011
Input: 33; output: 100001
Input: 3; output: 11
*/
package Lab1;
import java.util.Scanner;

public class Q2 {
	public static String binaryForm (int n) {
		if (n == 1) {
			return "1";
		}
		if (n == 0) {
			return "0";
		}
		else {
			return binaryForm(n/2) + n%2;
		}
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            String result = binaryForm(number);
            if (number == 0) {
                result = "0";
            }
            System.out.println("Binary form of " + number + " is: " + result);
        }

        scanner.close();
    }
}
