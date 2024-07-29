//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    static class Pair<U, V> {
        public final U first;
        public final V second;
        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
    }
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Your code here
        int ans[] = new int[n];
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        int ind = -1;
        for(int i=0; i<n; i++){
            ind = ind+1;
            while(!st.isEmpty() && st.peek().first <= price[i]){
                st.pop();
            }
            ans[i] = ind - (st.isEmpty() ? -1 : st.peek().second);
            st.push(new Pair<>(price[i], ind));
        }
        return ans;
    }
}


//{ Driver Code Starts.

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            int i = 0;
            for (i = 0; i < n; i++) a[i] = sc.nextInt();

            int[] s = new Solution().calculateSpan(a, n);

            for (i = 0; i < n; i++) {
                System.out.print(s[i] + " ");
            }

            System.out.println();
        }
    }
}
// } Driver Code Ends