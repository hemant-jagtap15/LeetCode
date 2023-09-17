class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        for(int k : nums) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int maxi = 0;
        for(Integer key : map.keySet()) {
            maxi = Math.max(maxi, map.get(key));
        }

        if(maxi <= n / 2) {
            if(n % 2 == 0) return 0;
            else {
                return 1;
            }
        }

        return maxi - (n - maxi);
    }
}