//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        int n = arr.length;
        int maxVal=0;
        int majorityElement = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            if(!map.containsKey(val))
            map.put(val,1);
            else{
            int newVal = map.get(val)+1;
            map.put(val,newVal);
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(maxVal<e.getValue()){
                maxVal=e.getValue();
                majorityElement = e.getKey();
            }
        }
        
        if(maxVal>n/2){
            return majorityElement;
        }
        else{
            return -1;
        }
    }
}

 