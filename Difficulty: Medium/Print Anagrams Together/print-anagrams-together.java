//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // LinkedHashMap to preserve the order of first appearance
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();

        // Group strings by their sorted characters
        for (String s : arr) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch); // Sort characters
            String sortedKey = new String(ch); // Use sorted characters as key
            
            // Add to the corresponding group
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(s);
        }

        // Sort each group lexicographically
        

        // Convert map values to ArrayList<ArrayList<String>>
        return new ArrayList<>(map.values());
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends