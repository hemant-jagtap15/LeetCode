class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        
        for(int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int u = matrix[i][j] + dp[i-1][j];

                int ld = matrix[i][j];
                if(j-1 >= 0) ld += dp[i-1][j-1];
                else ld += (int)(1e9);

                int rd = matrix[i][j];
                if(j+1 < m) rd += dp[i-1][j+1];
                else rd += (int)(1e9);

                dp[i][j] = Math.min(u, Math.min(ld, rd));
            }
        }
        int min = (int)(1e9);
        for(int j = 0; j < m; j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
    }
}