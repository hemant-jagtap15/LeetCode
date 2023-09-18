class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0;
        int left = 0;
        int n = nums.length;
        int maxOne = 0;
        int cnt = 0;
        while(right < n) {
            if(nums[right] == 0) cnt++;
        
            while(cnt > k) {
                if(nums[left] == 0) cnt--;
                left++;
            }

            if(cnt <= k) {
                maxOne = Math.max(maxOne, right - left + 1);
            }
            right++;
        }
        return maxOne;
    }
}