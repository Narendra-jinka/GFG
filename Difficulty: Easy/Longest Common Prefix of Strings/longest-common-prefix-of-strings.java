//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if(arr.length == 1) return arr[0];
        String res=arr[0];
        for(String s:arr){
            
            int n= s.length() > res.length() ? res.length() : s.length() ;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                if(s.charAt(i)==res.charAt(i)){
                    sb.append(s.charAt(i));
                }
                else{
                    break;
                }
            }
            
            res=sb.toString();
        } 
        
        if(res.equals("")){
            return "-1";
        }
        return res;
    }
}