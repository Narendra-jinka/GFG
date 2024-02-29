//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    long sumBitDifferences(int[] arr, int n) {
        long ans = 0;

        // Iterate through each bit position (0 to 31)
        for (int bitPos = 0; bitPos < 32; bitPos++) {
            int countSetBits = 0;

            // Count the number of set bits at the current position
            for (int num : arr) {
                countSetBits += (num >> bitPos) & 1;
            }

            // Count the number of unset bits at the current position
            int countUnsetBits = n - countSetBits;

            // Update the total sum by adding the product of counts
            ans += (long) countSetBits * countUnsetBits;
        }

        // Multiply by 2 to consider both (x, y) and (y, x) pairs
        return ans * 2;
    }
}

