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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        int nge[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i= 2*N-1; i>= 0 ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i%N]){
                st.pop();
            }
            if(i < N){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[i%N]);
        }
        return nge;
    }
}
