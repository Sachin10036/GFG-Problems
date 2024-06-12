//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
        // code here
        if(n<4) return 0;
        int c=1;
        for(int i=5;i<=n;i++){
            int num=i;
            while(num>0){
                int r=num%10;
                if(r==4){
                    c++;
                    break;
                }
                num/=10;
            }
        }
        return c;
    }
}