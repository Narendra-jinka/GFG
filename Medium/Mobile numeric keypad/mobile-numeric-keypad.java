//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        if(n==1) return 10;
        
        Map<Integer, int[]> transitions = new HashMap<>();
        transitions.put(0, new int[]{0, 8});
        transitions.put(1, new int[]{1, 4, 2});
        transitions.put(2, new int[]{1, 2, 3, 5});
        transitions.put(3, new int[]{2, 3, 6});
        transitions.put(4, new int[]{1, 4, 5, 7});
        transitions.put(5, new int[]{2, 4, 5, 6, 8});
        transitions.put(6, new int[]{3, 5, 6, 9});
        transitions.put(7, new int[]{4, 7, 8});
        transitions.put(8, new int[]{0, 5, 7, 8, 9});
        transitions.put(9, new int[]{6, 8, 9});
        
        long[][] dp=new long[n+1][10];
        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }
        
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                for(int k:transitions.get(j)){
                    dp[i][k] += dp[i-1][j];
                }
            }
        }
        long totalSequences = 0;
        for (int j = 0; j < 10; j++) {
            totalSequences += dp[n][j];
        }

        return totalSequences;
    }
}