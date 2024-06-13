//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
        if(n<3){
            return 1;
        }
        final int MOD = 1000000007;
        int p0=1, p1=1, p2=1;
        int ans = 0;
        for(int i=3; i<=n; i++){
            ans = (p1+p0) % MOD;
            p0 = p1;
            p1 = p2;
            p2 = ans;
        }
        return p2;
    }
    
}
