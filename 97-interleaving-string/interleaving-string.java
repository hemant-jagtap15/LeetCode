class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();
        if(i + j  != k) return false;
        Boolean[][] dp = new Boolean[i+1][j+1];
        
        return ways(0, 0, s1, s2, s3, dp);
    }

    public boolean ways(int i, int j, String s1, String s2, String s3, Boolean dp[][]) {
        if(i == s1.length() && j == s2.length()) {
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        boolean ans = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            ans = ways(i + 1, j, s1, s2, s3, dp);
        }
        if (ans == true) return dp[i][j] = true;

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            ans = ways(i, j + 1, s1, s2, s3, dp);
        }
        return dp[i][j] = ans;
    }
}