//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int totSum = 0;
        for(int i = 0; i<n; i++){
            totSum += arr[i];
        }
        int k = totSum;
        boolean dp[][] = new boolean[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }
        for(int ind = 1; ind < n; ind++){
            for(int target = 1; target <= k; target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind] <= target){
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = notTake || take;
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int s1 = 0; s1 <= k; s1++){
            if(dp[n-1][s1] == true){
                int s2 = k - s1;
                mini = Math.min(mini, Math.abs(s2-s1));
            }
        }
        return mini;
	} 
}
