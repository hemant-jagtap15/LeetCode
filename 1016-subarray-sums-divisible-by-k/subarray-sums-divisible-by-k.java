class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length; 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int prefix = 0;

        for(int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % k;
            if(prefix < 0) prefix += k;

            if(map.containsKey(prefix)) {
                ans += map.get(prefix);
                map.put(prefix, map.get(prefix) + 1);
            } else {
                map.put(prefix, 1);
            }
        }
        return ans;
    }
}