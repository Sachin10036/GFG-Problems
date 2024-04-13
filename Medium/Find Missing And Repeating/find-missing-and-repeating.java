//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long N = n;
        long SN = (N*(N+1))/2;
        long S2N = (N*(N+1)*(2*N+1))/6;
        long S =0, S2 = 0;
        for(int i=0; i<n; i++){
            S += arr[i];
            S2 += (long)arr[i]* (long)arr[i];
        }
        long val1 = S-SN;
        long val2 = S2-S2N;
        val2 = val2/val1;
        long x = (val1+val2)/2; // Repeating number
        long y = x - val1;  // Missing number
        int[] ans = {(int)x, (int)y};
        return ans;
    }
}