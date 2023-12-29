class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int dp[][] = new int[n+1][d+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return ways(0, d, n, jobDifficulty, dp);
    }

    public int ways(int i, int d, int n, int jobDifficulty[], int dp[][]) {
        if(i == n) return (int)(1e9);
        if(d == 1) {
            return maxValue(i, n-1, jobDifficulty);
        }
        if(dp[i][d] != -1) return dp[i][d]; 
        int ans = (int)(1e9);

        for(int j = i; j < n; j++) {
            ans = Math.min(ans, maxValue(i, j, jobDifficulty) + ways(j+1, d-1, n, jobDifficulty, dp));
        }

        return dp[i][d] = ans;
    }

    public int maxValue(int i, int j, int jobDifficulty[]) {
        int max = 0;
        for(int k = i; k <= j; k++) {
            max = Math.max(max, jobDifficulty[k]);
        }
        return max;
    }
}