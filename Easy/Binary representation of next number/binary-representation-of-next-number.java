//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        char str[] = s.toCharArray();
        boolean isAllOne = true;
        for(int i=str.length-1;i>=0;i--){
            if(str[i]=='1') str[i] = '0';
            else{
                isAllOne = false;
                str[i] = '1';
                break;
            }
        }
        if(isAllOne) return "1"+new String(str);
        int i = 0;
        for(;i<str.length;i++) if(str[i]=='1') break;
        return new String(Arrays.copyOfRange(str,i,s.length()));
    }
}