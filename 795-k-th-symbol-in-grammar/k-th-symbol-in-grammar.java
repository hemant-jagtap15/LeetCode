class Solution {
    public int kthGrammar(int n, int k) {
        return ways(n, k);
    }

    public int ways(int n, int k) {
        if(n == 1 && k == 1) return 0;
        int length = (int)Math.pow(2, n-1);
        int mid = length / 2;

        if(k <= mid) {
            return ways(n-1, k);
        } 
        return 1 - ways(n-1, k - mid);
    }
}