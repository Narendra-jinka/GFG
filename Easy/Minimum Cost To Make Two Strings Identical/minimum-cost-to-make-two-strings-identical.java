//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
        int n = y.length();
        
        // Create a DP table to store lengths of LCS
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Length of the longest common subsequence
        int lcsLength = dp[m][n];
        
        // Calculate the number of deletions needed
        int deletionsFromX = m - lcsLength;
        int deletionsFromY = n - lcsLength;
        
        // Calculate the minimum cost
        int minCost = (deletionsFromX * costX) + (deletionsFromY * costY);
        
        return minCost;
    }
}
