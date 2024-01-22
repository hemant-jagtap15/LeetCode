class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int dup = -1;
        int notFound = -1;

        for(int i = 1; i <= nums.length; i++) {
            if(map.containsKey(i) && map.get(i) == 2) {
                dup = i;
            } else if(!map.containsKey(i)) {
                notFound = i;
            }
        }
        return new int[]{dup, notFound};
    }
}