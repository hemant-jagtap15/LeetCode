class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : tasks) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int ans = 0;
        for(Integer key : map.keySet()) {
            int val = map.get(key); 
            if(val == 1) return -1;
            else if(val == 2) {
                ans += 1;
            } else {
                if(val % 3 == 0) {
                    ans += (val / 3);
                } else if(val % 3 == 1) {
                    int k = (val / 3) - 1;
                    ans += k + 2;
                } else {
                    int k = (val / 3);
                    ans += k + 1;
                }
            }
        }
        return ans;
    }
}