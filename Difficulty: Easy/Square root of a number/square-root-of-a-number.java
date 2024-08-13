//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        // Your code here
        long left = 0;
        long right = n;
        long ans = 0;
        
        while (left <= right) {
            long mid = left + (right-left)/2;
            long sq = mid * mid;
            if(sq == n) {
                return mid;
            } else if(sq < n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;   
            }
        }
        return ans;
    }
}
