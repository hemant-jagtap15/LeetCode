class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minDis = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if(minDis == 0) {
            if(t == 1) return false;
            else return true;
        }
        return t >= minDis;
    }
}