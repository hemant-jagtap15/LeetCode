class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1];
        for(int i = 0; i <= n; i++) dp[i][0] = Integer.MIN_VALUE;
        for(int i = 0; i <= m; i++) dp[0][i] = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int dot = nums1[i-1] * nums2[j-1] + Math.max(dp[i-1][j-1], 0);
                int notDot = Math.max(dp[i][j-1], dp[i-1][j]);
                
                dp[i][j] = Math.max(dot, notDot);
            }
        }
        return dp[n][m];
    }
}