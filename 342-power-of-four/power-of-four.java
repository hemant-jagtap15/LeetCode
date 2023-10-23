class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        //number is power of 4, than it is power of 2 as well (n & (n-1))
        //with this number - 1 is also divisible by 3
        if((n & (n-1)) == 0 && (n-1) % 3 == 0) return true;
        return false;
    }
}