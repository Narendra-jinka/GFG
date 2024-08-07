//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    /*public static void generate(int i,String str,ArrayList<String> list, HashSet<ArrayList<String>> set){
        if(i>=str.length()){
            set.add(new ArrayList<>(list));
            return;
        }
        
        list.add(str.charAt(i)+"");
        generate(i+1,str,list,set);
        list.remove(list.size()-1);
        generate(i+1,str,list,set);
    }
    
    public static String betterString(String str1, String str2) {
        // Code here
        if(str1.length()==1 && str2.length() ==1) return str1;
        
        int n=str1.length();
        ArrayList<String> list=new ArrayList<>();
        HashSet<ArrayList<String>> set=new HashSet<>();
        
        generate(0,str1,list,set);
        
        int n1=set.size();
        ArrayList<String> list2=new ArrayList<>();
        HashSet<ArrayList<String>> set2=new HashSet<>();
        generate(0,str2,list2,set2);
         int n2=set2.size();
         
         if(n1>=n2){
             return str1;
         }
         else{
             return str2;
         }*/
         
        public static int generate(String str){
            int n=str.length();
            
            HashMap<Character,Integer> map=new HashMap<>();
            
            int[] dp=new int [n+1];
            dp[0]=1;
            for(int i=1;i<=n;i++){
                char c=str.charAt(i-1);
                dp[i]=2*dp[i-1];
                
                if(map.containsKey(c)){
                    int ind=map.get(c);
                    dp[i]-=dp[ind];
                }
                map.put(c,i-1);
            }
            return dp[n]-1;
        }
        public static String betterString(String str1, String str2) {
        
            if(str1.length()==1 && str2.length() ==1) return str1;
            
            int n1=generate(str1);
            
            int n2=generate(str2);
            if(n1>=n2) return str1;
            else return str2;
            
        }
    }
