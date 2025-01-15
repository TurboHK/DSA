package Lab1;
import java.util.Scanner;

public class T1 {
	public static int factR(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factR(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a positive number: ");
		int number = input.nextInt();
		
		if (number < 1) {
			System.out.println("You should input a positive number!");
		}
		else {
			int result = factR(number);
            System.out.println("Factorial of " + number + " is: " + result);
		}
		
		input.close();
	}
}
