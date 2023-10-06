class Solution {
    public int integerBreak(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return ways(n, dp);
    }

    public int ways(int num, int dp[]) {
        if(num <= 3) {
            return num;
        }
        if(dp[num] != -1) return dp[num];
        int ans = num;
        for(int i = 2; i < num; i++) {
            ans = Math.max(ans, i * ways(num - i, dp));
        }
        return dp[num] = ans;
    }
}