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
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int max=Integer.MIN_VALUE;
        int l=0;
        int r=0;
        int n=s.length();
        LinkedHashMap<Character,Integer>map=new LinkedHashMap<>();
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            if(map.size()<=k){
                max=Math.max(max,r-l+1);
            }
            if(map.size()>k){
                int val=map.get(s.charAt(l));
                map.put(s.charAt(l),val-1);
                if(map.get(s.charAt(l))==0)
                map.remove(s.charAt(l));
                l++;
                
            }
            r++;
        }
        if(map.size()<k)
        return -1;
        return max;
    }
}