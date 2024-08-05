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
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static final int MOD = 1000000007;

    static long topDown(int n) {
        // code here
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        return topDownHelper(n, dp);
    }
    
    private static long topDownHelper(int n, long dp[]){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1) return dp[n];
        dp[n] = (topDownHelper(n-1, dp) + topDownHelper(n-2, dp)) % MOD;
        return dp[n];
    }

    static long bottomUp(int n) {
        // code here
        if(n == 0) return 0;
        if(n == 1) return 1;
        long dp[] = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i= 2; i<= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }
}
