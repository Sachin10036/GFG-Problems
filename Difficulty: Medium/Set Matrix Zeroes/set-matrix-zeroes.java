//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public static void setMatrixZeroes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                mat[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                mat[i][0] = 0;
            }
        }
    }
}