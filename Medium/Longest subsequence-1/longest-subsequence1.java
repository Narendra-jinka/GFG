//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    private static int longestSubseqUtil(int[] a, int n, int currentIndex, int[] memo) {
        // Base case: the longest subsequence ending at the first element is 1
        if (currentIndex == 0) {
            return 1;
        }
        
        // If the result is already computed, return it
        if (memo[currentIndex] != -1) {
            return memo[currentIndex];
        }
        
        // Initialize the length of the longest subsequence ending at the current element
        int maxLen = 1;
        
        // Check all previous elements to find the longest subsequence that can end at the current element
        for (int j = 0; j < currentIndex; j++) {
            if (Math.abs(a[currentIndex] - a[j]) == 1) {
                maxLen = Math.max(maxLen, longestSubseqUtil(a, n, j, memo) + 1);
            }
        }
        
        // Memoize the result
        memo[currentIndex] = maxLen;
        
        return maxLen;
    }

    public static int longestSubseq(int n, int[] a) {
        // Memoization array
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        // Compute the longest subsequence for each element
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, longestSubseqUtil(a, n, i, memo));
        }
        
        return maxLen;
    }

   
}
