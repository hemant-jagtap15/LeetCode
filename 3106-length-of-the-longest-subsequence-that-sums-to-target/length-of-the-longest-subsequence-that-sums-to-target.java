class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int dp[][] = new int[n][target+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int maxLen = ways(n-1, target, nums, dp);
        return maxLen < 0 ? -1 : maxLen;
    }

    public int ways(int idx, int tar, List<Integer> nums, int dp[][]) {
        if(tar == 0) return 0;
        if(idx < 0) return Integer.MIN_VALUE;
        
        if(dp[idx][tar] != -1) return dp[idx][tar];
        int notPick = ways(idx-1, tar, nums, dp);
        int pick = Integer.MIN_VALUE;
        if(nums.get(idx) <= tar) {
            pick = 1 + ways(idx-1, tar - nums.get(idx), nums, dp);
        }
        return dp[idx][tar] = Math.max(notPick, pick);
    }
}