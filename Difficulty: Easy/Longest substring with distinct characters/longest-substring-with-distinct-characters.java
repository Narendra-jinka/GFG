//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
         int[] arr=new int[26];
        int l=0;
        int maxlen=0;
        for(int r=0;r<s.length();r++){
            int charIndex=s.charAt(r)-'a';
            if(arr[charIndex]!=0){
                l=Math.max(l,arr[charIndex]);
            }
            arr[charIndex]=r+1;
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}