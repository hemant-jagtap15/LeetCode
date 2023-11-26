class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][n+1];

        for(int idx = n-1; idx >= 0; idx--) {
            for(int offer = n; offer >= 0; offer--) {
                if(offer > 0) {
                    int notTakeOffer = prices[idx] + dp[idx+1][idx+1];
                    int takeOffer = dp[idx+1][offer-1];
                    dp[idx][offer] = Math.min(takeOffer, notTakeOffer);
                } else {
                    dp[idx][offer] = prices[idx] + dp[idx+1][idx+1];
                }
            }
        }
        return dp[0][0];
    }

    // public int ways(int idx, int prices[], int offer, int n, int dp[][]) {
    //     if(idx == n) return 0;
        
    //     if(dp[idx][offer] != -1) return dp[idx][offer];

    //     if(offer > 0) {
    //         int notTakeOffer = prices[idx] + ways(idx+1, prices, idx+1, n, dp);
    //         int takeOffer = ways(idx+1, prices, offer-1, n, dp);
    //         return dp[idx][offer] = Math.min(takeOffer, notTakeOffer);
    //     } 

    //     return dp[idx][offer] = prices[idx] + ways(idx+1, prices, idx+1, n, dp);
    // }
}