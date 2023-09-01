class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = 1; i < n; i++) {
            if(nums[i] < nums[i-1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) return true;
        int arr[] = new int[n];
        int x = 0;
        for(int j = idx; j < n; j++) {
            arr[x++] = nums[j];
        }
        for(int j = 0; j < idx; j++) {
            arr[x++] = nums[j];
        }
        
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}