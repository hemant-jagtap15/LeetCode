class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = (int)(1e9);
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == target) return currSum;
                if(Math.abs(target - currSum) < Math.abs(target - ans)) {
                    ans = currSum;
                }
                if(currSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }
}