//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static  void merge(int arr[],int s,int mid,int e,long ar[]){
        int temp[] = new int[e-s+1];
        int i = s;
        int j = mid+1;
        int k =0;
        while(i<=mid&&j<=e){
            if(arr[i]>arr[j]){
                ar[0] += (mid-i+1);
                temp[k++] = arr[j++];
            }
            else{
                temp[k++] = arr[i++];
            }
        }
        while(i<=mid){
             temp[k++] = arr[i++];
        }
        while(j<=e){
             temp[k++] = arr[j++];
        }
        for(i = s,k=0;i<=e;i++,k++){
            arr[i]=temp[k];
        }
    }

    static void divide(int arr[],int s,int e,long ar[]){
        if(s>=e){
            return;
        }
        int mid = s+(e-s)/2;
        divide(arr,s,mid,ar);
        divide(arr,mid+1,e,ar);
        merge(arr,s,mid,e,ar);
    }
    static int countPairs(int arr[], int n) 
    {
         long ar[]  = new long[1]; 
         for(int i = 0;i<n;i++){
             arr[i] = arr[i]*i;
         }
     divide(arr,0,(int)n-1,ar);
     return (int)ar[0];
    }
}