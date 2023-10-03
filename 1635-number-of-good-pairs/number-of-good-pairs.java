class Solution {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                cnt += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return cnt;
    }
}