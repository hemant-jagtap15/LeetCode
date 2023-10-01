class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int maxLeft[] = new int[n];
        int maxRight[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) maxLeft[i] = 0;
            else {
                maxLeft[i] = Math.max(maxLeft[i-1], nums[i-1]);
            }
        }
        for(int i = n-1; i >= 0; i--) {
            if(i == n-1) maxRight[i] = 0;
            else {
                maxRight[i] = Math.max(maxRight[i+1], nums[i+1]);
            }
        }

        for(int i = 1; i < n-1; i++) {
            if(nums[i] < maxLeft[i]) {
                ans = Math.max(ans, ((long)maxLeft[i] - (long)nums[i]) * (long)maxRight[i]);
            }
        }
        return ans;
    }
}
