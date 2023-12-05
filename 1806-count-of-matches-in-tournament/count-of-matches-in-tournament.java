class Solution {
    public int numberOfMatches(int n) {
        return ways(n);
    }
    
    public int ways(int n) {
        if(n == 1) {
            return 0;
        }
        if(n % 2 == 0) {
            return (n / 2) + ways(n/2);
        } else {
            return (n - 1) / 2 + ways((n - 1) / 2 + 1);
        }
    }
}