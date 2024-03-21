//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.util.HashMap;
import java.io.*;

    class Node
    {
        int data;
        Node left,right;
        Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    }
		
public class GFG2
{
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
    
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    GFG g = new GFG();
			
			    ArrayList<Integer> res = g.zigZagTraversal(root) ;
			    for (int i = 0; i < res.size (); i++)
			        System.out.print (res.get (i) + " ");
			    System. out. println();  
    			
                t--;
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

/*class GFG
{
    
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> arr=new ArrayList<>();
	    if(root == null){
	        return arr;
	    }
	    Queue<Node> q=new LinkedList<Node>();
	    q.offer(root);
	    boolean flag=true;       //l->R 
	    while(!q.isEmpty()){
	        int size=q.size();
	        int[] row=new int[size];
	        
	        for(int i=0;i<size;i++){
	            int index = flag ? i : (size -1-i);
	            Node p=q.remove();
	            row[index]=p.data;
	            if(p.left !=null){
	                q.offer(p.left);
	            }
	            if(p.right != null){
	                q.offer(p.right);
	            }
	        }
	        flag = !flag;
	        arr.addAll(Arrays.asList(row));
	    }
	    return arr;
	}
}*/


class GFG {
//Function to store the zig zag order traversal of tree in a list.
    void levelOrderTraversal(Node root,int count,ArrayList<ArrayList<Integer>> traverse) {
        if(root == null)
            return;
        
        if(traverse.size() > count)
            traverse.get(count).add(root.data);
        else {
            ArrayList<Integer> level = new ArrayList<>();
            level.add(root.data);
            traverse.add(level);
        }
        levelOrderTraversal(root.left,count + 1,traverse);
        levelOrderTraversal(root.right,count + 1,traverse);
    }
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> traverse = new ArrayList<>();
        levelOrderTraversal(root,0,traverse);
        
        for(int i=0; i<traverse.size(); i++) {
            for(int j=0; j<traverse.get(i).size(); j++) {
                if(i % 2 != 0) 
                    ans.add(traverse.get(i).get(traverse.get(i).size()-1-j));
                else 
                    ans.add(traverse.get(i).get(j));
            }
        }
        return ans;
        
    }
}