class Solution {
    public int knightDialer(int n) {
        int list[][] = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int mod = (int)(1e9+7);
        int ans = 0;
        int dp[][] = new int[n+1][10];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for(int curr = 0; curr <= 9; curr++) {
            ans = (ans + solve(n-1, curr, list, dp, mod)) % mod;
        }
        return (ans) % mod;
    }

    public int solve(int n, int curr, int list[][], int dp[][], int mod) {
        if(n == 0) return 1;

        if(dp[n][curr] != -1) return dp[n][curr];

        int ans = 0;
        for(int path : list[curr]) {
            ans = (ans + solve(n-1, path, list, dp, mod)) % mod;
        }
        return dp[n][curr] = (ans) % mod;
    }
}