class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        long curr = 0;

        while(right < n) {
            int target = nums[right];
            curr += target;

            while((right - left + 1) * target - curr > k) {
                curr -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
         }
        return ans;
    }
}