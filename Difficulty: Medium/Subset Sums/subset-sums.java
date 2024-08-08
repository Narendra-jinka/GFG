//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    
    public static void generate(int i,ArrayList<Integer> arr,int count,ArrayList<Integer> ds){
        if(i == arr.size()){
            ds.add(count);
            return;
            
        }
        count+=arr.get(i);
        generate(i+1,arr,count,ds);
        count-=arr.get(i);
        generate(i+1,arr,count,ds);
        
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        
        ArrayList<Integer> ds=new ArrayList<>();
        generate(0,arr,0,ds);
        
        return ds;
    }
}