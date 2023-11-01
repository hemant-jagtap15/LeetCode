class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return ways(0, n, s, dp);
    }

    public int ways(int i, int n, String s, int dp[]) {
        if(i == n) {
            return 1;
        }
        if(dp[i] != -1) return dp[i];
        int singlePick = 0;
        if(s.charAt(i) != '0') {
            singlePick = ways(i+1, n, s, dp);
        }

        int doublePick = 0;
        if(i + 2 <= n) {
            int val = Integer.parseInt(s.substring(i, i+2));
            if(val >= 10 && val <= 26) {
                doublePick = ways(i+2, n, s, dp);
            }
        }

        return dp[i] = singlePick + doublePick;
    }
}