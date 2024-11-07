import java.util.Scanner;

public class FibonacciNonRecursive {

    // Method to calculate the nth Fibonacci number
    public static int fib(int n, int[] steps) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;

        for (int i = 2; i <= n; i++) {
            steps[0]++;
            c = a + b;
            a = b;
            b = c;
        }
        steps[0]++;
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        int[] steps = { 0 }; // Using an array to pass steps by reference
        int result = fib(n, steps);

        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Steps: " + steps[0]);

        scanner.close();
    }
}
