class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        HashSet<Integer> set = new HashSet<>();
        int cnt = 0;
        
        for(Character key : map.keySet()) {
            int freq = map.get(key);
            
            while(set.contains(freq)) {
                freq--;
                cnt++;
            }
            
            if(freq > 0) set.add(freq);
        }
        
        return cnt;
    }
}