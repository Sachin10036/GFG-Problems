//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        // Code here
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        int maxi = 0;
        for(int i=0; i<arr.length; i++){
            maxi = Math.max(maxi, arr[i]);
            if(set.contains(arr[i])){
                cnt += maxi+1 - arr[i];
                maxi++;
                set.add(maxi);
            }
            else{
                set.add(arr[i]);
            }
        }
        return cnt;
    }
}