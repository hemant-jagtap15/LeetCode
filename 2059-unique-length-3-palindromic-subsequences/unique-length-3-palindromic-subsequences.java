class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }
        int ans = 0;
        for(Character ch : set) {
            int i = -1; 
            int j = 0;
            for(int k = 0; k < n; k++) {
                if(s.charAt(k) == ch) {
                    if(i == -1) {
                        i = k;
                    }
                    j = k;
                }
            }

            HashSet<Character> set2 = new HashSet<>();
            for(int k = i+1; k < j; k++) {
                set2.add(s.charAt(k));
            }
            ans += set2.size();
        }
        return ans;
    }
}
