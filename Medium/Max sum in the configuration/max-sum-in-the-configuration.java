//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends

/*
class Solution {
     long calSum(int[] a,int n){
        long newsum=0;
        for(int i=0;i<n;i++){
            newsum+=(i*a[i]);
        }
        return newsum;
    }
    
    long max_sum(int a[], int n) {
        // Your code here
        long sum=0;
        for(int i=0;i<n;i++){
           long cursum=calSum(a,n);
           sum=Math.max(cursum,sum);
           rotateArray(a,n);
        }
        return sum;
    }
     void rotateArray(int a[],int n){
        int k= a[0];
        for(int i=1;i<n;i++){
            a[i-1]=a[i];
        }
        a[n-1]=k;
    }
}
*/

class Solution {
    long calSum(int[] a, int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) i * a[i];
        }
        return sum;
    }

    long max_sum(int a[], int n) {
        // Initial sum of i * arr[i]
        long currentSum = calSum(a, n);

        // Sum of array elements
        long arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += a[i];
        }

        long maxSum = currentSum;
        
        // Iterate through the array to calculate the maximum sum of i * arr[i]
        for (int i = 1; i < n; i++) {
            // Calculate the new sum based on the previous sum
            currentSum = currentSum + arraySum -(long) n * a[n - i];
            // Update maxSum if the new sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

