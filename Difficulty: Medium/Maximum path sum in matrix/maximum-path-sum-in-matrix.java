//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int prev[] = new int[N];
        for(int j = 0; j<N; j++){
            prev[j] = Matrix[0][j];
        }
        for(int i = 1; i<N; i++){
            int cur[] = new int[N];
            for(int j = 0; j<N; j++){
                int up = Matrix[i][j] + prev[j];
                int ld = Matrix[i][j];
                if(j-1 >= 0) ld += prev[j-1];
                else ld += -1e9;
                int rd = Matrix[i][j];
                if(j+1 < N) rd += prev[j+1];
                else rd += -1e9;
                cur[j] = Math.max(up, Math.max(ld, rd));
            }
            prev = cur;
        }
        int maxi = prev[0];
        for(int j = 0; j<N; j++){
            maxi = Math.max(maxi, prev[j]);
        }
        return maxi;
    }
}