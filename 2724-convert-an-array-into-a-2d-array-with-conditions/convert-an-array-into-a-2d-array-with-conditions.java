class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        while(!map.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(Integer key : map.keySet()) {
                list.add(key);
                map.put(key, map.get(key) - 1);
            }
            for(int val : list) {
                if(map.get(val) == 0) map.remove(val);
            }
            
            ans.add(list);
        }

        return ans;
    }
}