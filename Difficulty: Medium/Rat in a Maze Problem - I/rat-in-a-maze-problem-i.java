//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends




class Solution {
    public void helper(int i, int j, int[][] mat, int size, StringBuilder sb, ArrayList<String> ans, boolean[][] visited) {
        
        if (i < 0 || i >= size || j < 0 || j >= size || mat[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        
        if (i == size - 1 && j == size - 1) {
            ans.add(sb.toString());
            return;
        }
        
        
        visited[i][j] = true;
        
        // Move Down
        if (i + 1 < size && mat[i + 1][j] == 1 && !visited[i + 1][j]) {
            sb.append("D");
            helper(i + 1, j, mat, size, sb, ans, visited);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        // Move Right
        if (j + 1 < size && mat[i][j + 1] == 1 && !visited[i][j + 1]) {
            sb.append("R");
            helper(i, j + 1, mat, size, sb, ans, visited);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        // Move Up
        if (i - 1 >= 0 && mat[i - 1][j] == 1 && !visited[i - 1][j]) {
            sb.append("U");
            helper(i - 1, j, mat, size, sb, ans, visited);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        // Move Left
        if (j - 1 >= 0 && mat[i][j - 1] == 1 && !visited[i][j - 1]) {
            sb.append("L");
            helper(i, j - 1, mat, size, sb, ans, visited);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
        
        
        visited[i][j] = false;
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        
        
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return ans;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[n][n];
        
        helper(0, 0, mat, n, sb, ans, visited);
        
        return ans;
    }
}
