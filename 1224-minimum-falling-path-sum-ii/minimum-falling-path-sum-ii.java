class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        
        for(int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j];
        }

        int min = (int)(1e9);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int minPath = (int)(1e9);
                for(int k = 0; k < grid[0].length; k++) {
                    if(k == j) continue;
                    int curr = grid[i][j] + dp[i-1][k];
                    minPath = Math.min(minPath, curr);
                }

                dp[i][j] = minPath;
            }
        }

        for(int j = 0; j < m; j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        
        return min;
    }
}