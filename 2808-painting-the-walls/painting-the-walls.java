class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int dp[][] = new int[n][n+1];
        for(int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return ways(n-1, n, cost, time, dp);
    }

    public int ways(int i, int walls, int cost[], int time[], int dp[][]) {
        if(walls <= 0) {
            return 0;
        }
        if(i < 0) return (int)(1e9);
        if(dp[i][walls] != -1) return dp[i][walls];

        int paint = cost[i] + ways(i-1, walls - 1 - time[i], cost, time, dp);
        int notPaint = ways(i-1, walls, cost, time, dp);
        return dp[i][walls] = Math.min(paint, notPaint);
    }
}