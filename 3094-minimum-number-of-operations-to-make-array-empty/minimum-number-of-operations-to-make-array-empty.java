class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int cnt = 0;
        
        for (int key : map.keySet()) {
            int val = map.get(key);
            
            while (val > 0) {
                if (val == 1) {
                    return -1;
                }
                if (val == 4 || val == 2) {
                    val -= 2;
                    cnt += 1;
                } else {
                    val -= 3;
                    cnt += 1;
                }
            }
        }
        
        return cnt;
    }
}


