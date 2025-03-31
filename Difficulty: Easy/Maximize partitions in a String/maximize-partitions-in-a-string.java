//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxPartitions(String s) {
        // code here
        int x[] = new int[26];
        for(int i=0;i<s.length();i++) {
            x[s.charAt(i)-'a'] = i;
        }
        
        int y = 0;
        int last = 0;
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            last = Math.max(last, x[ch - 'a']);
            if(last == i){
                y++;
            }
        }
        return y;
    }
}