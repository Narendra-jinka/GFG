//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int noOfStation(double dis , int[] arr)
    {
        int n = arr.length;
        int cnt =0;
        for(int i=1;i<n;i++)
        {
            int numdis = (int) ((arr[i]-arr[i-1])/dis);
            if(arr[i]-arr[i-1] == dis*numdis)
            {
                numdis--;
            }
            cnt+=numdis;
        }
        return cnt;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double low =0;
        double high = 0;
        for(int i =1;i<n-1;i++)
        {
            high = Math.max(high,(double)(stations[i] - stations[i-1]));
        }
       double diff = 1e-6;
        while(high - low >diff)
        {
            double mid = (low+high)/2.0;
            int cnt = noOfStation(mid,stations);
            if(cnt>k)
            {
                low=mid;
            }
            else
            {
                high=mid;
            }
        }
        return high;
    }
}
