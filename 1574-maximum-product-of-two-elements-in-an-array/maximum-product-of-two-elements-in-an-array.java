class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int arr1 = nums[n-1] - 1;
        int arr2 = nums[n-2] - 1;
        return arr1 * arr2;
    }
}