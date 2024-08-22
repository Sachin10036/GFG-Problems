//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    static int MOD = (int) (Math.pow(10, 9)+7);
    
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int totSum = 0;
        for(int i =0; i<n; i++){
            totSum += arr[i];
        }
        if(totSum - d < 0 || (totSum - d) % 2 != 0) return 0;
        return f(arr, (totSum-d) / 2);
    }
    
    public static int f(int arr[], int sum){
        int n = arr.length;
        int dp[][] = new int[n][sum+1];
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(arr[0] != 0 &&  arr[0] <= sum) dp[0][arr[0]] = 1;
        for(int ind=1; ind<n; ind++){
            for(int target = 0; target <= sum; target++){
                int notPick = dp[ind-1][target];
                int pick = 0;
                if(arr[ind] <= target) pick = dp[ind-1][target-arr[ind]];
                dp[ind][target] = (notPick + pick) % MOD;
            }
        }
        return dp[n-1][sum];
    }
}
        
