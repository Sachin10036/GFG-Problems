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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        if(S.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0; right<S.length(); right++){
            if(!set.contains(S.charAt(right))){
                set.add(S.charAt(right));
                maxLength = Math.max(maxLength, right-left+1);
            }
            else{
                while(set.contains(S.charAt(right))){
                    set.remove(S.charAt(left));
                    left++;
                }
                set.add(S.charAt(right));
            }
        }
        return maxLength;
    }
}