//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int M, int sum) {
        // Your code goes here
        int dp[][] = new int[M][sum+1];
        for(int t = 0; t <= sum; t++){
            if(t % coins[0] == 0){
                dp[0][t] = t / coins[0];
            }
            else dp[0][t] = (int)1e9;
        }
        
        for(int ind = 1; ind<M; ind++){
            for(int t = 0; t<= sum; t++){
                int notTake = 0+dp[ind-1][t];
                int take = Integer.MAX_VALUE;
                if(coins[ind] <= t) take = 1+dp[ind][t-coins[ind]];
                dp[ind][t] = Math.min(take, notTake);
            }
        }
        int ans = dp[M-1][sum];
        if(ans >= 1e9) return -1;
        else return ans;
        
    }
}