class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int ans = -1;
        for(int i = 0; i < n; i++) {
            int max = -1;
            char ch = s.charAt(i);
            for(int j = i+1; j < n; j++) {
                if(ch == s.charAt(j)) {
                    max = j - i - 1;
                    ans = Math.max(ans, max);
                }
            }
        }
        return ans;
    }
}