class Solution {
    public int minStartValue(int[] nums) {
        int low = 1;
        int high = (int)(1e9);
        int startVal = -1;
        while(low <= high) {
            int mid = (low + high)/ 2;
            if(check(nums, mid)) {
                startVal = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return startVal;
    }

    public boolean check(int nums[], int start) {
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i] + start;
            if(val < 1) return false;
            start = val;
        }
        return true;
    }
}