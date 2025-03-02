//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
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
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Pair{
    int index;
    int value;
    public Pair(int index, int value){
        this.index = index;
        this.value = value;
    }
}
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.value - a.value);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<k; i++){
            pq.add(new Pair(i, arr[i]));
        }
        int left = 0, right = 0;
        while(right < arr.length){
            if(right < k-1){
                pq.add(new Pair(right, arr[right]));
                right++;
            }else{
                pq.add(new Pair(right, arr[right]));
                while(!pq.isEmpty() && pq.peek().index < left){
                    pq.poll();
                }
                list.add(pq.peek().value);
                left++;
                right++;
            }
        }
        return list;
    }
}