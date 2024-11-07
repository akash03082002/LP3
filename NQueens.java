public class NQueens {
    // Method to print the board
    public static void printBoard(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print((board[r][c] == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Method to check if a queen can be placed safely
    public static boolean isSafe(int[][] board, int r, int c, int n) {
        // Check the row on the left side
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = r, j = c; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive method to solve the N-Queens problem
    public static boolean solveNQueens(int[][] board, int c, int n) {
        // Base case: If all queens are placed, return true
        if (c >= n) {
            printBoard(board, n);
            return true;
        }

        // Try placing a queen in each row of the current column
        boolean solutionFound = false;
        for (int r = 0; r < n; r++) {
            if (isSafe(board, r, c, n)) {
                board[r][c] = 1;

                // Recur to place the rest of the queens
                solutionFound = solveNQueens(board, c + 1, n) || solutionFound;

                // Backtrack: remove the queen
                board[r][c] = 0;
            }
        }

        return solutionFound;
    }

    // Main method
    public static void main(String[] args) {
        int n = 4; // Change this value for different board sizes
        int[][] board = new int[n][n];

        if (!solveNQueens(board, 0, n)) {
            System.out.println("No solution exists.");
        }
    }
}
