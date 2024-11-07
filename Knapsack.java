import java.util.*;

public class Knapsack {

    public static int knapsack01(int n, int[] values, int[] weights, int W, Map<String, Integer> dp) {
        if (n == 0 || W == 0)
            return 0;

        String key = n + "-" + W;
        if (dp.containsKey(key))
            return dp.get(key);

        if (weights[n - 1] <= W) {
            int included = values[n - 1] + knapsack01(n - 1, values, weights, W - weights[n - 1], dp);
            int excluded = knapsack01(n - 1, values, weights, W, dp);
            dp.put(key, Math.max(included, excluded));
        } else {
            dp.put(key, knapsack01(n - 1, values, weights, W, dp));
        }

        return dp.get(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the capacity of the knapsack: ");
        int W = scanner.nextInt();

        Map<String, Integer> dp = new HashMap<>();
        int max_value = knapsack01(n, values, weights, W, dp);

        System.out.println("Maximum value: " + max_value);

        scanner.close();
    }
}
