class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][n+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return ways(0, prices, 0, n, dp);
    }

    public int ways(int idx, int prices[], int offer, int n, int dp[][]) {
        if(idx == n) return 0;
        
        if(dp[idx][offer] != -1) return dp[idx][offer];

        if(offer > 0) {
            int notTakeOffer = prices[idx] + ways(idx+1, prices, idx+1, n, dp);
            int takeOffer = ways(idx+1, prices, offer-1, n, dp);
            return dp[idx][offer] = Math.min(takeOffer, notTakeOffer);
        } 

        return dp[idx][offer] = prices[idx] + ways(idx+1, prices, idx+1, n, dp);
    }
}