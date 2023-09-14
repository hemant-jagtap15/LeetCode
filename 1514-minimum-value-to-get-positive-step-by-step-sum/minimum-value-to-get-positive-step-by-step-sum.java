class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int prefix = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            min = Math.min(prefix, min);
        }
        return 1 - min;
    }
}