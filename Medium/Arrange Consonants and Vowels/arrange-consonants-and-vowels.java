//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        
        HashSet<Character> vowelSet = new HashSet<>();
        
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        
        Node newHead = head;
        Node consHead = new Node(' '); // Dummy node for consonants
        Node vowelHead = new Node(' '); // Dummy node for vowels
        Node cons = consHead;
        Node vowel = vowelHead;
        
        while (newHead != null) {
            if (vowelSet.contains(newHead.data)) {
                vowel.next = newHead;
                vowel = vowel.next;
            } else {
                cons.next = newHead;
                cons = cons.next;
            }
            newHead = newHead.next;
        }
        
        // Connect the vowel list to the consonant list
        vowel.next = consHead.next;
        // Ensure the end of the list
        cons.next = null;
        
        // Return the head of the combined list
        return vowelHead.next;
    }
}