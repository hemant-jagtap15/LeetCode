class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];

        for(int idx = 1; idx < n; idx++) {
            int pick = nums[idx];
            if(idx > 1) pick += dp[idx - 2];
            int nonPick = dp[idx - 1];

            dp[idx] = Math.max(pick, nonPick);
        }
        return dp[n-1];
    }
}