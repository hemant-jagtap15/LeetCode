class Solution {
    int mod = (int)(1e9+7);
    public int countVowelPermutation(int n) {
        long ans = 0;
        long dp[][] = new long[5][n + 1];
        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < 5; i++) {
            ans = (ans + ways(i, n - 1, dp)) % mod;
        }
        return (int) ans;
    }

    public long ways(int prev, int n, long dp[][]) {
        if (n == 0) return 1;
        if (dp[prev][n] != -1) return dp[prev][n];

        if (prev == 0) {
            dp[prev][n] = ways(1, n - 1, dp) % mod;
        } else if (prev == 1) {
            dp[prev][n] = (ways(0, n - 1, dp) + ways(2, n - 1, dp)) % mod;
        } else if (prev == 2) {
            dp[prev][n] = (ways(0, n - 1, dp) + ways(1, n - 1, dp) + ways(3, n - 1, dp) + ways(4, n - 1, dp)) % mod;
        } else if (prev == 3) {
            dp[prev][n] = (ways(2, n - 1, dp) + ways(4, n - 1, dp)) % mod;
        } else {
            dp[prev][n] = ways(0, n - 1, dp) % mod;
        }
        return dp[prev][n];
    }
}
