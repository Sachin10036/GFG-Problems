//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        if(S.length() <= 1){
            return S;
        }
        String maxStr = S.substring(0, 1);
        for(int i=0; i<S.length()-1; i++){
            String odd = expandFromCenter(S, i, i);
            String even = expandFromCenter(S, i, i+1);
            
            if(odd.length() > maxStr.length()){
                maxStr = odd;
            }
            if(even.length() > maxStr.length()){
                maxStr = even;
            }
        }
        return maxStr;
    }
    static String expandFromCenter(String S, int left, int right){
        while(left >=0 && right<S.length() && S.charAt(left) == S.charAt(right)){
            left--;
            right++;
        }
        return S.substring(left+1, right);
    }
}