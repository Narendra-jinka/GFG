//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node reverse(Node head){
        Node prev = null;
        Node cur =head;
        
        while(cur!=null){
            Node next = cur.next;
            cur.next = prev;
            prev =cur;
            cur = next;
        }
        
        return prev;
    }
    public Node addOne(Node head) {
        // code here.
        Node r = reverse(head);
        Node cur =r;
        int carry =1;
        while(cur!=null){
            if(cur.data == 9 && carry == 1){
                cur.data =0;
                carry =1;
            }
            else if(carry ==1){
                cur.data = cur.data+1;
                carry =0;
            }
            cur = cur.next;
        }
        
        head = reverse(r);
        
        if(carry !=0){
            Node newNode = new Node(1);
            
            newNode.next =head;
            head = newNode;
            return head;
        }
        return head;
    }
}
