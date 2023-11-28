class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int val : nums) {
            sum = (sum + val) % p;
        }

        if(sum % p == 0) return 0;

        int tar = (sum % p + p) % p;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0;
        int ans = n;
        for(int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int currRem = (curr % p + p) % p;
            int need = ((currRem - tar) % p + p) % p;
            map.put(currRem, i);
            if(map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }  
        }

        if(ans == n) return -1;
        return ans;
    }
}