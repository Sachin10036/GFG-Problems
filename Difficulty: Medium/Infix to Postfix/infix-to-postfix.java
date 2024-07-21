//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        int n = exp.length();
        int i=0;
        Stack<Character> st = new Stack<>();
        String result = new String("");
        while(i < n){
            char c = exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)){
                result += c;
            }
            else if(c =='('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    result += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && Prec(c) <= Prec(st.peek())){
                    result += st.pop();
                }
                st.push(c);
            }
            i++;
        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
    
    public static int Prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            
        }
        return -1;
    }
}