//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int countFreq(int[] nums, int target) {
        // code here
        int r = nums.length-1;
        int l=0;
        int idx =-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }
            else if(nums[mid] > target){
                r = mid-1;
            }
            else{
                idx = mid;
                r = mid -1;
            }
        }
        
        if(idx == -1){
            return 0;
        }
        else{
            int count = 0;
            for(int i=idx;i<nums.length;i++){
                if(nums[i]==target){
                    count++;
                }
            }
            return count;
        }
    }
}
