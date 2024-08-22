//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        Map<Character,List<Character>>graph=new  HashMap<>();
        for(int i=0;i<dict.length-1;i++){
             String s1=dict[i];
             String s2=dict[i+1];
             int j=0;
             int len=Math.min(s1.length(),s2.length());
             while(j<len&&s1.charAt(j)==s2.charAt(j))
                j++;
            
             if(j==len)
               continue;
             char ch1=s1.charAt(j);
             char ch2=s2.charAt(j);
             if(!graph.containsKey(ch1))
               graph.put(ch1,new ArrayList<Character>());
             graph.get(ch1).add(ch2);    
        }
        int []degree=new int[k];
        for(char i:graph.keySet())
           for(char j:graph.get(i))
              degree[j-'a']++;
        
        String ans="";
        Queue<Character>queue=new LinkedList<>();
        for(int i=0;i<k;i++){
            if(degree[i]==0)
              queue.add((char)(i+'a'));
        }
        while(!queue.isEmpty()){
            char ch=queue.poll();
            ans+=ch;
            if(graph.containsKey(ch)){
                for(char j:graph.get(ch)){
                    degree[j-'a']--;
                    if(degree[j-'a']==0)
                       queue.add(j);
                }
            }
        }
        
        return ans.length()!=k?"":ans;
    }
}