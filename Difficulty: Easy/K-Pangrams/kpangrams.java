//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
         int[] freq = new int[26]; 
        int totalChars = 0; 
    
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                totalChars++;
                freq[Character.toLowerCase(c) - 'a']++;
            } 
            
        }
       
        int unqChar = 0;
        for (int count : freq) {
            if (count > 0) {
                unqChar++;
            }
        }
       
        int missingChars = 26 - unqChar;
        
        if (totalChars < 26) {
            return false;
        }
        
        return missingChars <= k;
        
    }
}