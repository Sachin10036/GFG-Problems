//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    private String max;
    public String findMaximumNum(String s, int k) {
        // code here.
        max = s;
        char[] ch = s.toCharArray();
        helper(ch, k, 0);
        return max;
    }
    public void helper(char[] ch, int k, int index){
       if(k<=0 || index >= ch.length){
           return;
       } 
       char maxDigit = ch[index];
       for(int i=index+1; i<ch.length; i++){
           if(ch[i] > maxDigit){
               maxDigit = ch[i];
           }
       }
       if(maxDigit != ch[index]){
           k--;
       }
       for(int i = ch.length-1; i>=index; i--){
           if(ch[i] == maxDigit){
               swap(ch, i , index);
               String s = new String(ch);
               if(s.compareTo(max) > 0){
                   max = s;
               }
               helper(ch, k, index+1);
               swap(ch, i, index);
           }
       }
    }
    
    public void swap(char[] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}