class Solution {
    int mod = (int)(1e9+7);

    public int numOfArrays(int n, int m, int k) {
        int dp[][][] = new int[51][51][101];
        for(int arr[][]: dp){
            for(int row[] : arr) {
                Arrays.fill(row, -1);
            }
        }
        return ways(0, 0, 0, n, m, k, dp);
    }

    public int ways(int idx, int searchCost, int max, int n, int m, int k, int dp[][][]) {
        if(idx == n) {
            if(searchCost == k) return 1;
            return 0;
        }
        if(dp[idx][searchCost][max] != -1) return dp[idx][searchCost][max];
        int ans = 0;
        for(int i = 1; i <= m; i++) {
            if(i > max) {
                ans = (ans + ways(idx+1, searchCost+1, i, n, m, k, dp)) % mod;
            } else {
                ans = (ans + ways(idx+1, searchCost, max, n, m, k, dp)) % mod;
            }
        }
        return dp[idx][searchCost][max] = ans % mod;
    }
}
