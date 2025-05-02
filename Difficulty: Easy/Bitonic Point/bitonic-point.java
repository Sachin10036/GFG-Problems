//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        // code here
        int start=1,end=arr.length-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid+1]>arr[mid]) start=mid+1;
            else if(arr[mid-1]>arr[mid]) end=mid-1;
            else return arr[mid];
        }
        
        return Math.max(arr[0],arr[arr.length-1]);
    }
}