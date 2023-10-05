class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int appear = n / 3;
        for(Integer key : map.keySet()) {
            if(map.get(key) > appear) {
                ans.add(key);
            }
        }
        return ans;
    }
}