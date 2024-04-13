//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    
    static long inversionCount(long arr[], long N) {
        return mergeSort(arr, 0, N - 1);
    }
    
    static long mergeSort(long arr[], long low, long high) {
        long count = 0;
        if (low < high) {
            long mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }
        return count;
    }
    
    static long merge(long arr[], long low, long mid, long high) {
        long left[] = Arrays.copyOfRange(arr, (int) low, (int) (mid + 1));
        long right[] = Arrays.copyOfRange(arr, (int) (mid + 1), (int) (high + 1));
        
        long count = 0;
        
        int i = 0, j = 0, k = (int) low;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (mid - (low + i) + 1);
            }
        }
        
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        
        return count;
    }
}
