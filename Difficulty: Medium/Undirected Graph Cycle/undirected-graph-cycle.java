//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean visited[] = new boolean[V];
        
        List<Integer>[] adjacencyList = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            adjacencyList[i] = new ArrayList<Integer>();
        }
        
        for (int edge[]: edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        
        for (int i = 0; i < V; i++) {
            if (hasCycle(i, -1, adjacencyList, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean hasCycle(int v, int parent, List<Integer>[] adjacencyList, boolean visited[]) {
        if (visited[v]) {
            return true;
        }
        
        visited[v] = true;
        for (int neighbour: adjacencyList[v]) {
            if (neighbour == parent) continue;
            if (hasCycle(neighbour, v, adjacencyList, visited)) return true;
        }
        visited[v] = false;
        
        return false;
    }
}

