//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {

        String binaryString = String.format("%32s", Long.toBinaryString(x)).replace(' ', '0');
        StringBuilder sb = new StringBuilder(binaryString).reverse();
        long reversed = Long.parseLong(sb.toString(), 2);
        return reversed;

        
    }
}