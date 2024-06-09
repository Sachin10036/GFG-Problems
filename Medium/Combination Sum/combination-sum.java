//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution {

    static void findCombinations(int ind, ArrayList<Integer> A, int B, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds) {
        if (B == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < A.size(); i++) {
            if (i > ind && A.get(i).equals(A.get(i - 1))) {
                continue;
            }

            if (A.get(i) <= B) {
                ds.add(A.get(i));
                findCombinations(i, A, B - A.get(i), ans, ds); 
                ds.remove(ds.size() - 1);
            }
        }
    }

    // Function to return a list of combinations whose sum is equal to given number
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A); 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        findCombinations(0, A, B, ans, new ArrayList<>());
        return ans;
    }
    
}
