//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> stack = new Stack();
        int n = arr.length;
        for(String s : arr){
            if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int c = a*b;
                stack.push(c);
            }
            else if(s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int c = a+b;
                stack.push(c);
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                int c = b-a;
                stack.push(c);
            }
            else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int c = b/a;
                stack.push(c);
            }
            else{
                int a = Integer.parseInt(s);
                stack.push(a);
            }
        }
        return stack.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends