class Solution {
    int mod = (int)(1e9+7);
    public int numWays(int steps, int arrLen) {
        int dp[][] = new int[Math.min(arrLen, steps) + 1][steps+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return ways(0, steps, arrLen, dp);
    }

    public int ways(int i, int j, int len, int dp[][]) {
        if(i < 0 || i >= len) return 0;
        if(j == 0) {
            if(i == 0) return 1;
            else return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int ans = ways(i+1, j-1, len, dp);
        ans = (ans + ways(i-1, j-1, len, dp)) % mod;
        ans = (ans + ways(i, j-1, len, dp)) % mod;
        
        return dp[i][j] = (ans) % mod;
    }
}