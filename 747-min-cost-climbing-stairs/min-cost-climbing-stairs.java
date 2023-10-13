class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(ways(0, cost, dp), ways(1, cost, dp));
    }

    public int ways(int i, int cost[], int dp[]) {
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];

        int oneStep = cost[i] + ways(i+1, cost, dp);
        int twoStep = cost[i] + ways(i+2, cost, dp);
        return dp[i] = Math.min(oneStep, twoStep);
    }
}