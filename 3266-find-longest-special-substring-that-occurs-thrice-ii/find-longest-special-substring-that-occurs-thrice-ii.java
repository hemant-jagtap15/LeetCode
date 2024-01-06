class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;
        
        int freq[][] = new int[26][n+1];
        char prev = s.charAt(0);
        int len = 1;

        freq[prev - 'a'][1] = 1;
        
        for(int i = 1; i < n; i++) {
            char curr = s.charAt(i);

            if(curr == prev) {
                len++;
                freq[curr - 'a'][len] += 1;
            } else {
                freq[curr - 'a'][1] += 1;
                prev = curr;
                len = 1;
            }
        }

        for(int i = 0; i < 26; i++) {
            int prefix = 0;
            for(int j = n; j >= 1; j--) {
                prefix += freq[i][j];
                if(prefix >= 3) {
                    ans = Math.max(ans, j);
                    break;
                }
            }
        }

        return ans;
    }
}