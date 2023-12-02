class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> map= new HashMap<>();

        for(Character ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int n = words.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            int freq[] = new int[26];
            String str = words[i];
            int cnt = 0;
            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(map.containsKey(ch) && map.get(ch) > freq[ch - 'a']) {
                    freq[ch - 'a']++;
                    cnt++;
                } else {
                    cnt = 0;
                    break;    
                }
            }
            ans += cnt;
        }

        return ans;
    }
}