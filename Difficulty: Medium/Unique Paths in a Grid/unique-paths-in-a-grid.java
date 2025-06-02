class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        int rowlen = grid.length;
        int columnlen = grid[0].length;
        if (grid[0][0] == 1 || grid[rowlen - 1][columnlen - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[rowlen][columnlen];
        dp[0][0] = 1;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < columnlen; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        return dp[rowlen - 1][columnlen - 1];
    }
}