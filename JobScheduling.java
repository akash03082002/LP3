import java.util.Arrays;
import java.util.Comparator;

class Job {
    char jobId;
    int deadline;
    int profit;

    // Constructor
    public Job(char jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

    // Comparator to sort jobs by profit in descending order
    public static Comparator<Job> profitComparator = (Job x, Job y) -> y.profit - x.profit;

    public static void jobScheduling(Job[] jobs, int n) {
        // Sort jobs in descending order of profit
        Arrays.sort(jobs, profitComparator);

        // Array to store selected jobs
        int[] jobsSelected = new int[3];
        // Array to track occupied time slots
        boolean[] slots = new boolean[3];

        // Initialize all slots to false (empty)
        Arrays.fill(slots, false);

        // Select jobs based on the given deadline and profit
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(3, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slots[j]) {
                    jobsSelected[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }

        // Calculate maximum profit and print selected jobs
        int maxProfit = 0;
        for (int i = 0; i < 3; i++) {
            if (slots[i]) {
                maxProfit += jobs[jobsSelected[i]].profit;
                System.out.println(jobs[jobsSelected[i]].jobId + " " + jobs[jobsSelected[i]].profit);
            }
        }
        System.out.println("Max Profit is " + maxProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        int n = jobs.length;
        jobScheduling(jobs, n);
    }
}
