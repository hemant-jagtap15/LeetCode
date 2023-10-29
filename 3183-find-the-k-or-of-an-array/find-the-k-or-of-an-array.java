class Solution {
    public int findKOr(int[] nums, int k) {
        int n = nums.length;
        int result = 0;

        for (int bit = 0; bit < 31; bit++) {
            int count = 0;

            for (int num : nums) {
                if ((num & (int)(Math.pow(2, bit))) == (int)Math.pow(2, bit)) {
                    count++;
                }
            }

            if (count >= k) {
                result += Math.pow(2, bit);
            }
        }

        return result;
    }
}