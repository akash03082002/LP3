import java.util.Scanner;

public class FibonacciRecursive {

    // Method to calculate Fibonacci number recursively
    public static int fib(int n, int[] steps) {
        steps[0]++;
        if (n <= 1)
            return n;
        return fib(n - 1, steps) + fib(n - 2, steps);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int[] steps = { 0 }; // Using an array to pass steps by reference
        int result = fib(n, steps);

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Steps: " + steps[0]);

        scanner.close();
    }
}
