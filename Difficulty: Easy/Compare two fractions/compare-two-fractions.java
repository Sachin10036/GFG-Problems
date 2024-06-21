//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        int i = 0;
        int a = 0, b = 0, c = 0, d = 0;

        while (str.charAt(i) != '/') a = a * 10 + (str.charAt(i++) - '0');
        i++; 
     
        while (str.charAt(i) != ',') b = b * 10 + (str.charAt(i++) - '0');
        i += 2; 

        while (str.charAt(i) != '/') c = c * 10 + (str.charAt(i++) - '0');
        i++;

        while (i < str.length()) d = d * 10 + (str.charAt(i++) - '0');

        int lhs = a * d;
        int rhs = b * c;

        if (lhs == rhs) return "equal";
        return lhs > rhs ? a + "/" + b : c + "/" + d;
    }
}