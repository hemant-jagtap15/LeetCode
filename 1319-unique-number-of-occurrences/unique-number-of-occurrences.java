class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Integer key : map.keySet()) {
            set.add(map.get(key));
        }
        return map.size() == set.size();
    }
}