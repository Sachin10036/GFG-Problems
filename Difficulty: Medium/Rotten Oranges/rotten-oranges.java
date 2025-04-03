//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static class Pair {
        int row;
        int col;
        int time;
        Pair (int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] mat) {
        // Code here
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.offer (new Pair (i, j, 0));
                    vis[i][j] = true;
                }
                if (mat[i][j] == 1)
                    cnt++;
            }
        }
        int time = 0, cf = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;
            time = Math.max(time, t);
            
            for (int i = 0; i < dirs.length; ++i){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && mat[nr][nc] == 1) {
                    q.offer (new Pair (nr, nc, t + 1));
                    vis[nr][nc] = true;
                    cf++;
                }
            }
        }
        return (cf != cnt) ? - 1 : time;
    }
}
