//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int l=0;
        int r=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        int cnt=0;
        int sindex=-1;
        int minlen=Integer.MAX_VALUE;
        String st="";
        for(int i=0;i<p.length();i++){
            mpp.put(p.charAt(i), mpp.getOrDefault(p.charAt(i), 0) + 1);
        }
        while(r<s.length()){
            char ch=s.charAt(r);
            if(mpp.containsKey(ch) && mpp.get(ch)>0){   
                cnt++;
            }
            mpp.put(ch,mpp.getOrDefault(ch,0)-1);            
            while(cnt==p.length()){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sindex=l;
                }
                mpp.put(s.charAt(l),mpp.get(s.charAt(l))+1);
                if(mpp.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
                }
            r++;
        }
        return sindex==-1?"-1":s.substring(sindex,sindex+minlen);
    }
}