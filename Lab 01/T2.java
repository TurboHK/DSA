package Lab1;

import java.util.Scanner;

public class T2 {
	public static int GCD(int x, int y) {
		if (y == 0) {
			return x;
		}
		else {
			return GCD(y, x % y);
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first natural number: ");
        int num1 = input.nextInt();
        System.out.print("Enter the second natural number: ");
        int num2 = input.nextInt();
		
        if (num1 < 0 || num2 < 0) {
            System.out.println("Please enter non-negative numbers.");
        } else {
            int result = GCD(num1, num2);
            System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
        }
        
		
		input.close();
	}
}
