class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1];
        for(int arr[] : dp) Arrays.fill(arr, -1);
        return ways(n, m, nums1, nums2, dp);
    }
    public int ways(int i, int j, int nums1[], int nums2[], int dp[][]) {
        if(i == 0 || j == 0) return Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        
        int dot = nums1[i-1] * nums2[j-1] + Math.max(ways(i-1, j-1, nums1, nums2, dp), 0);
        int notDot = Math.max(ways(i, j-1, nums1, nums2, dp), ways(i-1, j, nums1, nums2, dp));
        
        return dp[i][j] = Math.max(dot, notDot);
    }
}