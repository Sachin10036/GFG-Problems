//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int n = pre_exp.length();
        int i= n-1;
        Stack<String> st = new Stack<>();
        while(i >= 0){
            char c = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(String.valueOf(c));
            }
            else{
                String t1 = st.pop();
                String t2 = st.pop();
                String con = '(' + t1 + c + t2 + ')';
                st.push(con);
            }
            i--;
        }
        return st.peek();
    }
}
