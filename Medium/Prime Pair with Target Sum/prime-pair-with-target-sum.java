//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
         ArrayList<Integer> arr=new ArrayList<>();
        boolean [] isPrime=new boolean[n/2];
        Arrays.fill(isPrime,false);
        for(int i=3;i*i<n;i+=2){
            if(!isPrime[i/2]){
                for(int j=i*i;j<n;j+=i*2){
                    isPrime[j/2]=true;
                }
            }
        }
        arr.add(2);
        for(int i=3;i<n;i+=2){
            if(!isPrime[i/2]){
                arr.add(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=arr.size()-1;
        while(i<=j){
            int sum=arr.get(i)+arr.get(j);
            if(sum==n){
                ans.add(arr.get(i));
                ans.add(arr.get(j));
                break;
            }else if(sum<n){
                i++;
            }else{
                j--;
            }
        }
        if(ans.size()==0){
            ans.add(-1);
             ans.add(-1);
        }
        return ans;
    }
}
