class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(char key : map.keySet()) {
            list.add(map.get(key));
        }
        Collections.sort(list, Collections.reverseOrder());

        int ans = 0;
        int i = 0;
        for(int val : list) {
            i++;
            if(i <= 8) {
                ans += 1 * val;
            } else if(i <= 16) {
                ans += 2 * val;
            } else if(i <= 24) {
                ans += 3 * val;
            } else {
                ans += 4 * val;
            }
        }
        return ans;
    }
}