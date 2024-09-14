//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
         int n = arr.size();
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
      
        for (int i = 0; i < n; i++) {
            int num = arr.get(i);
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        
        int i = 0, j = 0, ind = 0;
        boolean isPositiveTurn = true;
        while (i < pos.size() && j < neg.size()) {
            if (isPositiveTurn) {
                arr.set(ind++, pos.get(i++));
            } else {
                arr.set(ind++, neg.get(j++));
            }
            isPositiveTurn = !isPositiveTurn;
        }
        while (i < pos.size()) {
            arr.set(ind++, pos.get(i++));
        }
        while (j < neg.size()) {
            arr.set(ind++, neg.get(j++));
        }
    }
}