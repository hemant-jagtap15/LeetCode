class Solution {
    public boolean makeEqual(String[] words) {
        HashMap<Character, Integer> map = new HashMap();
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        
        int n = words.length;
        for (Character ch : map.keySet()) {
            int val = map.get(ch);
            if (val % n != 0) {
                return false;
            }
        }
        
        return true;
    }
}