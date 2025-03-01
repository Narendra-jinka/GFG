//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');  // Handling multi-digit numbers
            } else if (c == '[') {
                countStack.push(k);  // Store the current count
                resultStack.push(currentString.toString());  // Store the current string
                currentString = new StringBuilder();
                k = 0;  // Reset k
            } else if (c == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = new StringBuilder(resultStack.pop());
                
                decodedString.append(currentString.toString().repeat(repeatTimes));  
                currentString = decodedString;
            } else {
                currentString.append(c);  // Regular character, add to current string
            }
        }
        
        return currentString.toString();
    }
}