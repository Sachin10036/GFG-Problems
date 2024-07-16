//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int lastSeen[] = {-1, -1, -1};
        int cnt = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            lastSeen[s.charAt(i) -'a'] = i;
            if(lastSeen[0] != -1 || lastSeen[1] != -1 || lastSeen[2] != -1){
                cnt += (1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
            }
        }
        return cnt;
    }
}
        
