//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        int m = arr.length;
        int n = arr[0].length;
        
        if(m == 1) return "0 R";
        
        int res = -1;
       
        for(int i = 0; i < m; i++){
            if(isPalindrome(arr[i], 0, n-1)){
                res = i;
                break;
            }
        }
        
        if(res >= 0) return res + " R";
    
        for(int i = 0; i < n; i++){
            int[] temp = new int[m];
            int k = 0;
            for(int j = 0; j < m; j++){
                temp[k++] = arr[j][i];
            }
            
            if(isPalindrome(temp, 0, n-1)){
                res = i;
                break;
            }
        }
        
        
        return res >= 0 ? (res + " C") : "-1";
    }
    
    static boolean isPalindrome(int[] arr, int i, int n){
        while(i < n){
            if(arr[i] != arr[n]) return false;
            i++;
            n--;
        }
        
        return true;
    }
}
