class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;

        for(Character ch : map1.keySet()) {
            if(!map2.containsKey(ch)) {
                cnt += map1.get(ch);
            }
            else if(map2.get(ch) < map1.get(ch)) {
                cnt += map1.get(ch) - map2.get(ch);
            }
        }

        return cnt;
    }
}