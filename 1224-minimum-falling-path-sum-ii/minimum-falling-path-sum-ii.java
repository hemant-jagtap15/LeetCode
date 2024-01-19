class Solution {
    public int ways(int i, int j, int grid[][], int dp[][]) {
        if(i == 0) return grid[0][j];

        if(dp[i][j] != -1) return dp[i][j];

        int minPath = (int)(1e9);
        for(int k = 0; k < grid[0].length; k++) {
            if(k == j) continue;
            int curr = grid[i][j] + ways(i-1, k, grid, dp);
            minPath = Math.min(minPath, curr);
        }

        return dp[i][j] = minPath;
    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int min = (int)(1e9);
        for(int j = 0; j < m; j++) {
            min = Math.min(min, ways(n-1, j, grid, dp));
        }
        return min;
    }
}