//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
class Solution {

    static int findFloor(int[] arr, int k) {
        
        
        int left =0;
        int right =arr.length-1;
        int idx=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]<=k){
                idx=mid;
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        
        if(idx == -1){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int res = -1;
        for(int i=0;i<=idx;i++){
            
            if(max < arr[i]){
                res = i;
                max = arr[i];
            }
        }
        return res;
        
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.findFloor(arr, k);

            System.out.print(ans);

            System.out.println(); // New line after printing the results
        }
    }
}

// } Driver Code Ends