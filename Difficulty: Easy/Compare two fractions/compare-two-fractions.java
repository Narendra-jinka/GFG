//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    float getFloat(String s){
        
        String[] parts = s.split("/");
        float numerator = Float.parseFloat(parts[0]);
        float denominator = Float.parseFloat(parts[1]);
        return numerator / denominator;
    }
    
    String compareFrac(String str) {
        // Code here
        String[] arr=str.split(",");
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i].trim();
        }
        
        float a=getFloat(arr[0]);
        
        float b=getFloat(arr[1]);
        
        if(a>b){
            return arr[0];
        }
        if(a==b){
            return "equal";
        }
        else{
            return arr[1];
        }
        
    }
}
