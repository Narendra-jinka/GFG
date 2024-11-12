//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        
        int[] res = new int[]{-1,-1};
        
        for(int i:arr){
            if(i<=x){
                if(i==x){
                  res[0]=x;
                  res[1]=x;
                  break;
                } 
                else{
                    res[0]=Math.max(res[0],i);
                }
            }
            else{
                if(res[1]!=-1) res[1] = Math.min(res[1],i);
                else res[1] = i;
                
            }
        }
        
        
        return res;
    }
}
