//{ Driver Code Starts
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();
            ArrayList<Integer> ans = g.noSibling(root);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/


class Tree {
    ArrayList<Integer> arr = new ArrayList<>();

    // Helper function to perform depth-first traversal and find nodes without siblings
    void JustCall(Node node) {
        if (node == null) return;

        // If the current node has only one child, add that child's data to the list
        if (node.left != null && node.right == null) {
            arr.add(node.left.data);
        }
        if (node.right != null && node.left == null) {
            arr.add(node.right.data);
        }

        // Recursively traverse left and right subtrees
        JustCall(node.left);
        JustCall(node.right);
    }

    // Main function to find nodes without siblings
    ArrayList<Integer> noSibling(Node node) {
        // Initialize the list to store nodes without siblings
        ArrayList<Integer> result = new ArrayList<>();

        // Call the helper function to traverse the tree and populate the result list
        JustCall(node);

        // If there are nodes without siblings, return the list
        if (!arr.isEmpty()) {
            // Sort the list in increasing order
            arr.sort(null);
            return arr;
        } else {
            // If all nodes have siblings or the tree is empty, return a list with -1
            result.add(-1);
            return result;
        }
    }
}
