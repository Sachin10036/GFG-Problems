//{ Driver Code Starts
// Initial Template for Java

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

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int l=0, r=0, maxLen=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(r < N){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) +1);
            if(map.size() > 2){
                reduceFrequency(map, fruits[l]);
                if(map.getOrDefault(fruits[l], 0) == 0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size() <= 2){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;
    }
    public static void reduceFrequency(HashMap<Integer, Integer> map, int key){
        map.computeIfPresent(key, (k,v) -> v > 1 ? v - 1 : null);
    }
}