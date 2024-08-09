//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int k) {
        // code here
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for(int i=1; i<n; i++){
            int minCost = Integer.MAX_VALUE;
            for(int j=1; j<= k; j++){
                if((i-j) >= 0){
                    int jump = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minCost = Math.min(minCost, jump);
                }
            }
            dp[i] = minCost;
        }
        return dp[n-1];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, k);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends