import java.util.*;

class Item {
    int profit;
    int weight;

    // Constructor to initialize profit and weight
    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Comparator to sort items based on profit/weight ratio in descending order
    public static Comparator<Item> compare = (Item a, Item b) -> Double.compare(
            (double) b.profit / b.weight, (double) a.profit / a.weight);

    // Method to solve fractional knapsack problem
    public static double fractionalKnapsack(int capacity, List<Item> items) {
        // Sort items based on profit-to-weight ratio
        items.sort(compare);
        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.profit;
                capacity -= item.weight;
            } else {
                totalValue += item.profit * ((double) capacity / item.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter number of items: ");
        int n = scanner.nextInt();
        List<Item> items = new ArrayList<>();

        // Input profit and weight for each item
        for (int i = 0; i < n; ++i) {
            System.out.print("Enter profit of item " + (i + 1) + ": ");
            int profit = scanner.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = scanner.nextInt();
            items.add(new Item(profit, weight));
        }

        // Input capacity of knapsack
        System.out.print("Enter capacity of knapsack: ");
        int capacity = scanner.nextInt();

        // Calculate maximum value that can be carried in the knapsack
        System.out.println("Maximum value in knapsack: " + fractionalKnapsack(capacity, items));

        scanner.close();
    }
}
