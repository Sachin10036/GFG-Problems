//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long subarrayRanges(int N, int[] arr) {
        // code here
        return sumSubarrayMaxs(arr) - sumSubarrayMins(arr);
    }
    public static long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNse(arr);
        int[] psee = findPsee(arr);
        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            total += (long) arr[i] * left * right;
        }

        return total;
    }

    private static int[] findNse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    private static int[] findPsee(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return psee;
    }

    public static long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] nge = findNge(arr);
        int[] pgee = findPgee(arr);
        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            total += (long) arr[i] * left * right;
        }

        return total;
    }

    private static int[] findNge(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nge;
    }

    private static int[] findPgee(int[] arr) {
        int n = arr.length;
        int[] pgee = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pgee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pgee;
    }
}
