class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {

        int maxrightStep = 0;
        for(int i = 0; i < right.length; i++) {
            maxrightStep = Math.max(maxrightStep, n - right[i]);
        }
        
        int maxleftStep = 0;
        for(int i = 0; i < left.length; i++) {
            maxleftStep = Math.max(maxleftStep, left[i]);
        }
        return Math.max(maxleftStep, maxrightStep);
    }
}