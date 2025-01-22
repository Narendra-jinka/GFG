//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node ans = new Node(-1);
        Node temp = ans;
        Node head1 = reverse(num1);
        Node head2 = reverse(num2);
        int carry =0, rem=0, sum=0;
        while(head1!=null && head2!=null){
            sum = (head1.data + head2.data) + carry;
            rem = sum%10;
            carry = sum/10;
            temp.next = new Node(rem);
            temp = temp.next;
            head1 = head1.next;
            head2 = head2.next;
            
        }
        while(head1!=null){
            sum = (head1.data) + carry;
            rem = sum%10;
            carry = sum/10;
            temp.next = new Node(rem);
            temp = temp.next;
            head1 = head1.next;
        }
        while(head2!=null){
            sum = (head2.data) + carry;
            rem = sum%10;
            carry = sum/10;
            temp.next = new Node(rem);
            temp = temp.next;
            head2 = head2.next; 
        }
        while(carry != 0 ){
            sum = carry;
            rem = sum%10;
            carry = sum/10;
            temp.next = new Node(rem);
            temp = temp.next;
        }
        Node newHead =  reverse(ans.next);
        while(newHead!= null && newHead.data == 0){
            newHead = newHead.next;
        }
        return newHead == null ? new Node(0) : newHead;
    }
    
    static Node reverse (Node curr){
        Node i = curr;
        Node j = curr;
        Node temp = null;
        while(j!=null){
            j = j.next;
            i.next=temp;
            temp =i;
            i=j;
        }
        return temp;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends