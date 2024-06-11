//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            int[] brr = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maxTip(n, x, y, arr, brr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr) {
        // code here
        long ans = 0;
        List<Integer> va = new ArrayList<>();
        List<Integer> vb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ans += Math.max(arr[i], brr[i]);
            if (arr[i] > brr[i]) {
                va.add(arr[i] - brr[i]);
            } else if (arr[i] < brr[i]) {
                vb.add(brr[i] - arr[i]);
            }
        }

        Collections.sort(va);
        Collections.sort(vb);

        int excess_a = Math.max(0, va.size() - x);
        int excess_b = Math.max(0, vb.size() - y);

        for (int i = 0; i < excess_a; i++) {
            ans -= va.get(i);
        }

        for (int i = 0; i < excess_b; i++) {
            ans -= vb.get(i);
        }

        return ans;
        
    }
}
