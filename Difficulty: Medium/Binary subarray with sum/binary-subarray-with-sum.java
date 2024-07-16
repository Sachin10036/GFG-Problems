//{ Driver Code Starts
//Initial Template for Java

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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int N, int target){
        // code here
        return lessEqualToK(arr, N, target) - lessEqualToK(arr, N, target-1);
    }
    
    int lessEqualToK(int arr[], int N, int target){
        if(target < 0) return 0;
        int l=0, r=0, ans=0, sum=0;
        while(r < N){
            sum += arr[r];
            while(sum > target){
                sum -= arr[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}