class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxHoriCons = 0;
        int maxVertCons = 0;
        
        for(int i = 0; i < hBars.length; i++) {
            int currCons = 1;
            while(i+1 < hBars.length && hBars[i]+1 == hBars[i+1]) {
                i++;
                currCons++;
            }
            maxHoriCons = Math.max(maxHoriCons, currCons);
        }
        
        for(int i = 0; i < vBars.length; i++) {
            int currCons = 1;
            while(i+1 < vBars.length && vBars[i]+1 == vBars[i+1]) {
                i++;
                currCons++;
            }
            maxVertCons = Math.max(maxVertCons, currCons);
        }
        
        int val = Math.min(maxVertCons + 1, maxHoriCons + 1);
        return val * val;
    }
}
