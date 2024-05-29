//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        boolean[] dp = new boolean[n + 1];
        
        // Base cases
        dp[0] = false; // If there are 0 coins, the player to move loses (no move possible)
        dp[1] = true;  // If there is 1 coin, the player to move wins by taking the last coin

        // Fill the dp array for all positions from 2 to n
        for (int i = 2; i <= n; i++) {
            // A position i is a winning position if we can move to a losing position
            if (i >= 1 && !dp[i - 1]) {
                dp[i] = true;
            } else if (i >= x && !dp[i - x]) {
                dp[i] = true;
            } else if (i >= y && !dp[i - y]) {
                dp[i] = true;
            } else {
                dp[i] = false; // If no move leads to a losing position, this is a losing position
            }
        }

        // Return 1 if Geek can win starting with n coins, otherwise 0
        return dp[n] ? 1 : 0;
    }
}
