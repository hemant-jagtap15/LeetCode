class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String str = "";
            for(int j = i; j < n; j++) {
                char ch = s.charAt(j);
                
                str += ch;
                map.put(str, map.getOrDefault(str, 0) + 1);

                if(j != n-1 && s.charAt(j+1) != ch) break; 
                
            }
        }

        for(String key : map.keySet()) {
            if(map.get(key) >= 3) {
                if(key.length() > ans) {
                    ans = key.length();
                } 
            }
        }
        return ans;
    }
}