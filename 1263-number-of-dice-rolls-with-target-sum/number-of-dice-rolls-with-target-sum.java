class Solution {
    int mod = (int)(1e9+7);

    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for (int val[] : dp) {
            Arrays.fill(val, -1);
        }
        return ways(dp, n, k, target);
    }

    public int ways(int dp[][], int n, int k, int target) {
        if (target == 0 && n == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return (dp[n][target] % mod);

        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            cnt = (cnt + ways(dp, n - 1, k, target - i)) % mod;
        }
        
        return dp[n][target] = cnt % mod;
    }
}

