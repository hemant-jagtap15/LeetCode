class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return ways(n, dp);
    }
    public int ways(int n, int dp[]) {
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = ways(n-1, dp) + ways(n-2, dp);
    }
}