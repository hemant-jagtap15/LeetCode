public class Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt = cnt + (n & 1);
            n = n >>> 1;
        }
        return cnt;
    }
}