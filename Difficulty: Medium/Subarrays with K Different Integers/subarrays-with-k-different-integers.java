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
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int N, int k) {
    // code here
    return lessOrEqualToK(arr, k) - lessOrEqualToK(arr, k-1);

  }
  
  static int lessOrEqualToK(int arr[], int k){
      int l=0, r=0, cnt=0;
      int n = arr.length;
      HashMap<Integer, Integer> map = new HashMap<>();
      while(r < n){
          map.put(arr[r], map.getOrDefault(arr[r], 0) +1);
          while(map.size() > k){
              int val = map.get(arr[l]);
              map.put(arr[l], val-1);
              if(map.get(arr[l]) ==0){
                  map.remove(arr[l]);
              }
              l++;
          }
          cnt += (r-l+1);
          r++;
      }
      return cnt;
  }
}
     