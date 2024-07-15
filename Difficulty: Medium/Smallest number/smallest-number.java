//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    
    public int getSum(int st){
        int sum=0;
        while(st>0){
            int rem=st%10;
            sum+=rem;
            st/=10;
        }
        return sum;
    }
    public String smallestNumber(int s, int d) {
        // code here
        HashMap<Integer,int[]> map=new HashMap<>();
        
        map.put(1,new int[]{0,9});
        map.put(2,new int[]{10,99});
        map.put(3,new int[]{100,999});
        map.put(4,new int[]{1000,9999});
        map.put(5,new int[]{10000,99999});
        map.put(6,new int[]{100000,999999});
        
        int st=map.get(d)[0];
        int e=map.get(d)[1];
        
        while(st<=e){
            int sc=getSum(st);
            if(sc==s) return Integer.toString(st);
            st++;
        }
       
        return "-1";
    }
}
