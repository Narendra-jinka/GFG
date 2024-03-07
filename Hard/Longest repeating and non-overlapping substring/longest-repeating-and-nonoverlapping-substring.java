//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        int[][] dp = new int[n+1][n+1];

int maxLen = 0;

int start = -1;

for (int i=1; i<=n; i++) {

   for (int j=i+1; j<=n; j++) {

      if (s.charAt(i-1) != s.charAt(j-1)) continue;

      if (dp[i-1][j-1] == 0) {

         dp[i][j] = j;

      } else {

         dp[i][j] = Math.max(dp[i-1][j-1], i+1);

      }

      if (j - dp[i][j] +1 > maxLen) {

         maxLen = j - dp[i][j] +1;

         start = dp[i][j] -1;

      }

   }

}

if (start == -1) return "-1";

else return s.substring(start, start+maxLen);
    }
};