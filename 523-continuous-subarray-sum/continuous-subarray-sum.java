class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //if I found my answer at 1st index, do dry run on {2, 4, 43, 45}
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(!map.containsKey(sum % k)) {
                map.put(sum % k, i);
            } else {
                if(i - map.get(sum % k) > 1) return true;
            }
        }
        return false;
    }
}