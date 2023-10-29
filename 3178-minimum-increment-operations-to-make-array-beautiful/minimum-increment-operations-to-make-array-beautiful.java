class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long dp[] = new long[n];
        Arrays.fill(dp, -1);
        return ways(0, nums, k, dp);
    }

    public long ways(int idx, int nums[], int k, long dp[]) {
        if(idx > nums.length-3) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        long opt1 = Math.max(0, k - nums[idx]) + ways(idx+1, nums, k, dp);
        long opt2 = Math.max(0, k - nums[idx + 1]) + ways(idx+2, nums, k, dp);
        long opt3 = Math.max(0, k - nums[idx + 2]) + ways(idx+3, nums, k, dp);

        return dp[idx] = Math.min(opt1, Math.min(opt2, opt3));
    }
}