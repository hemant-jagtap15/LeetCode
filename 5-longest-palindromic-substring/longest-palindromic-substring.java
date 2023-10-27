class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(s, i, j, dp)) {
                    int size = j - i + 1;
                    if(size > max) {
                        max = Math.max(max, size);
                        ans = s.substring(i, j+1);
                    }
                    
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int start, int end, boolean dp[][]) {
        if(start >= end) {
           return true;
        }
        if(dp[start][end] != false) return dp[start][end];

        if(s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = isPalindrome(s, start+1, end-1, dp);
        }
        return dp[start][end] = false; 
    }
}