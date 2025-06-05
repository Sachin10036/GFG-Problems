class Solution {
    private int dfs(ArrayList<Integer>[] graph, int src, int dest, int[] dp){
        if(src == dest) return 1;
        
        if(dp[src] != -1) return dp[src];
        int count = 0;
        for(int nbr : graph[src]){
            count += dfs(graph, nbr, dest, dp);
        }
        return dp[src] = count;
    }
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        ArrayList<Integer>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v); 
        }
        int[] dp = new int[V];
        Arrays.fill(dp, -1);
        return dfs(graph, src, dest, dp);
    }
}