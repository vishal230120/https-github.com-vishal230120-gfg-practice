//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int max_courses(int n, int total, int[] cost) {
        // code here
          int[][] dp = new int[n + 1][total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, total, cost, 0, dp);
    }

    private int solve(int y, int total, int[] cost, int i, int[][] dp) {
        if (i == y) {
            return 0;
        }
        if (total == 0) {
            return 0;
        }
        if (dp[i][total] != -1) {
            return dp[i][total];
        }
        if (total >= cost[i]) {
            return dp[i][total] = Math.max(
                    solve(y, total, cost, i + 1, dp),
                    1 + solve(y, total - cost[i] + (int) Math.floor(0.9 * cost[i]), cost, i + 1, dp)
            );
        } else {
            return dp[i][total] = solve(y, total, cost, i + 1, dp);
        }
    }
}

