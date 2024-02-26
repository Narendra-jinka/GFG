//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            res.add(String.valueOf(s.charAt(i)));
            int resSize = res.size();
            
            for (int j = 0; j < resSize - 1; j++) {
                res.add(res.get(j) + s.charAt(i));
            }
        }
        
        // Sort the result list lexicographically
        Collections.sort(res);
        
        return res;
    }
}