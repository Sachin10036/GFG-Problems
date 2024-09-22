//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int n=str.length();
        
        int p=0,s=1,pos=1,count=0;
        
        while(p<n && s<n){
            if(str.charAt(p)==str.charAt(s)){
                p++;
                s++;
                count++;
            }
            else{
                p=0; //reset prefix pointer to start
                pos++; //incement suffix start position
                s=pos; //update suffix to new start position
                count=0;
            }
        }
        return count;
    }
}