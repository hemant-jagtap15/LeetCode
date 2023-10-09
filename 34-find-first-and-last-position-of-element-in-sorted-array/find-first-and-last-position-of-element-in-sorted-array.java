class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        if(lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }
        int ub = upperBound(nums, target);
        return new int[]{lb, ub-1};
    }
    public int lowerBound(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int lb = nums.length;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= target) {
                lb = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lb;
    } 
    public int upperBound(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        int ub = nums.length;

        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] > target) {
                ub = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ub;
    } 
}