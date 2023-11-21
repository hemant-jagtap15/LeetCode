class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)(1e9+7);
        int n = nums.length;
        int rev[] = new int[n];
        for(int i = 0; i < n; i++) {
            rev[i] = reverse(nums[i]);
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int find = nums[i] - rev[i];
            if(map.containsKey(find)) {
                ans = (ans + map.get(find)) % mod;
            }
            map.put(find, map.getOrDefault(find, 0) + 1);
        }
        return ans % mod;
    }

    public int reverse(int num) {
        String str = Integer.toString(num);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int x = Integer.parseInt(sb.toString());
        //System.out.print(x + " ");
        return x;
    }
}