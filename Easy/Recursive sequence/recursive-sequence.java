//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*class Solution{
    static long sequence(int n){
        // code here
        
        int x=1;
        long res=0;
        int count=1;
        while(n>0){
            long curr=1;
            for(int i=0;i<count;i++){
                curr*=x;
                x++;
            }
            res+=curr;
            n--;
            count++;
        }
        long mod = 1000000007L;
        return res%mod;
    }
}*/

class Solution{
    static int mod=1000000007;
    static long sequence(int n){
        long ans=0;
        long pre=1;
        for(int i=1;i<=n;i++)
        {
            long temp=1;
            for(int j=1;j<=i;j++)
            {
                temp=(temp*pre)%mod;
                pre++;
            }
            ans=(ans+temp)%mod;
        }
        return ans;
    }
}