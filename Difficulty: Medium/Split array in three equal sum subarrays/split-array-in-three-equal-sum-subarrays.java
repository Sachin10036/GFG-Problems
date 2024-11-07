//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1 || result.size() != 2) {
                System.out.println("false");
            } else {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i <= result.get(0))
                        sum1 += arr[i];

                    else if (i <= result.get(1))
                        sum2 += arr[i];

                    else
                        sum3 += arr[i];
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        ArrayList<Integer> l = new ArrayList<>();
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];   
        }
        if(sum%3!=0){
            
            l.add(-1);
            l.add(-1);
            return l;
        }
        int res = sum/3;
        int s=0;
        for(int i=0;i<n;i++)
        {
            s=s+arr[i];
            
            if(s==res){
                s=0;
                l.add(i);
            }
            
            if(l.size()==2){
                return l;
            }
        }
        l.add(-1);
        l.add(-1);
        return l;
    }
}

