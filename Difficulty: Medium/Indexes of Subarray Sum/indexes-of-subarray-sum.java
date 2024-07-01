//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            String s[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for (int ii = 0; ii < res.size(); ii++) ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> ret = new ArrayList<>();
        int left=0 , right=0 , preS=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0 ;i<n ;i++){
            preS+=arr[i];
            if(preS==s){
                ret.add(1);
                ret.add(i+1);
                break;
            }
            if(hm.containsKey(preS-s)){
                ret.add(hm.get(preS-s)+1);
                ret.add(i+1);
                break;
            }
            hm.put(preS,i+1);
        }
        if(ret.isEmpty()) ret.add(-1);
        return ret;
    }
    }
