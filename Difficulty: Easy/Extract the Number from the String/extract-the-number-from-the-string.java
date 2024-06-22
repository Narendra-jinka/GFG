//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    long checkNum(String s){
        //System.out.println(s);
        for(char c:s.toCharArray()){
            if(c=='9') return -1;
        }
        
        return Long.parseLong(s);
    }
    long ExtractNumber(String sentence) {
        // code here
        
        String[] str=sentence.split(" ");
        
        long ans=-1;
        
        for(String s: str){
           if (!Character.isLetter(s.charAt(0))) {
                long cur=checkNum(s);
                if(cur !=-1 && cur>ans){
                    ans=cur;
                }
                
            }
        }
        return ans;
    }
}