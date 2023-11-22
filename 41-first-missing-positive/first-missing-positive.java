class Solution {
    public int firstMissingPositive(int[] nums) {
        int find = 1;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            if(nums[i] != find) return find;
            else {
                find++;
            }
        }
        return find;
    }
}