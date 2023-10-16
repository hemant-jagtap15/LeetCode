class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = (int)(1e9);
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(sum - target) < Math.abs(ans - target)) {
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
}