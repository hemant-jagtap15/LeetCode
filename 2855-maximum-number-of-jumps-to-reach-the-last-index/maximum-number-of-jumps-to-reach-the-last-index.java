class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        int ans = ways(n-1, nums, target, n-1, dp);
        return ans < 0 ? -1 : ans;
    }

    public int ways(int i, int nums[], int tar, int jumps, int dp[]) {
        if(i == 0) return 0;
        int ans = Integer.MIN_VALUE;

        if(dp[i] != -1) return dp[i];

        for(int j = 1; j <= jumps; j++) {
            if(i - j >= 0) {
                if((nums[i] - nums[i - j] ) <= tar && nums[i] - nums[i - j] >= -tar) {
                    ans = Math.max(ans, 1 + ways(i-j, nums, tar, jumps, dp));
                }
            }
        }
        return dp[i] = ans;
    }
}