//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/


class Solution{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        Queue<Pair> q=new LinkedList<>();
        Map<Integer, ArrayList<Integer>> hm=new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
           int n=q.size();
          for(int i=0;i<n;i++){
           Pair p= q.poll();
           Node temp=p.root;
           int line=p.line;
           if(hm.containsKey(line)){
               ArrayList<Integer> list=hm.get(line);
               list.add(temp.data);
               hm.put(line,list);
           }else{
               ArrayList<Integer> list=new ArrayList<Integer>();
               list.add(temp.data);
               hm.put(line,list);
           }
           if(temp.left!=null){
               q.add(new Pair(temp.left,line-1));
           }
           if(temp.right!=null){
               q.add(new Pair(temp.right,line+1));
           }
           }
           
        }
       // System.out.println(hm);
        ArrayList<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> h: hm.entrySet()){
             res.add(sum(h.getValue()));
        }
        return res;
    }
    
    public int sum(ArrayList<Integer> list){
        int sum=0;
        for(int i:list)
          sum+=i;
         return sum; 
    }
}

class Pair{
    Node root;
    int line;
    Pair(Node root,int line){
        this.root=root;
        this.line=line;
    }
}
