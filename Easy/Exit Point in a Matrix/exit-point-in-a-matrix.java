//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] mat) {
        int lr = 0,lc = 0,i = 0,j = 0;
        char d = 'r';
        while(!check(i,j,n,m)){
            lr = i;
            lc = j;
            if(mat[i][j]==1){
                if(d=='r') d = 'd';
                else if(d=='l') d = 'u';
                else if(d=='u') d = 'r';
                else d = 'l';
                mat[i][j] = 0;
            }
            int dir[] = findDir(d,i,j);
            i = dir[0];
            j = dir[1];
        }
        return new int[]{lr,lc};
    }
    static boolean check(int i,int j,int n,int m){
        return(i<0 || i>=n || j<0 || j>=m);
    }
    static int[] findDir(char d,int i,int j){
        if(d=='r') return new int[]{i,j+1};
        else if(d=='l') return new int[]{i,j-1};
        else if(d=='u') return new int[]{i-1,j};
        else return new int[]{i+1,j};
    }
}