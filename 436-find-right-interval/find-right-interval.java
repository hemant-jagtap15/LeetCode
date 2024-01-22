class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            int min = (int)(1e9);
            int minIdx = -1;
            for(int j = 0; j < n; j++) {
                if(intervals[j][0] >= intervals[i][1] && min > intervals[j][0]) {
                    min = intervals[j][0];
                    minIdx = j;
                }
            }
            res[i] = minIdx;
        }
        return res;
    }
}