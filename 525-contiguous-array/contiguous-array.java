class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < n; i++) {
            count = nums[i] == 0 ? count-1 : count+1;
            if(map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
                //System.out.print(maxLen + " ");
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}