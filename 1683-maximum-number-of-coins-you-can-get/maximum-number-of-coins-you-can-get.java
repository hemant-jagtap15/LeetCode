class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int bob = 0;
        int x = n-2;
        int alice = n-1;

        int me = 0;

        while(bob < x) {
            me += piles[x];
            bob += 1;
            x -= 2;
            alice -= 2;
        }
        return me;
    }
}